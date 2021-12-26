package com.github.demolisher.animedb.data.manga

import com.github.demolisher.animedb.core.BaseApiRepository
import com.github.demolisher.animedb.data.remote.RemoteDataSource
import com.github.demolisher.animedb.domain.response.AnimeResponse
import javax.inject.Inject

/**
 *  Created by Android Studio on 12/25/2021 7:37 PM
 *  Developer: Sergey Leskov
 */

class MangaRepository @Inject constructor(private val repository: RemoteDataSource) : BaseApiRepository<AnimeResponse> {

    override suspend fun getAllData(page: Int): List<AnimeResponse> =
        repository.getMangas(page = page)

    override suspend fun getDataById(id: Int): AnimeResponse? =
        repository.getMangaById(id)
}