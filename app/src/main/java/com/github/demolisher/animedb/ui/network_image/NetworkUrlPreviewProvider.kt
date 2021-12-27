package com.github.demolisher.animedb.ui.network_image

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.github.demolisher.animedb.R

/**
 *  Created by Android Studio on 12/25/2021 1:31 AM
 *  Developer: Sergey Leskov
 */

class NetworkUrlPreviewProvider : PreviewParameterProvider<Int> {
    override val count: Int
        get() = super.count
    override val values: Sequence<Int>
        get() = sequenceOf(R.drawable.ic_youtube)
}