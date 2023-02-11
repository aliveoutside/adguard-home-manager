package ru.toxyxd.feature.home.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import ru.toxyxd.adguardhome.uikit.page.PageLayout
import ru.toxyxd.feature.home.ui.component.Server
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun HomeScreen(
    onServerClicked: (String) -> Unit,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Home") },
            )
        }
    ) { innerPadding ->
        PageLayout(
            state = viewModel.state,
            onReload = viewModel::reload,
        ) { servers ->
            Box(Modifier.padding(innerPadding)) {
                LazyColumn {
                    servers.forEach { serverModel ->
                        item {
                            Server(
                                name = serverModel.name,
                                address = "${serverModel.host}:${serverModel.port}",
                                onConnectClicked = {
                                    onServerClicked(serverModel.name)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}