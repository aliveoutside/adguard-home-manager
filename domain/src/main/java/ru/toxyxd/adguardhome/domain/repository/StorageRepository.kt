package ru.toxyxd.adguardhome.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.toxyxd.adguardhome.domain.model.Server

interface StorageRepository {
    fun getServers(): List<Server>
    fun getFakeServers(): List<Server>
    fun getSelectedServer(): Flow<Server>
    fun setSelectedServer(server: Server)
}