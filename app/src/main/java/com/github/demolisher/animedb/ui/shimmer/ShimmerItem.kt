package com.github.demolisher.animedb.ui.shimmer

import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.github.demolisher.animedb.utils.NetworkUrls
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

/**
 *  Created by Android Studio on 12/27/2021 12:10 AM
 *  Developer: Sergey Leskov
 */

@Composable
fun ShimmerItem(brush: Brush) {

    Card(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth(),
        border = BorderStroke(
            width = 1.dp, color = Color.LightGray
        )
    ) {
        Column(
            modifier = Modifier
//                .padding(start = 16.dp, top = 16.dp, end = 16.dp)
            ,
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(
                modifier = Modifier
                    .size(width = 368.dp, height = 150.dp)
                    .background(brush = brush)
            )
            Spacer(modifier = Modifier
                .padding(start = 4.dp)
                .background(brush)
                .fillMaxWidth())
        }
    }

//    Column(modifier = Modifier.padding(16.dp)) {
//        Spacer(
//            modifier = Modifier
//                .fillMaxWidth()
//                .size(250.dp)
//                .background(brush = brush)
//        )
//        Spacer(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(30.dp)
//                .padding(vertical = 8.dp)
//                .background(brush = brush)
//        )
//    }
}

@Composable
fun ShimmerAnimation(
) {
    val shimmerColorShades = listOf(

        Color.LightGray.copy(0.9f),

        Color.LightGray.copy(0.2f),

        Color.LightGray.copy(0.9f)

    )

    /*
     Create InfiniteTransition
     which holds child animation like [Transition]
     animations start running as soon as they enter
     the composition and do not stop unless they are removed
    */
    val transition = rememberInfiniteTransition()
    val translateAnim by transition.animateFloat(
        /*
         Specify animation positions,
         initial Values 0F means it
         starts from 0 position
        */
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(


            // Tween Animates between values over specified [durationMillis]
            tween(durationMillis = 1200, easing = FastOutSlowInEasing),
            RepeatMode.Reverse
        )
    )

    /*
      Create a gradient using the list of colors
      Use Linear Gradient for animating in any direction according to requirement
      start=specifies the position to start with in cartesian like system Offset(10f,10f) means x(10,0) , y(0,10)
      end = Animate the end position to give the shimmer effect using the transition created above
    */
    val brush = Brush.linearGradient(
        colors = shimmerColorShades,
        start = Offset(10f, 10f),
        end = Offset(translateAnim, translateAnim)
    )

    ShimmerItem(brush = brush)
}

@ExperimentalFoundationApi
@Composable
fun ListOfShimmerItems() {
    LazyVerticalGrid(cells = GridCells.Fixed(2), modifier = Modifier.fillMaxSize()){
        repeat(10){
            item {
                ShimmerAnimation()
            }
        }
    }
}