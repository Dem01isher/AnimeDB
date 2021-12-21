package com.github.demolisher.animedb.views.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.navigation.compose.rememberNavController
import com.github.demolisher.animedb.ui.navigation.Navigation
import com.github.demolisher.animedb.ui.bottom_nav.BottomNavItems
import com.github.demolisher.animedb.ui.theme.AnimeDBTheme
import com.github.demolisher.animedb.ui.widgets.BottomNavBar
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AnimeDBTheme {

                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Scaffold(bottomBar = {
                    BottomNavBar(
                        items = listOf(
                            BottomNavItems.Anime,
                            BottomNavItems.Manga,
                            BottomNavItems.Search
                        ),
                        navController = navController,
                        onItemClick = {
                            navController.navigate(it.route)
                        }
                    )
                }) {
                    Navigation(navController = navController)
                }
            }
        }
    }
}