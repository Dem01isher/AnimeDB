package com.github.demolisher.animedb.views

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.github.demolisher.animedb.R
import com.github.demolisher.animedb.ui.screens.Screen
import kotlinx.coroutines.delay

/**
 *  Created by Android Studio on 12/22/2021 2:24 PM
 *  Developer: Sergey Leskov
 */

@Composable
fun AnimatedSplashScreen(navController: NavHostController) {
    var startAnimation by remember {
        mutableStateOf(false)
    }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 3000)
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(route = Screen.MainScreen.route)
    }
    Splash(alphaAnim.value)
}

@Composable
fun Splash(alpha: Float) {
    Box(
        modifier =
        Modifier
            .background(Color.DarkGray)
            .fillMaxSize(
            )
            .alpha(alpha = alpha),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier
                    .size(120.dp)
                    .padding(vertical = 16.dp),
                painter = painterResource(id = R.drawable.ic_shikimori_logo),
                contentDescription = null,
                tint = Color.White
            )
            Text(
                text = stringResource(id = R.string.app_name),
                fontSize = 26.sp,
                fontFamily = FontFamily.Serif
            )
        }
    }
}