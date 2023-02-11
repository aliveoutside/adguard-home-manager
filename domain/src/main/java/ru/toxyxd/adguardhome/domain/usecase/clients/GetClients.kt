package ru.toxyxd.adguardhome.domain.usecase.clients

import ru.toxyxd.adguardhome.domain.model.clients.AdGuardClients
import ru.toxyxd.adguardhome.domain.repository.ClientsRepository
import javax.inject.Inject

class GetClients @Inject constructor(
    private val clientsRepository: ClientsRepository
) {
    suspend operator fun invoke(): ClientsPage {
        return ClientsPage(
            clients = clientsRepository.getClients()
        )
    }

    data class ClientsPage(
        val clients: AdGuardClients
    )
}