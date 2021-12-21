package com.github.demolisher.animedb.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.github.demolisher.animedb.ui.bottom_nav.AnimeScreen
import com.github.demolisher.animedb.ui.bottom_nav.MangaScreen
import com.github.demolisher.animedb.views.search.SearchScreen

/**
 *  Created by Android Studio on 12/20/2021 5:46 PM
 *  Developer: Sergey Leskov
 */

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "anime_screen") {
        composable("anime_screen") {
            AnimeScreen()
        }
        composable("manga_screen") {
            MangaScreen()
        }
        composable(route = "search_screen"){
            SearchScreen()
        }
    }
}