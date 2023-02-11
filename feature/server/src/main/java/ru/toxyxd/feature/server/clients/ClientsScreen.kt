package ru.toxyxd.feature.server.clients

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.toxyxd.adguardhome.uikit.page.PageLayout
import ru.toxyxd.feature.server.R
import ru.toxyxd.feature.server.clients.component.AutoClient
import ru.toxyxd.feature.server.clients.component.Client

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
internal fun ClientsScreen(
    viewModel: ClientsViewModel = hiltViewModel()
) {
    val tas = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val swipeRefreshState =
        rememberPullRefreshState(viewModel.isRefreshing, onRefresh = viewModel::swipeRefreshReload)

    Scaffold(
        topBar = {
            LargeTopAppBar(title = {
                Text(text = stringResource(R.string.clients))
            }, scrollBehavior = tas)
        }, modifier = Modifier
            .nestedScroll(tas.nestedScrollConnection)
            .fillMaxSize(),
        contentWindowInsets = WindowInsets(0.dp)
    ) { paddings ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .pullRefresh(swipeRefreshState)
                .padding(paddings)
        ) {
            PageLayout(state = viewModel.state, onReload = viewModel::reload) { clientsPage ->
                Column(Modifier.fillMaxSize()) {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        contentPadding = PaddingValues(16.dp),
                        modifier = Modifier
                            .nestedScroll(tas.nestedScrollConnection)
                    ) {
                        items(clientsPage.clients.clients) { client ->
                            Client(client = client)
                        }
                        item {
                            Text(
                                style = MaterialTheme.typography.headlineMedium,
                                text = stringResource(id = R.string.auto_clients),
                            )
                        }
                        items(clientsPage.clients.autoClients) { client ->
                            AutoClient(client = client)
                        }
                    }
                }
            }

            PullRefreshIndicator(
                refreshing = viewModel.isRefreshing,
                state = swipeRefreshState,
                modifier = Modifier.align(
                    Alignment.TopCenter
                )
            )
        }
    }
}