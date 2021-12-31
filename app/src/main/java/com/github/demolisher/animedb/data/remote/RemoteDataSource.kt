package com.github.demolisher.animedb.data.remote

import com.github.demolisher.animedb.domain.response.AnimeResponse
import com.github.demolisher.animedb.utils.NetworkUrls
import retrofit2.http.*

/**
 *  Created by Android Studio on 12/20/2021 1:05 PM
 *  Developer: Sergey Leskov
 */

interface RemoteDataSource {

    @GET(NetworkUrls.ANIMES)
    suspend fun getAnime(
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int
    ): List<AnimeResponse>

    @GET(NetworkUrls.MANGAS)
    suspend fun getMangas(
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int
    ): List<AnimeResponse>

    @GET(NetworkUrls.ANIME_BY_ID)
    suspend fun getAnimeById(@Path("id") id: Int): AnimeResponse

    @GET(NetworkUrls.MANGA_BY_ID)
    suspend fun getMangaById(@Path("id") id: Int): AnimeResponse

    @GET(NetworkUrls.SEARCH_ANIME)
    suspend fun searchAnimeByName(@Path("name") name: String): AnimeResponse

//    @GET()
//    suspend fun getAuthCode(
//        clientId: String,
//        redirectUri: String? = NetworkUrls.REDIRECT_URI,
//        responseType: String = "code",
//        scope: String
//    ) : AuthTokenResponse

}