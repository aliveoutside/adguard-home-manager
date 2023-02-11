package ru.toxyxd.feature.server.status

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.toxyxd.adguardhome.uikit.page.PageLayout
import ru.toxyxd.feature.server.status.component.card.StatusCardsGrid
import ru.toxyxd.feature.server.status.component.chart.StatusCharts

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun StatusScreen(
    viewModel: StatusViewModel = hiltViewModel()
) {
    val scrollState = rememberScrollState()
    val tas = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val appBarTitle = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(text = appBarTitle.value)
                }, scrollBehavior = tas
            )
        }, modifier = Modifier
            .nestedScroll(tas.nestedScrollConnection)
            .fillMaxSize(),
        contentWindowInsets = WindowInsets(0.dp)
    ) { paddings ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddings)
        ) {
            PageLayout(state = viewModel.state, onReload = viewModel::reload) { homePage ->
                appBarTitle.value = homePage.status.dnsAddresses[0]
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                        .padding(16.dp)
                ) {
                    StatusCardsGrid(
                        homePage = homePage
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    StatusCharts(
                        homePage = homePage
                    )
                }
            }
        }
    }
}