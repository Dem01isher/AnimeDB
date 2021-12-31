package com.github.demolisher.animedb.data.remote

import com.github.demolisher.animedb.domain.response.AnimeResponse
import retrofit2.Retrofit
import javax.inject.Inject

/**
 *  Created by Android Studio on 12/20/2021 1:05 PM
 *  Developer: Sergey Leskov
 */

class RemoteDataSourceImpl @Inject constructor(private val retrofit: Retrofit) : RemoteDataSource {

    private val api = retrofit.create(RemoteDataSource::class.java)

    override suspend fun getAnime(limit: Int, page: Int): List<AnimeResponse> =
        api.getAnime(page = page)

    override suspend fun getAnimeById(id: Int): AnimeResponse = api.getAnimeById(id)

    override suspend fun getMangaById(id: Int): AnimeResponse = api.getMangaById(id)

    override suspend fun getMangas(limit: Int, page: Int): List<AnimeResponse> =
        api.getMangas(page = page)

    override suspend fun searchAnimeByName(name: String): AnimeResponse =
        api.searchAnimeByName(name)

}