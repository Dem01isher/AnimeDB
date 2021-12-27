package com.github.demolisher.animedb.views.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.github.demolisher.animedb.domain.network.MainScreenHomeTab
import com.github.demolisher.animedb.domain.response.AnimeResponse
import com.github.demolisher.animedb.ui.widgets.SearchBar
import com.github.demolisher.animedb.views.main.MainViewModel
import com.github.demolisher.animedb.views.search.components.SearchList
import com.github.demolisher.animedb.views.search.components.SearchView

/**
 *  Created by Android Studio on 12/21/2021 5:48 PM
 *  Developer: Sergey Leskov
 */

@Composable
fun SearchScreen(
    viewModel: MainViewModel = hiltViewModel(),
    onSelectedItem: (Int) -> Unit
) {

//    val textState = remember { mutableStateOf(TextFieldValue("")) }
//    val resultSearch = viewModel.resultSearchList.observeAsState(initial = listOf())

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Search")
    }
}