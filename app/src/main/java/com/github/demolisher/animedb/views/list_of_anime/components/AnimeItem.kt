package com.github.demolisher.animedb.views.list_of_anime.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.demolisher.animedb.domain.response.AnimeResponse
import com.github.demolisher.animedb.utils.NetworkUrls
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

/**
 *  Created by Android Studio on 12/20/2021 10:24 PM
 *  Developer: Sergey Leskov
 */

@ExperimentalMaterialApi
@Composable
fun CustomItem(
    anime: AnimeResponse,
    navigateToDetails: (Int) -> Unit,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier
            .padding(6.dp)
            .clickable { navigateToDetails(anime.id) }
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
            val imageUrl = NetworkUrls.URL_WEBSITE + anime.images.original
            GlideImage(
                imageModel = imageUrl,
                contentScale = ContentScale.Crop,
                circularReveal = CircularReveal(duration = 250),
                modifier = Modifier.size(width = 368.dp, height = 150.dp)
            )
            Text(text = anime.name, maxLines = 1, modifier = Modifier.padding(start = 4.dp))
        }
    }
}

@Composable
@Preview
fun PreviewAnimeItem() {

}

