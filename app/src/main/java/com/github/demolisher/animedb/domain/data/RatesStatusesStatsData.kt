package com.github.demolisher.animedb.domain.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 *  Created by Android Studio on 12/24/2021 8:29 PM
 *  Developer: Sergey Leskov
 */

@Parcelize
data class RatesStatusesStatsData(
    @SerializedName("name")
    val name: String,
    @SerializedName("value")
    val value: Int
) : Parcelable
