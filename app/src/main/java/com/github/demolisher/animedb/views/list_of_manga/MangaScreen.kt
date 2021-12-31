package com.github.demolisher.animedb.views.list_of_manga

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.github.demolisher.animedb.domain.response.AnimeResponse
import com.github.demolisher.animedb.ui.shimmer.ListOfShimmerItems
import com.github.demolisher.animedb.views.list_of_anime.components.CustomItem
import com.google.accompanist.insets.statusBarsPadding

/**
 *  Created by Android Studio on 12/20/2021 9:53 PM
 *  Developer: Sergey Leskov
 */

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun MangaScreen(
    viewModel: ListOfMangaViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
    navigateToDetails: (Int) -> Unit
) {

    val listOfManga: LazyPagingItems<AnimeResponse> =
        viewModel.listOfManga.collectAsLazyPagingItems()

    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = modifier
            .padding(6.dp)
            .statusBarsPadding()
    ) {
        items(listOfManga.itemCount) { position ->
            listOfManga[position]?.let { item ->
                CustomItem(anime = item, navigateToDetails = navigateToDetails)
            }
        }
    }

    if (listOfManga.loadState.refresh == LoadState.Loading) {
        ListOfShimmerItems()
    }
    if (listOfManga.loadState.append == LoadState.Loading) {
        ListOfShimmerItems()
    }
}