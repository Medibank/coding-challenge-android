package com.medibank.articlesheadlines.navigation

sealed class Screen(val route: String) {
    object Headlines : Screen("headlines")
    object Sources : Screen("sources")
    object Saved : Screen("saved")
}
