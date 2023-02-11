package ru.toxyxd.adguardhome.domain.repository

import ru.toxyxd.adguardhome.domain.model.filtering.AdGuardFilteringStatus

interface FilteringRepository {
    suspend fun getFilteringStatus(): AdGuardFilteringStatus
}