import io.ktor.http.*

interface JiraCredentials {
    fun HttpMessageBuilder.authenticateRequest()
}
