package ru.toxyxd.feature.server

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import ru.toxyxd.adguardhome.domain.repository.StorageRepository
import ru.toxyxd.feature.core.Destinations
import ru.toxyxd.feature.server.clients.ClientsScreen
import ru.toxyxd.feature.server.logs.LogsScreen
import ru.toxyxd.feature.server.status.StatusScreen
import javax.inject.Inject

@OptIn(ExperimentalAnimationApi::class)
class ServerFeatureImpl @Inject constructor(
    val storageRepository: StorageRepository
) : ServerFeature() {
    override fun NavGraphBuilder.buildGraph(
        navController: NavHostController,
        destinations: Destinations
    ) {
        composable(Routes.Server.url) {
            StatusScreen()
        }
        composable(Routes.Clients.url) {
            ClientsScreen()
        }
        composable(Routes.Logs.url) {
            LogsScreen()
        }
    }
}