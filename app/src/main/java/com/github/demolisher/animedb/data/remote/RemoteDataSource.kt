package com.github.demolisher.animedb.data.remote

import com.github.demolisher.animedb.BuildConfig
import com.github.demolisher.animedb.domain.data.UserData
import com.github.demolisher.animedb.domain.network.NetworkResult
import com.github.demolisher.animedb.domain.response.AnimeResponse
import com.github.demolisher.animedb.domain.response.AuthTokenResponse
import com.github.demolisher.animedb.utils.NetworkUrls
import kotlinx.coroutines.flow.Flow
import okhttp3.RequestBody
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

    @POST(NetworkUrls.USER_SIGN_IN)
    suspend fun authWithEmailAndPassword(
        @Query("nickname") nickname: String,
        @Query("password") password: String
    ): AuthTokenResponse

//    @GET()
//    suspend fun getAuthCode(
//        clientId: String,
//        redirectUri: String? = NetworkUrls.REDIRECT_URI,
//        responseType: String = "code",
//        scope: String
//    ) : AuthTokenResponse

    @POST(NetworkUrls.TOKEN)
    suspend fun getAccessToken(
        @Query("grant_type") grantType: String,
        @Query("client_id") clientId: String,
        @Query("client_secret") clientSecret: String,
        @Query("code") code: String? = null,
        @Query("redirect_uri") redirectUri: String? = NetworkUrls.REDIRECT_URI,
        @Query("refresh_token") refreshToken: String? = null
    ): AuthTokenResponse
}