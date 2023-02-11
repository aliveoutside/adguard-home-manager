package ru.toxyxd.adguardhome.data.repository

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.appendPathSegments
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import ru.toxyxd.adguardhome.data.utils.BaseRequestFlow
import ru.toxyxd.adguardhome.domain.model.stats.AdGuardStats
import ru.toxyxd.adguardhome.domain.repository.StatsRepository

class StatsRepositoryImpl(
    private val baseRequestFlow: BaseRequestFlow
) : StatsRepository {
    override suspend fun getStats(): AdGuardStats = withContext(Dispatchers.IO) {
        baseRequestFlow().first().let { (client, requestBuilder) ->
            client.get {
                requestBuilder(this)
                url {
                    it.appendPathSegments("stats")
                }
            }.body()
        }
    }
}

