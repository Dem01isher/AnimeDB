package com.github.demolisher.animedb.views.list_of_anime.anime_details.components

import android.content.Intent
import android.net.Uri
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.palette.graphics.Palette
import com.github.demolisher.animedb.domain.data.VideoData
import com.github.demolisher.animedb.ui.network_image.NetworkImage
import com.skydoves.landscapist.palette.BitmapPalette

/**
 *  Created by Android Studio on 12/25/2021 1:15 AM
 *  Developer: Sergey Leskov
 */

@Composable
fun AnimeDetailVideos(
    animeData: List<VideoData>
) {

    Column {

        Divider(modifier = Modifier.padding(start = 4.dp, end = 4.dp, bottom = 4.dp))
        Text(
            text = "Videos",
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.caption,
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(com.github.demolisher.animedb.R.string.trailers),
            style = MaterialTheme.typography.h6,
            color = Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
        )

        LazyRow(
            modifier = Modifier
                .padding(horizontal = 15.dp)
        ) {

            items(items = animeData) { video ->

                VideoThumbnail(video)

                Spacer(modifier = Modifier.width(12.dp))
            }
        }
    }

}

@Composable
private fun VideoThumbnail(
    video: VideoData
) {
    val context = LocalContext.current

    Surface(
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp,
    ) {

        ConstraintLayout(
            modifier = Modifier
                .width(150.dp)
                .height(100.dp)
                .clickable(
                    onClick = {
                        val playVideoIntent = Intent(Intent.ACTION_VIEW, Uri.parse(video.url))
                        context.startActivity(playVideoIntent)
                    }
                )
        ) {
            val (thumbnail, icon, box, title) = createRefs()

            var palette by remember { mutableStateOf<Palette?>(null) }
            NetworkImage(
                networkUrl = video.imgUrl,
                modifier = Modifier
                    .fillMaxSize()
                    .constrainAs(thumbnail) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    },
                bitmapPalette = BitmapPalette {
                    palette = it
                }
            )

            Image(
                painter = painterResource(id = com.github.demolisher.animedb.R.drawable.ic_youtube),
                contentDescription = null,
                modifier = Modifier
                    .width(30.dp)
                    .height(20.dp)
                    .constrainAs(icon) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )

            Crossfade(
                targetState = palette,
                modifier = Modifier
                    .height(25.dp)
                    .constrainAs(box) {
                        bottom.linkTo(parent.bottom)
                    }
            ) {

                Box(
                    modifier = Modifier
                        .background(Color(it?.darkVibrantSwatch?.rgb ?: 0))
                        .alpha(0.7f)
                        .fillMaxSize()
                )
            }

            Text(
                text = video.name ?: "",
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .alpha(0.85f)
                    .padding(horizontal = 8.dp)
                    .constrainAs(title) {
                        top.linkTo(box.top)
                        bottom.linkTo(box.bottom)
                    }
            )
        }
    }
}