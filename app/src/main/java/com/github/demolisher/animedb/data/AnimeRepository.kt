package com.github.demolisher.animedb.data

import com.github.demolisher.animedb.domain.response.AnimeResponse

/**
 *  Created by Android Studio on 12/20/2021 1:06 PM
 *  Developer: Sergey Leskov
 */

interface AnimeRepository {

    suspend fun getAnime(page: Int): List<AnimeResponse>

    suspend fun getAnimeById(id: Int): AnimeResponse

    suspend fun getMangas() : List<AnimeResponse>

    suspend fun searchByName(name: String)
}