package com.github.demolisher.animedb.views.list_of_anime

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.github.demolisher.animedb.ui.shimmer.ListOfShimmerItems
import com.github.demolisher.animedb.utils.ErrorItem
import com.github.demolisher.animedb.utils.LoadingItem
import com.github.demolisher.animedb.utils.LoadingView
import com.github.demolisher.animedb.views.list_of_anime.components.CustomItem
import com.google.accompanist.insets.statusBarsPadding

/**
 *  Created by Android Studio on 12/20/2021 9:51 PM
 *  Developer: Sergey Leskov
 */

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun AnimeScreen(
    viewModel: ListOfAnimeViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
    navigateToDetails: (Int) -> Unit
) {

    val listOfAnime = viewModel.listOfAnime.collectAsLazyPagingItems()

    Column(
        modifier = Modifier
            .padding(6.dp)
    ) {
        LazyVerticalGrid(
            cells = GridCells.Adaptive(minSize = 128.dp),
            modifier = modifier.statusBarsPadding()
        ) {
            items(listOfAnime.itemCount) { positiom ->
                listOfAnime[positiom]?.let { anime ->
                    CustomItem(anime = anime, navigateToDetails = {
                        navigateToDetails.invoke(anime.id)
                    })
                }
            }
        }
        if (listOfAnime.loadState.refresh == LoadState.Loading) {
            ListOfShimmerItems()
        }
        if (listOfAnime.loadState.append == LoadState.Loading) {
            ListOfShimmerItems()
        }
    }

}