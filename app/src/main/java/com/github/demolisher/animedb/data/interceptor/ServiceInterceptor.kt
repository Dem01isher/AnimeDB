package com.github.demolisher.animedb.data.interceptor

import android.content.Context
import com.github.demolisher.animedb.utils.SharedPreferenceManager
import okhttp3.Interceptor
import okhttp3.Response

/**
 *  Created by Android Studio on 12/25/2021 9:55 PM
 *  Developer: Sergey Leskov
 */



class ServiceInterceptor(
    private val sharedPreferenceManager: SharedPreferenceManager
) : Interceptor {

    companion object{
        const val HARD_CODE_TOKEN = "nRDwoew9VmJoDJ6xYzXHcUG5YfXgJleAoaEcKFCC16U"
        const val HARD_CODE_CLIENT_SECRET = "OlNVwsBTSezrk-4YZM3OV5Yiaw34KXm9Fb14c_VF26Y"
        const val HARD_CODE_CLIENT_ID = "nRDwoew9VmJoDJ6xYzXHcUG5YfXgJleAoaEcKFCC16U"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val xToken = sharedPreferenceManager.userToken

        val builder = chain.request().newBuilder().apply {
            addHeader("content-type", "application/json; charset=utf-8")
            addHeader("x-frame-options", "SAMEORIGIN")
            addHeader("x-content-type-options", "nosniff")
            addHeader("referrer-policy", "strict-origin-when-cross-origin")
            addHeader("cf-cache-status", "DYNAMIC")
            addHeader("server", "cloudflare")
            addHeader("client_id", HARD_CODE_CLIENT_ID)
            addHeader("client_secret", HARD_CODE_CLIENT_SECRET)
            addHeader("User-Agent", "AnimeDB")
        }

//        if (xToken.isNullOrEmpty()) {
//            builder.addHeader("x-token", HARD_CODE_TOKEN)
//        } else {
//            builder.addHeader("x-token", xToken)
//        }

        return chain.proceed(builder.build())
    }
}