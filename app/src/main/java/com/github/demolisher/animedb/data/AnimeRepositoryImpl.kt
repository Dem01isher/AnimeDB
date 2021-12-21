package com.github.demolisher.animedb.data

import com.github.demolisher.animedb.data.remote.RemoteDataSource
import com.github.demolisher.animedb.domain.response.AnimeResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Query
import javax.inject.Inject

/**
 *  Created by Android Studio on 12/20/2021 1:06 PM
 *  Developer: Sergey Leskov
 */

class AnimeRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) : AnimeRepository {

    override suspend fun getAnime(page: Int): List<AnimeResponse> = remoteDataSource.getAnime(page = page)

    override suspend fun getAnimeById(id: Int): AnimeResponse = remoteDataSource.getAnimeById(id)

    override suspend fun getMangas(): List<AnimeResponse> = remoteDataSource.getMangas(50)

    override suspend fun searchByName(name: String) = remoteDataSource.searchByName(name)
}