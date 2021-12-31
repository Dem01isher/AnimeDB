package com.github.demolisher.animedb.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.github.demolisher.animedb.ui.screens.Screen
import com.github.demolisher.animedb.views.AnimatedSplashScreen
import com.github.demolisher.animedb.views.list_of_anime.anime_details.AnimeDetailsScreen
import com.github.demolisher.animedb.views.list_of_manga.manga_details.MangaDetailsScreen
import com.github.demolisher.animedb.views.main.MainScreen
import com.google.accompanist.insets.ProvideWindowInsets

/**
 *  Created by Android Studio on 12/22/2021 5:08 PM
 *  Developer: Sergey Leskov
 */

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    ProvideWindowInsets {
        NavHost(
            navController = navController,
            startDestination = Screen.SplashScreen.route
        ) {
            composable(route = Screen.SplashScreen.route) {
                AnimatedSplashScreen(navController = navController)
            }
            composable(route = Screen.MainScreen.route) {
                MainScreen(navController)
            }
            composable(
                route = Screen.AnimeDetailsScreen.route.plus("/{id}"),
                arguments = listOf(navArgument(name = "id") {
                    type = NavType.IntType
                })
            ) { backStackEntry ->
                val id = backStackEntry.arguments?.getInt("id") ?: 0
                AnimeDetailsScreen(id = id) {
                    navController.popBackStack()
                }
            }
            composable(
                route = Screen.MangaDetailsScreen.route.plus("/{id}"),
                arguments = listOf(navArgument(name = "id") {
                    type = NavType.IntType
                })
            ) { backStackEntry ->
                val id = backStackEntry.arguments?.getInt("id") ?: 0
                MangaDetailsScreen(id = id) {
                    navController.popBackStack()
                }
            }
        }

    }
}