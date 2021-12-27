package com.github.demolisher.animedb.views.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.github.demolisher.animedb.R
import com.github.demolisher.animedb.ui.drawer.Drawer
import com.github.demolisher.animedb.views.main.components.NavDrawer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 *  Created by Android Studio on 12/23/2021 12:35 PM
 *  Developer: Sergey Leskov
 */

@OptIn(ExperimentalFoundationApi::class)
@ExperimentalMaterialApi
@Composable
fun MainScreen(mainNavHostController: NavHostController) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    // If you want the drawer from the right side, uncomment the following
    // CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState) },
        drawerBackgroundColor = Color.DarkGray,
        // scrimColor = Color.Red,  // Color for the fade background when you open/close the drawer
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        },
    ) {
        NavDrawer(navController, mainNavHostController)
    }
}

@Composable
fun TopBar(scope: CoroutineScope, scaffoldState: ScaffoldState) {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name), fontSize = 18.sp) },
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }) {
                Icon(Icons.Filled.Menu, "")
            }
        },
        backgroundColor = Color.DarkGray,
        contentColor = Color.White
    )
}