package ru.toxyxd.feature.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import ru.toxyxd.feature.core.DestNode
import ru.toxyxd.feature.core.NavigationEntry
import ru.toxyxd.feature.core.NestedFeatureEntry
import ru.toxyxd.feature.core.ProvidesBottomNavigation

abstract class HomeFeature : NestedFeatureEntry, ProvidesBottomNavigation {
    override val startDestination = Routes.MainScreen.url

    override val graphRoute = Routes.NavGraph

    override val bottomNavigationEntries: List<NavigationEntry> = listOf(
        NavigationEntry(
            route = Routes.MainScreen.url,
            name = R.string.home,
            icon = { Icons.Rounded.Home }
        )
    )

    internal object Routes {
        const val NavGraph = "@home"

        val MainScreen = DestNode("home")
    }
}