package com.github.demolisher.animedb.ui.screens

/**
 *  Created by Android Studio on 12/22/2021 2:43 PM
 *  Developer: Sergey Leskov
 */

sealed class Screen(val route: String){
    object SplashScreen : Screen("splash_screen")
    object LoginScreen : Screen("login_screen")
    object MainScreen : Screen("main_screen")
    object SearchScreen : Screen("search_screen")
    object AnimeDetailsScreen : Screen("anime_details")
    object MangaDetailsScreen : Screen("manga_details")
}
