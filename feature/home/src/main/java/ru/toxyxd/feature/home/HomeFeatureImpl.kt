package ru.toxyxd.feature.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import ru.toxyxd.adguardhome.domain.repository.StorageRepository
import ru.toxyxd.feature.core.Destinations
import ru.toxyxd.feature.core.ext.navigateRoot
import ru.toxyxd.feature.core.find
import ru.toxyxd.feature.home.ui.HomeScreen
import ru.toxyxd.feature.server.ServerFeature
import javax.inject.Inject

class HomeFeatureImpl @Inject constructor(
    private val storageRepository: StorageRepository
) : HomeFeature() {

    @OptIn(ExperimentalAnimationApi::class)
    override fun NavGraphBuilder.buildGraph(
        navController: NavHostController,
        destinations: Destinations
    ) {
        composable(Routes.MainScreen.url) {
            HomeScreen(
                onServerClicked = {
                    storageRepository.setSelectedServer(
                        storageRepository.getFakeServers().first { servers ->
                            servers.name == it
                        }
                    )
                    navController.navigateRoot(
                        destinations.find<ServerFeature>().graphRoute
                    )
                }
            )
        }
    }
}