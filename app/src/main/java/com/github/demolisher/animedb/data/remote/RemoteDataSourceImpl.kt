package com.github.demolisher.animedb.data.remote

import com.github.demolisher.animedb.domain.data.UserData
import com.github.demolisher.animedb.domain.network.NetworkResult
import com.github.demolisher.animedb.domain.response.AnimeResponse
import com.github.demolisher.animedb.domain.response.AuthTokenResponse
import kotlinx.coroutines.flow.Flow
import okhttp3.RequestBody
import retrofit2.Retrofit
import retrofit2.http.Body
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

    override suspend fun authWithEmailAndPassword(
        nickname: String,
        password: String
    ): AuthTokenResponse =
        api.authWithEmailAndPassword(nickname, password)

    override suspend fun getAccessToken(
        grantType: String,
        clientId: String,
        clientSecret: String,
        code: String?,
        redirectUri: String?,
        refreshToken: String?
    ): AuthTokenResponse =
        api.getAccessToken(grantType, clientId, clientSecret, code, redirectUri, refreshToken)
}