package com.github.demolisher.animedb.data.anime

import com.github.demolisher.animedb.core.BaseApiRepository
import com.github.demolisher.animedb.data.remote.RemoteDataSource
import com.github.demolisher.animedb.domain.network.NetworkResult
import com.github.demolisher.animedb.domain.response.AnimeResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 *  Created by Android Studio on 12/20/2021 1:06 PM
 *  Developer: Sergey Leskov
 */

class AnimeRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    BaseApiRepository<AnimeResponse> {

    override suspend fun getAllData(page: Int): List<AnimeResponse> =
        remoteDataSource.getAnime(page = page)

    override suspend fun getDataById(id: Int): AnimeResponse? =
        remoteDataSource.getAnimeById(id)
}