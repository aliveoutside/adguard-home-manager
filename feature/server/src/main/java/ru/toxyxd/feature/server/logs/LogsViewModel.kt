package ru.toxyxd.feature.server.logs

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import ru.toxyxd.adguardhome.data.pagingsource.LogsPagingSource
import ru.toxyxd.adguardhome.domain.model.logs.Log
import ru.toxyxd.adguardhome.domain.repository.LogsRepository
import ru.toxyxd.adguardhome.uikit.vm.PageViewModel
import javax.inject.Inject

@HiltViewModel
class LogsViewModel @Inject constructor(
    private val logsRepository: LogsRepository
) : PageViewModel<Flow<PagingData<Log>>>() {
    init {
        reload()
    }

    override suspend fun load(): Flow<PagingData<Log>> =
        Pager(
            pagingSourceFactory = { LogsPagingSource(logsRepository) },
            config = PagingConfig(pageSize = 20)
        ).flow.cachedIn(viewModelScope)
}