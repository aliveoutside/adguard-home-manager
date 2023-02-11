package ru.toxyxd.adguardhome.domain.repository

import ru.toxyxd.adguardhome.domain.model.global.AdGuardStatus

interface GlobalRepository {
    suspend fun getStatus(): AdGuardStatus
}