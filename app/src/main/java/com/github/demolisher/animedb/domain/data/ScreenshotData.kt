package com.github.demolisher.animedb.domain.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 *  Created by Android Studio on 12/25/2021 2:07 AM
 *  Developer: Sergey Leskov
 */

@Parcelize
data class ScreenshotData(
    val original: String,
    val preview: String
) : Parcelable
