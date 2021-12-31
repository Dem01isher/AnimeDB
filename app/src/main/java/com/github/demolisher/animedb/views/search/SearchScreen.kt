package com.github.demolisher.animedb.views.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 *  Created by Android Studio on 12/21/2021 5:48 PM
 *  Developer: Sergey Leskov
 */

@Composable
fun SearchScreen(
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