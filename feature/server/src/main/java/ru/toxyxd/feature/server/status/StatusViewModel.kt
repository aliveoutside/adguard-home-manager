package ru.toxyxd.feature.server.status

import dagger.hilt.android.lifecycle.HiltViewModel
import ru.toxyxd.adguardhome.domain.usecase.server.GetServerHome
import ru.toxyxd.adguardhome.uikit.vm.PageViewModel
import javax.inject.Inject

@HiltViewModel
class StatusViewModel @Inject constructor(
    private val getServerHome: GetServerHome
) : PageViewModel<GetServerHome.ServerHomePage>() {

    init {
        reload()
    }

    override suspend fun load(): GetServerHome.ServerHomePage {
        return getServerHome()
    }
}