package ru.toxyxd.feature.core.ext

import androidx.navigation.NavController

fun NavController.navigateRoot(
    route: String
) = navigate(route) {
    popUpTo(ROOT_NAV_GRAPH_ID)
}

const val ROOT_NAV_GRAPH_ID = "nav_graph"