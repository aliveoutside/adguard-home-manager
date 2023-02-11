package ru.toxyxd.adguardhome.domain.model.parental

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class AdGuardParentalStatus(
    @SerialName("enabled")
    val enabled: Boolean,
    @SerialName("sensitivity")
    val sensitivity: Int? = null,
)