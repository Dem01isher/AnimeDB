package com.github.demolisher.animedb.ui.bottom_nav

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.github.demolisher.animedb.domain.response.AnimeResponse
import com.github.demolisher.animedb.ui.widgets.SearchBar
import com.github.demolisher.animedb.utils.ErrorItem
import com.github.demolisher.animedb.utils.LoadingItem
import com.github.demolisher.animedb.utils.LoadingView
import com.github.demolisher.animedb.views.list_of_anime.ListOfAnimeViewModel

/**
 *  Created by Android Studio on 12/20/2021 9:51 PM
 *  Developer: Sergey Leskov
 */

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun AnimeScreen(viewModel: ListOfAnimeViewModel = hiltViewModel()) {
    val listOfAnime : LazyPagingItems<AnimeResponse> = viewModel.listOfAnime.collectAsLazyPagingItems()
//    val listData = viewModel.listOfItems.observeAsState()
    Column(modifier = Modifier.padding(6.dp)) {
        Text(text = "Popular", fontSize = 24.sp, fontStyle = FontStyle.Normal, fontFamily = FontFamily.Serif)

        LazyColumn(){
            items(listOfAnime){ item ->
                CustomItem(anime = item!!)
            }
        }
        listOfAnime.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    LoadingView(modifier = Modifier.fillMaxSize())
                }
                loadState.append is LoadState.Loading -> {
                    LoadingItem()
                }
                loadState.append is LoadState.Error -> {
                    val error = this.loadState.append as LoadState.Error
                    ErrorItem(message = error.error.localizedMessage) {
                        retry()
                    }
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
@Preview(showBackground = true)
fun PreviewAnimeScreen() {
    AnimeScreen()
}