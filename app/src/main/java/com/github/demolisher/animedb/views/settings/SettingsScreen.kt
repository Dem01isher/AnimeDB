package com.github.demolisher.animedb.views.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.github.demolisher.animedb.ui.screens.Screen
import com.github.demolisher.animedb.views.main.components.NavDrawerItems

/**
 *  Created by Android Studio on 12/24/2021 11:08 AM
 *  Developer: Sergey Leskov
 */

@Composable
fun SettingsScreen(navController: NavController) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = NavDrawerItems.Settings.title)
    }
}