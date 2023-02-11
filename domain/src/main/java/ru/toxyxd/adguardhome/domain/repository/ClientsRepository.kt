package ru.toxyxd.adguardhome.domain.repository

import ru.toxyxd.adguardhome.domain.model.clients.AdGuardClients

interface ClientsRepository {
    suspend fun getClients(): AdGuardClients
}