package resharker.jiracli

import io.ktor.client.*
import io.ktor.client.engine.curl.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json as JsonConfig

class JiraClient(
    private val httpClient: HttpClient = HttpClient(Curl) {
        engine {
        }

        install(JsonFeature) {
            serializer = KotlinxSerializer(JsonConfig {
                isLenient = true
                ignoreUnknownKeys = true
                allowSpecialFloatingPointValues = true
                useArrayPolymorphism = false
            })
        }
    },
    private val rootUrl: String,
    private val credentials: JiraCredentials,
) {

    private fun HttpRequestBuilder.configRequest() {
        credentials.apply {
            authenticateRequest()
        }
    }

    suspend fun listProjects(): ArrayList<JiraProject.JiraProjectItem> = httpClient.request {
        url("$rootUrl/rest/api/2/project")
        configRequest()
    }

    suspend fun getProject(id: String): JiraProject.JiraProjectItem = httpClient.request {
        url("$rootUrl/rest/api/2/project/${id}")
        configRequest()
    }

    suspend fun getIssue(key: String): JiraIssue = httpClient.request {
        url("$rootUrl/rest/api/2/issue/${key}")
        configRequest()
    }

    fun close() {
        httpClient.close()
    }
}
