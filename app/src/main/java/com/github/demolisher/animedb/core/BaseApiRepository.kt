package com.github.demolisher.animedb.core

import com.github.demolisher.animedb.domain.network.NetworkResult
import kotlinx.coroutines.flow.Flow

/**
 *  Created by Android Studio on 12/25/2021 4:38 PM
 *  Developer: Sergey Leskov
 */

interface BaseApiRepository<T> {

    suspend fun getAllData(page: Int) : List<T>

    suspend fun getDataById(id: Int) : T?
}