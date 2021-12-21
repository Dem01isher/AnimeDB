package com.github.demolisher.animedb.ui.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.github.demolisher.animedb.ui.bottom_nav.BottomNavItems

/**
 *  Created by Android Studio on 12/20/2021 4:15 PM
 *  Developer: Sergey Leskov
 */

@Composable
fun BottomNavBar(
    items: List<BottomNavItems>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItems) -> Unit
) {

    val backStackEntry = navController.currentBackStackEntryAsState()

    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.DarkGray,
        elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.title
                        )
                        if (selected) {
                            Text(text = item.title, textAlign = TextAlign.Center, fontSize = 10.sp)
                        }
                    }
                }, selectedContentColor = Color.Green, unselectedContentColor = Color.Gray
            )
        }
    }
    Divider(color = Color.LightGray, modifier = Modifier.fillMaxWidth())
}