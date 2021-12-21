package com.github.demolisher.animedb.domain.network

/**
 *  Created by Android Studio on 12/20/2021 2:51 PM
 *  Developer: Sergey Leskov
 */

sealed class NetworkResult<out T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success : NetworkResult<Nothing>()
    class Loading : NetworkResult<Nothing>()
    class Error<T>(message: String? = null, data: T? = null) : NetworkResult<T>()
}
