package com.github.demolisher.animedb.ui.bottom_nav

import androidx.annotation.DrawableRes
import com.github.demolisher.animedb.R

/**
 *  Created by Android Studio on 12/20/2021 4:19 PM
 *  Developer: Sergey Leskov
 */

sealed class BottomNavItems(val route: String, val title: String, @DrawableRes val icon: Int){
    object Anime : BottomNavItems("anime_screen", "Anime", R.drawable.ic_tv)
    object Manga : BottomNavItems("manga_screen", "Manga", R.drawable.ic_book)
    object Search : BottomNavItems("search_screen", "Search", R.drawable.ic_search)
}
