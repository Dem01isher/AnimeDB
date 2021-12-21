package com.github.demolisher.animedb.ui.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


/**
 *  Created by Android Studio on 12/20/2021 3:53 PM
 *  Developer: Sergey Leskov
 */

@Composable
fun Toolbar(
    text: String,
    action: () -> Unit,
    backgroundColor: Color = Color.DarkGray,
    contentColor: Color = Color.White,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = text)
                },
                navigationIcon = {
                    IconButton(onClick = action) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                },
                backgroundColor = backgroundColor,
                contentColor = contentColor,
                elevation = 12.dp
            )
        }, content = {

        })
}