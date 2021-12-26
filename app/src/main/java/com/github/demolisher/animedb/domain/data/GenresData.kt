package com.github.demolisher.animedb.domain.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 *  Created by Android Studio on 12/24/2021 8:32 PM
 *  Developer: Sergey Leskov
 */

@Parcelize
data class GenresData(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("russian")
    val russian: String,
    @SerializedName("kind")
    val kind: String
) : Parcelable
