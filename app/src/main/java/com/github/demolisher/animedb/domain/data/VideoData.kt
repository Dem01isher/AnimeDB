package com.github.demolisher.animedb.domain.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 *  Created by Android Studio on 12/25/2021 1:03 AM
 *  Developer: Sergey Leskov
 */
@Parcelize
data class VideoData(
    @SerializedName("id")
    val id: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("image_url")
    val imgUrl: String,
    @SerializedName("player_url")
    val playerUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("hosting")
    val hosting: String
) : Parcelable
