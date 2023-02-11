package ru.toxyxd.adguardhome.domain.repository

import ru.toxyxd.adguardhome.domain.model.safeBrowsing.AdGuardSafeBrowsingStatus

interface SafeBrowsingRepository {
    suspend fun getSafeBrowsingStatus(): AdGuardSafeBrowsingStatus
}