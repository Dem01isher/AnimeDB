package com.github.demolisher.animedb.views.list_of_anime.anime_details.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

/**
 *  Created by Android Studio on 12/25/2021 12:07 AM
 *  Developer: Sergey Leskov
 */

@Composable
fun AnimeDescription(
    description: String
) {

    var expanded by remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Divider(modifier = Modifier.padding(bottom = 4.dp))
        Text(
            text = "Description",
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.caption,
        )
        Spacer(modifier = Modifier.height(4.dp))

        if (expanded) {
            Text(
                text = description,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded }
            )
        } else {
            Text(
                text = description,
                style = MaterialTheme.typography.body2,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded }
            )
        }

    }
}