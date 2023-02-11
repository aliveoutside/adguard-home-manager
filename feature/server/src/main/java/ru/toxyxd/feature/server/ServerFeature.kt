package ru.toxyxd.feature.server

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Devices
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.List
import ru.toxyxd.feature.core.DestNode
import ru.toxyxd.feature.core.NavigationEntry
import ru.toxyxd.feature.core.NestedFeatureEntry
import ru.toxyxd.feature.core.ProvidesBottomNavigation

abstract class ServerFeature : NestedFeatureEntry, ProvidesBottomNavigation {
    override val startDestination = Routes.Server.url

    override val graphRoute = Routes.NavGraph

    override val bottomNavigationEntries: List<NavigationEntry> =
        listOf(
            NavigationEntry(
                route = Routes.Server.url,
                name = R.string.status,
                icon = { Icons.Rounded.Info }
            ),
            NavigationEntry(
                route = Routes.Clients.url,
                name = R.string.clients,
                icon = { Icons.Rounded.Devices },
            ),
            NavigationEntry(
                route = Routes.Logs.url,
                name = R.string.logs,
                icon = { Icons.Rounded.List },
            )
        )

    internal object Routes {
        const val NavGraph = "@server"

        val Server = DestNode("server")
        val Clients = DestNode("clients")
        val Logs = DestNode("logs")
    }
}