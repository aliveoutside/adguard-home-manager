package ru.toxyxd.adguardhome.data.repository

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.appendPathSegments
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import ru.toxyxd.adguardhome.data.utils.BaseRequestFlow
import ru.toxyxd.adguardhome.domain.model.safeSearch.AdGuardSafeSearchStatus
import ru.toxyxd.adguardhome.domain.repository.SafeSearchRepository

class SafeSearchRepositoryImpl(
    private val baseRequestFlow: BaseRequestFlow
) : SafeSearchRepository {
    override suspend fun getSafeSearchStatus(): AdGuardSafeSearchStatus =
        withContext(Dispatchers.IO) {
            baseRequestFlow().first().let { (client, requestBuilder) ->
                client.get {
                    requestBuilder(this)
                    url {
                        it.appendPathSegments("safesearch/status")
                    }
                }.body()
            }
        }
}