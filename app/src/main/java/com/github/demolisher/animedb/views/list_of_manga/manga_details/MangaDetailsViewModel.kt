package com.github.demolisher.animedb.views.list_of_manga.manga_details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.demolisher.animedb.data.manga.MangaRepository
import com.github.demolisher.animedb.domain.response.AnimeResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *  Created by Android Studio on 12/27/2021 12:50 AM
 *  Developer: Sergey Leskov
 */

@HiltViewModel
class MangaDetailsViewModel @Inject constructor(
    private val mangaRepository: MangaRepository,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    val loadingState: MutableState<Boolean> = mutableStateOf(false)

    val anime = MutableLiveData<AnimeResponse>()

    fun getMangaById(){
        viewModelScope.launch {
            loadingState.value = true
            delay(1000)
            anime.postValue(mangaRepository.getDataById(savedStateHandle.get<Int>("id") ?: 0))
            loadingState.value = false
        }
    }
}