package com.github.demolisher.animedb.data.remote

import com.github.demolisher.animedb.domain.response.AnimeResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 *  Created by Android Studio on 12/20/2021 1:05 PM
 *  Developer: Sergey Leskov
 */

interface RemoteDataSource {

    companion object {
        const val BASE_URL = "https://shikimori.one/api/"
    }

    @GET("animes")
    suspend fun getAnime(@Query("limit") limit: Int = 50, @Query("page") page: Int): List<AnimeResponse>

    @GET("mangas")
    suspend fun getMangas(@Query("limit") limit: Int = 50) : List<AnimeResponse>

    @GET("animes/{id}")
    suspend fun getAnimeById(@Query ("id") id: Int) : AnimeResponse

    @GET("animes/{name}")
    suspend fun searchByName(@Query("name") name: String)

}