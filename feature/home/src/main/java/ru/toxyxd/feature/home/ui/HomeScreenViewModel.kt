package ru.toxyxd.feature.home.ui

import dagger.hilt.android.lifecycle.HiltViewModel
import ru.toxyxd.adguardhome.domain.model.Server
import ru.toxyxd.adguardhome.domain.repository.StorageRepository
import ru.toxyxd.adguardhome.uikit.vm.PageViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val settingsRepository: StorageRepository
) : PageViewModel<List<Server>>() {
    init {
        reload()
    }

    override suspend fun load(): List<Server> {
        return settingsRepository.getFakeServers()
    }
}