package com.github.demolisher.animedb.views.main.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.github.demolisher.animedb.ui.screens.Screen
import com.github.demolisher.animedb.views.list_of_anime.AnimeScreen
import com.github.demolisher.animedb.views.list_of_manga.MangaScreen
import com.github.demolisher.animedb.views.search.SearchScreen
import com.github.demolisher.animedb.views.settings.SettingsScreen

/**
 *  Created by Android Studio on 12/24/2021 10:42 AM
 *  Developer: Sergey Leskov
 */

@OptIn(ExperimentalMaterialApi::class)
@ExperimentalFoundationApi
@Composable
fun NavDrawer(navHostController: NavHostController, mainNavHostController: NavHostController) {
    NavHost(navHostController, startDestination = NavDrawerItems.AnimeScreen.route) {
        composable(NavDrawerItems.AnimeScreen.route) {
            AnimeScreen(){
                mainNavHostController.navigate(route = Screen.AnimeDetailsScreen.route.plus("/${it}"))
            }
        }
        composable(NavDrawerItems.MangaScreen.route) {
            MangaScreen(){
                mainNavHostController.navigate(route = Screen.MangaDetailsScreen.route.plus("/${it}"))
            }
        }
        composable(NavDrawerItems.Settings.route) {
            SettingsScreen(mainNavHostController)
        }
        composable(Screen.SearchScreen.route){
            SearchScreen(){
                mainNavHostController.navigate(route = Screen.AnimeDetailsScreen.route.plus("/${it}"))
            }
        }
    }
} 