package com.github.demolisher.animedb.domain.response

import android.os.Parcelable
import com.github.demolisher.animedb.domain.data.*
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
    @SerializedName("russian")
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
    val releasedOn: String,
    @SerializedName("rating")
    val rating: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("description_html")
    val descriptionHtml: String,
    @SerializedName("description_source")
    val descriptionSource: String,
    @SerializedName("franchise")
    val franchise: String,
    @SerializedName("favoured")
    val favoured: Boolean,
    @SerializedName("anons")
    val anons: Boolean,
    @SerializedName("ongoing")
    val ongoing: Boolean,
    @SerializedName("thread_id")
    val threadId: Int,
    @SerializedName("topic_id")
    val topicId: Int,
    @SerializedName("rates_statuses_stats")
    val ratesStatusesStats: List<RatesStatusesStatsData>,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("genres")
    val genres: List<GenresData>,
    @SerializedName("videos")
    val videos: List<VideoData>,
    @SerializedName("screenshots")
    val screenshots: List<ScreenshotData>


) : Parcelable
