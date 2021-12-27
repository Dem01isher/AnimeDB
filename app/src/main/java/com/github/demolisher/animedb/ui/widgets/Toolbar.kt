package com.github.demolisher.animedb.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/**
 *  Created by Android Studio on 12/20/2021 3:53 PM
 *  Developer: Sergey Leskov
 */

@Composable
fun ToolbarWithIcon(
    text: String,
    action: () -> Unit,
    backgroundColor: Color = Color.DarkGray,
    contentColor: Color = Color.White
) {
    TopAppBar(
        elevation = 6.dp,
        backgroundColor = backgroundColor,
        modifier = Modifier.height(58.dp),
        contentColor = contentColor
    ) {
        Row {
            Spacer(modifier = Modifier.width(10.dp))

            Icon(
                imageVector = Icons.Filled.ArrowBack,
                tint = Color.White,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .clickable {
                        action()
                    }
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterVertically),
                text = text ?: "",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun Toolbar(
    text: String,
    backgroundColor: Color = Color.DarkGray,
    contentColor: Color = Color.White
) {
    TopAppBar(
        elevation = 6.dp,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(horizontalArrangement = Arrangement.Center) {
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = text ?: "",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}