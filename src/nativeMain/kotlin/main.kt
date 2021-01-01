import io.ktor.http.*
import io.ktor.util.*
import kotlinx.coroutines.*
import platform.posix.exit

fun main(args: Array<String>) = runBlocking {
    val jira = jiraClient() ?: run {
        exit(1)
        return@runBlocking
    }
    val jobs = mutableListOf<Job>()

    supervisorScope {

        jobs += launch {
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
        }

        jobs += launch {
            if (args.any { it == "projects" } && args.any { it == "dump" }) {
                println(jira.listProjects())
            }
        }
    }

    while (jobs.any { it.isActive }) {
        delay(100)
    }
    jobs.joinAll()

    jira.close()
    exit(0)
}

fun jiraClient(): JiraClient? = runCatching {
    JiraClient(
        rootUrl = requireEnv("JIRA_ROOT").also { rootUrl ->
            require(rootUrl.matches("https?://\\S+".toRegex())) {
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

private fun extractIssueKeys(args: Array<String>) =
    args.mapNotNull { arg -> "(\\w{1,5}+-\\d{1,5},?)+".toRegex().matchEntire(arg)?.groupValues }.flatten().distinct()

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
