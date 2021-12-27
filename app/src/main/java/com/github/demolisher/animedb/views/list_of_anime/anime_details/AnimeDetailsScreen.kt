package com.github.demolisher.animedb.views.list_of_anime.anime_details

import android.text.Html
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.palette.graphics.Palette
import com.github.demolisher.animedb.domain.response.AnimeResponse
import com.github.demolisher.animedb.ui.rating_star.RatingBar
import com.github.demolisher.animedb.ui.widgets.ToolbarWithIcon
import com.github.demolisher.animedb.utils.LoadingView
import com.github.demolisher.animedb.utils.NetworkUrls
import com.github.demolisher.animedb.views.list_of_anime.anime_details.components.*


/**
 *  Created by Android Studio on 12/21/2021 3:17 PM
 *  Developer: Sergey Leskov
 */

@Composable
fun AnimeDetailsScreen(
    id: Int,
    viewModel: AnimeDetailsViewModel = hiltViewModel(),
    pressOnBack: () -> Unit
) {

    LaunchedEffect(key1 = id) {
        viewModel.getAnimeById()
    }

    val animeData = viewModel.anime.observeAsState()

    val scrollState = rememberScrollState()
    Column(modifier = Modifier.fillMaxSize()) {

        if (viewModel.loadingState.value) {
            LoadingView(modifier = Modifier.fillMaxSize())
        }
        BoxWithConstraints {
            Surface() {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState),
                ) {
                    Column() {
                        ToolbarWithIcon(text = animeData?.value?.name ?: "", action = { pressOnBack() })
                    }
                    AnimeHeader(
                        poster = NetworkUrls.URL_WEBSITE + animeData.value?.images?.original
                    )
                    AnimeContent(
                        animeResponse = animeData,
                        containerHeight = this@BoxWithConstraints.maxHeight
                    )
                }
            }
        }
    }

}

@Composable
private fun AnimeContent(animeResponse: State<AnimeResponse?>, containerHeight: Dp) {

    var palette by remember { mutableStateOf<Palette?>(null) }
    Column {
        AnimeTitle(animeResponse.value?.name ?: "", animeResponse.value?.favoured == true)
        RatingBar(
            rating = (animeResponse.value?.score?.toFloat() ?: 0f) / 2f,
            color = Color(palette?.vibrantSwatch?.rgb ?: 0),
            modifier = Modifier
                .height(15.dp)
                .align(Alignment.CenterHorizontally)
        )
        AnimeProperty("Franchise: ", animeResponse.value?.franchise ?: "")
        AnimeProperty("Date: ", animeResponse.value?.airedOn ?: "")
        AnimeProperty("Status: ", animeResponse.value?.status ?: "")
//        val htmlTextStr = Html.fromHtml(animeResponse.value?.descriptionHtml ?: "", Html.FROM_HTML_MODE_LEGACY).toString()
        AnimeDescription(
            description = Html.fromHtml(
                animeResponse.value?.descriptionHtml ?: "",
                Html.FROM_HTML_MODE_LEGACY
            ).toString()
        )
        GenresList(list = animeResponse.value?.genres ?: listOf())
        AnimeDetailVideos(animeData = animeResponse.value?.videos ?: listOf())

        Spacer(Modifier.height((containerHeight - 560.dp).coerceAtLeast(0.dp)))
    }
}







