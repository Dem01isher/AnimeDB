package com.github.demolisher.animedb.ui.bottom_nav

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.demolisher.animedb.domain.response.AnimeResponse
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

/**
 *  Created by Android Studio on 12/20/2021 10:24 PM
 *  Developer: Sergey Leskov
 */

@ExperimentalMaterialApi
@Composable
fun CustomItem(anime: AnimeResponse) {
    var expanded by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .padding(6.dp)
            .clickable { expanded = !expanded }
            .fillMaxWidth(),
        border = BorderStroke(
            width = 1.dp, color = Color.LightGray
        )
    ) {
        Column(
            modifier = Modifier
//                .padding(start = 16.dp, top = 16.dp, end = 16.dp)
                ,
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            val imageUrl = "https://shikimori.one" + anime.images.original
            GlideImage(
                imageModel = imageUrl,
                contentScale = ContentScale.Crop,
                circularReveal = CircularReveal(duration = 250),
                modifier = Modifier.size(width = 368.dp, height = 150.dp)

            )
            Text(text = anime.name, maxLines = 3, modifier = Modifier.padding(start = 4.dp))
            AnimatedVisibility(visible = expanded) {
                Column(modifier = Modifier.padding(4.dp)) {
                    Text(text = if (anime.status.isNullOrBlank()) "" else "Status: ${anime.status}", maxLines = 2)
                    Text(text = if (anime.airedOn.isNullOrBlank()) "" else "Date: ${anime.airedOn}", maxLines = 2)
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewAnimeItem() {

}

