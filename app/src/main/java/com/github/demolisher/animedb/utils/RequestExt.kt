package com.github.demolisher.animedb.utils

import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

/**
 *  Created by Android Studio on 12/26/2021 1:06 AM
 *  Developer: Sergey Leskov
 */

fun Any.toRequestBody(): RequestBody {
    val regJson = Gson().toJson(this)
    return regJson.toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
}