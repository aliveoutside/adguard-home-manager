package ru.toxyxd.adguardhome.domain.model.safeBrowsing

import kotlinx.serialization.Serializable

@Serializable
data class AdGuardSafeBrowsingStatus(
    val enabled: Boolean
)
