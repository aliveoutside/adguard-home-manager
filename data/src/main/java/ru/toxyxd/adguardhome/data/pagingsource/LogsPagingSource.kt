package ru.toxyxd.adguardhome.data.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ru.toxyxd.adguardhome.domain.model.logs.Log
import ru.toxyxd.adguardhome.domain.repository.LogsRepository
import java.net.URLEncoder

class LogsPagingSource(
    private val logsRepository: LogsRepository
) : PagingSource<String, Log>() {
    override fun getRefreshKey(state: PagingState<String, Log>): String? =
        state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey
        }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, Log> =
        try {
            val page = params.key
            val size = params.loadSize
            val data = logsRepository.getLogs(olderThan = page, limit = size)
            LoadResult.Page(
                data = data.data,
                prevKey = null,
                nextKey = if (data.data.isEmpty()) null else URLEncoder.encode(data.oldest)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
}
