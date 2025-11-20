package com.medibank.articlesheadlines

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.FeaturedPlayList
import androidx.compose.material.icons.filled.Source
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.medibank.articlesheadlines.navigation.AppNavigation
import com.medibank.articlesheadlines.navigation.Screen
import com.medibank.articlesheadlines.ui.theme.ArticlesHeadlinesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArticlesHeadlinesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    
    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { 
                        Icon(
                            imageVector = Icons.Default.FeaturedPlayList,
                            contentDescription = stringResource(R.string.headlines_tab)
                        )
                    },
                    label = { Text(stringResource(R.string.headlines_tab)) },
                    selected = currentDestination?.hierarchy?.any { 
                        it.route == Screen.Headlines.route 
                    } == true,
                    onClick = {
                        navController.navigate(Screen.Headlines.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
                
                NavigationBarItem(
                    icon = { 
                        Icon(
                            imageVector = Icons.Default.Source,
                            contentDescription = stringResource(R.string.sources_tab)
                        )
                    },
                    label = { Text(stringResource(R.string.sources_tab)) },
                    selected = currentDestination?.hierarchy?.any { 
                        it.route == Screen.Sources.route 
                    } == true,
                    onClick = {
                        navController.navigate(Screen.Sources.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
                
                NavigationBarItem(
                    icon = { 
                        Icon(
                            imageVector = Icons.Default.Bookmark,
                            contentDescription = stringResource(R.string.saved_tab)
                        )
                    },
                    label = { Text(stringResource(R.string.saved_tab)) },
                    selected = currentDestination?.hierarchy?.any { 
                        it.route == Screen.Saved.route 
                    } == true,
                    onClick = {
                        navController.navigate(Screen.Saved.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            AppNavigation(navController = navController)
        }
    }
}
