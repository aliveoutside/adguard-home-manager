package ru.toxyxd.adguardhome.domain.repository

import ru.toxyxd.adguardhome.domain.model.safeSearch.AdGuardSafeSearchStatus

interface SafeSearchRepository {
    suspend fun getSafeSearchStatus(): AdGuardSafeSearchStatus
}