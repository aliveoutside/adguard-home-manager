package ru.toxyxd.adguardhome.data.repository

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.flow
import ru.toxyxd.adguardhome.domain.model.Server
import ru.toxyxd.adguardhome.domain.repository.StorageRepository
import javax.inject.Inject

class StorageRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : StorageRepository {
    //private var serversDelegate: ArrayList<Server>? by context.sharedPrefs("servers")
    private var selectedServerDelegate: Server? = null

    override fun getServers(): ArrayList<Server> {
        throw UnsupportedOperationException()
    }

    override fun getFakeServers() = arrayListOf(
        Server(
            "test",
            "192.168.2.1",
            1337,
            "toxyxd",
            "ToxyxD1337"
        )
    )

    override fun getSelectedServer() =
        flow {
            emit(
                selectedServerDelegate ?: throw IllegalArgumentException("Selected server is null")
            )
        }

    override fun setSelectedServer(server: Server) {
        selectedServerDelegate = server
    }
}