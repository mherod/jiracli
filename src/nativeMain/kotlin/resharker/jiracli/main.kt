package resharker.jiracli

import io.ktor.http.*
import io.ktor.util.*

fun main(args: Array<String>) = nativeMain {
    val jira: JiraClient = createJiraClient() ?: error("Couldn't init Jira client")

    if (args.any { it == "issue" } && args.any { it == "summary" }) {
        @Suppress("ConvertCallChainIntoSequence")
        extractIssueKeys(args)
            .map { jira.getIssue(it) }
            .distinctBy(JiraIssue::id)
            .distinctBy(JiraIssue::key)
            .map { issue -> "${issue.key} ${issue.fields.summary}" }
            .distinct()
            .toList()
            .forEach(::println)
    }

    if (args.any { it == "projects" } && args.any { it == "dump" }) {
        println(jira.listProjects())
    }

    jira.close()
}

fun createJiraClient(): JiraClient? = runCatching {
    JiraClient(
        rootUrl = requireEnv("JIRA_ROOT").also { rootUrl ->
            require(isValidUrl(rootUrl)) {
                "JIRA_ROOT should be a valid URL (https://myjira.atlassian.com)"
            }
        },
        credentials = apiTokenCredentials(
            username = requireEnv("JIRA_USER"),
            apiToken = requireEnv("JIRA_TOKEN")
        )
    )
}.onFailure { throwable ->
    println(throwable.message)
}.getOrNull()

private fun extractIssueKeys(args: Array<String>): List<String> {
    return args.mapNotNull { arg -> issueKeyRegex.toRegex().matchEntire(arg)?.groupValues }.flatten().distinct()
}

@OptIn(InternalAPI::class)
private inline fun apiTokenCredentials(
    username: String,
    apiToken: String,
) = object : JiraCredentials {
    override fun HttpMessageBuilder.authenticateRequest() {
        val base64 = "$username:$apiToken".encodeBase64()
        headers["Authorization"] = "Basic $base64"
    }
}
