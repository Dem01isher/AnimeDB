package com.github.demolisher.animedb.domain.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 *  Created by Android Studio on 12/20/2021 5:08 PM
 *  Developer: Sergey Leskov
 */

@kotlinx.parcelize.Parcelize
data class ImageData(
    @SerializedName("original")
    val original: String,
    @SerializedName("preview")
    val preview: String,
    @SerializedName("x96")
    val x96: String,
    @SerializedName("x48")
    val x48: String
) : Parcelable
