package com.github.demolisher.animedb.ui.bottom_nav

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.demolisher.animedb.views.list_of_manga.ListOfMangaVIewModel

/**
 *  Created by Android Studio on 12/20/2021 9:53 PM
 *  Developer: Sergey Leskov
 */

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun MangaScreen(viewModel: ListOfMangaVIewModel = hiltViewModel()) {

    val listData = viewModel.listOfMangas.observeAsState()

    Column() {

        TopAppBar(
            title = {
                Text(text = "Popular")
            },
            backgroundColor = Color.DarkGray,
            contentColor = Color.White,
            elevation = 12.dp
        )

        LazyVerticalGrid(cells = GridCells.Fixed(2), modifier = Modifier.padding(6.dp)) {
            items(listData.value ?: listOf()) { item ->
                CustomItem(anime = item)
            }
        }

    }
}