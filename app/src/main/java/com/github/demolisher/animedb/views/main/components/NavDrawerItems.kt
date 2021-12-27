package com.github.demolisher.animedb.views.main.components

import androidx.annotation.DrawableRes
import com.github.demolisher.animedb.R

/**
 *  Created by Android Studio on 12/24/2021 10:27 AM
 *  Developer: Sergey Leskov
 */

sealed class NavDrawerItems(val route: String, @DrawableRes val icon: Int, val title: String){
    object AnimeScreen : NavDrawerItems(route = "anime_screen", icon = R.drawable.ic_tv, title = "Anime")
    object MangaScreen : NavDrawerItems(route = "manga_screen", icon = R.drawable.ic_book, title = "Manga")
    object Settings : NavDrawerItems(route = "settings_screen", icon = R.drawable.ic_settings, title = "Settings")
    object SearchScreen : NavDrawerItems(route = "search_screen", icon = R.drawable.ic_search, title = "Search")
}
