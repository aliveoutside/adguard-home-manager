package ru.toxyxd.adguardhome.data.repository

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.appendPathSegments
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import ru.toxyxd.adguardhome.data.utils.BaseRequestFlow
import ru.toxyxd.adguardhome.domain.model.global.AdGuardStatus
import ru.toxyxd.adguardhome.domain.repository.GlobalRepository

class GlobalRepositoryImpl(
    private val baseRequestFlow: BaseRequestFlow
) : GlobalRepository {
    override suspend fun getStatus(): AdGuardStatus = withContext(Dispatchers.IO) {
        baseRequestFlow().first().let { (client, requestBuilder) ->
            client.get {
                requestBuilder(this)
                url {
                    it.appendPathSegments("status")
                }
            }.body()
        }
    }
}