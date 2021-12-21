package com.github.demolisher.animedb.views.search

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import com.github.demolisher.animedb.ui.widgets.SearchBar

/**
 *  Created by Android Studio on 12/21/2021 5:48 PM
 *  Developer: Sergey Leskov
 */
 
@Composable
fun SearchScreen(){
    val text = remember { mutableStateOf(TextFieldValue(""))}
    SearchBar(state = text)
}