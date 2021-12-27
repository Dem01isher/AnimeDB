package com.github.demolisher.animedb.views.list_of_anime.anime_details.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.skydoves.landscapist.glide.GlideImage

/**
 *  Created by Android Studio on 12/25/2021 12:08 AM
 *  Developer: Sergey Leskov
 */

@Composable
fun AnimeHeader(
    poster: String
) {
    GlideImage(
        imageModel = poster, contentScale = ContentScale.Crop,
        contentDescription = null, modifier = Modifier

            .fillMaxWidth()
    )
}