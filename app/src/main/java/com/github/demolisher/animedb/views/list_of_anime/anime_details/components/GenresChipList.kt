package com.github.demolisher.animedb.views.list_of_anime.anime_details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.github.demolisher.animedb.domain.data.GenresData

/**
 *  Created by Android Studio on 12/25/2021 12:12 AM
 *  Developer: Sergey Leskov
 */

@Composable
fun Chip(
    name: String = "Chip",
    isSelected: Boolean = false,
    onSelectionChanged: (String) -> Unit = {},
) {
    Surface(
        modifier = Modifier.padding(end = 4.dp),
        elevation = 8.dp,
        shape = MaterialTheme.shapes.medium,
        color = if (isSelected) Color.LightGray else MaterialTheme.colors.primary
    ) {
        Row(modifier = Modifier
            .toggleable(
                value = isSelected,
                onValueChange = {
                    onSelectionChanged(name)
                }
            )
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.body2,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun ChipGroup(
    genres: List<GenresData>,
    selectedCar: GenresData? = null,
    onSelectedChanged: (String) -> Unit = {},
) {
    Column() {
        LazyRow() {
            items(genres) {
                Chip(
                    name = it.name,
                    isSelected = selectedCar == it,
                    onSelectionChanged = {
                        onSelectedChanged.invoke(it)
                    },
                )
            }
        }
    }
}

@Composable
fun GenresList(list: List<GenresData>) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Text(
            text = "Genres",
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.caption,
        )
        ChipGroup(genres = list)
    }
}