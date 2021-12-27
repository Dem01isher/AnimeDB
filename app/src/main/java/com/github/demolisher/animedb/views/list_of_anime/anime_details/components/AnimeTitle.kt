package com.github.demolisher.animedb.views.list_of_anime.anime_details.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

/**
 *  Created by Android Studio on 12/25/2021 12:06 AM
 *  Developer: Sergey Leskov
 */

@Composable
fun AnimeTitle(title: String, favoured: Boolean) {
    Box(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()) {
        Text(
            text = title,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.TopStart)
        )
        Icon(
            imageVector = if (favoured) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopEnd)
        )
    }
}