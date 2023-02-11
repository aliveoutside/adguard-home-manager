package ru.toxyxd.adguardhome.data.utils

import io.ktor.client.HttpClient
import io.ktor.client.plugins.auth.providers.BasicAuthCredentials
import io.ktor.client.plugins.auth.providers.BasicAuthProvider
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.http.URLProtocol
import io.ktor.http.encodedPath
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import ru.toxyxd.adguardhome.domain.repository.StorageRepository
import javax.inject.Inject

class BaseRequestFlow @Inject constructor(
    storageRepository: StorageRepository,
    private val httpClient: HttpClient
) {
    private val baseRequestFlow: Flow<Pair<HttpClient, HttpRequestBuilder.() -> Unit>> =
        storageRepository.getSelectedServer().map { server ->
            val requestBuilder: HttpRequestBuilder.() -> Unit = {
                url {
                    protocol = URLProtocol.HTTP
                    host = server.host
                    port = server.port
                    encodedPath = "/control/"
                }
                if (server.password.isNotEmpty()) {
                    val authProvider = BasicAuthProvider({
                        BasicAuthCredentials(
                            server.username, server.password
                        )
                    })
                    let {
                        runBlocking {
                            authProvider.addRequestHeaders(it)
                        }
                    }
                }
            }
            Pair(httpClient, requestBuilder)
        }

    operator fun invoke(): Flow<Pair<HttpClient, HttpRequestBuilder.() -> Unit>> = baseRequestFlow
}