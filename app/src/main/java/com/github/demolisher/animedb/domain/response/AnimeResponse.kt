package com.github.demolisher.animedb.domain.response

import android.os.Parcelable
import com.github.demolisher.animedb.domain.data.ImageData
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 *  Created by Android Studio on 12/20/2021 5:06 PM
 *  Developer: Sergey Leskov
 */

@Parcelize
data class AnimeResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("image")
    val images : ImageData,
    @SerializedName("url")
    val url: String,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("score")
    val score: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("episodes")
    val episodes: Int,
    @SerializedName("episodes_aired")
    val episodesAired: Int,
    @SerializedName("aired_on")
    val airedOn: String,
    @SerializedName("released_on")
    val releasedOn: String

) : Parcelable
