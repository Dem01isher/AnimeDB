package com.github.demolisher.animedb.views.list_of_anime

import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.github.demolisher.animedb.data.AnimeRepository
import com.github.demolisher.animedb.domain.network.NetworkResult
import com.github.demolisher.animedb.domain.response.AnimeResponse
import com.github.demolisher.animedb.utils.AnimeSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *  Created by Android Studio on 12/20/2021 5:27 PM
 *  Developer: Sergey Leskov
 */

@HiltViewModel
class ListOfAnimeViewModel @Inject constructor(private val repository: AnimeRepository) :
    ViewModel() {

//    val listOfItems = MutableLiveData<List<AnimeResponse>>()

    val listOfAnime: Flow<PagingData<AnimeResponse>> = Pager(PagingConfig(pageSize = 6)) {
        AnimeSource(repository)
    }.flow.cachedIn(viewModelScope)

    private fun getAnime() {
        viewModelScope.launch {
//            listOfItems.postValue(repository.getAnime())

        }
    }

}