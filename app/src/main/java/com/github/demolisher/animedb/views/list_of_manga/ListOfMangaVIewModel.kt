package com.github.demolisher.animedb.views.list_of_manga

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.github.demolisher.animedb.data.anime.AnimeRepository
import com.github.demolisher.animedb.data.manga.MangaRepository
import com.github.demolisher.animedb.domain.response.AnimeResponse
import com.github.demolisher.animedb.utils.AnimeSource
import com.github.demolisher.animedb.utils.MangaSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 *  Created by Android Studio on 12/21/2021 6:30 PM
 *  Developer: Sergey Leskov
 */

@HiltViewModel
class ListOfMangaViewModel @Inject constructor(private val repository: MangaRepository): ViewModel() {

    val listOfManga: Flow<PagingData<AnimeResponse>> =
        Pager(PagingConfig(pageSize = 1)) {
            MangaSource(repository)
        }.flow.cachedIn(viewModelScope)


}