package ru.toxyxd.adguardhome.domain.repository

import ru.toxyxd.adguardhome.domain.model.parental.AdGuardParentalStatus

interface ParentalRepository {
    suspend fun getParentalStatus(): AdGuardParentalStatus
}