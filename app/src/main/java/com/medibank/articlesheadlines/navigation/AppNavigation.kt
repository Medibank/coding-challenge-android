package com.medibank.articlesheadlines.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.medibank.articlesheadlines.ui.headlines.HeadlinesScreen
import com.medibank.articlesheadlines.ui.saved.SavedScreen
import com.medibank.articlesheadlines.ui.sources.SourcesScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Headlines.route
    ) {
        composable(Screen.Headlines.route) {
            HeadlinesScreen(
                onArticleClick = { article ->
                    // TODO: Navigate to article detail/webview
                }
            )
        }
        
        composable(Screen.Sources.route) {
            SourcesScreen()
        }
        
        composable(Screen.Saved.route) {
            SavedScreen()
        }
    }
}
