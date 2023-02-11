package ru.toxyxd.feature.server.clients

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.toxyxd.adguardhome.domain.usecase.clients.GetClients
import ru.toxyxd.adguardhome.uikit.vm.PageViewModel
import javax.inject.Inject

@HiltViewModel
class ClientsViewModel @Inject constructor(
    private val getClients: GetClients
) : PageViewModel<GetClients.ClientsPage>() {
    var isRefreshing by mutableStateOf(false)
        private set

    init {
        reload()
    }

    override suspend fun load(): GetClients.ClientsPage {
        return getClients()
    }

    fun swipeRefreshReload() {
        isRefreshing = true
        viewModelScope.launch {
            setState(load())
            isRefreshing = false
        }
    }
}