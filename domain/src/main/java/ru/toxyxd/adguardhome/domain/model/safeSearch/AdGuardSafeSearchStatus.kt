package ru.toxyxd.adguardhome.domain.model.safeSearch

import kotlinx.serialization.Serializable

@Serializable
data class AdGuardSafeSearchStatus(
    val enabled: Boolean
)
