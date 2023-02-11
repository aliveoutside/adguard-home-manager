package ru.toxyxd.adguardhome.domain.repository

import ru.toxyxd.adguardhome.domain.model.stats.AdGuardStats

interface StatsRepository {
    suspend fun getStats(): AdGuardStats
}