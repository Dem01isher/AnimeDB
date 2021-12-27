package com.github.demolisher.animedb.views.list_of_anime.anime_details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.demolisher.animedb.data.anime.AnimeRepository
import com.github.demolisher.animedb.data.manga.MangaRepository
import com.github.demolisher.animedb.domain.response.AnimeResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *  Created by Android Studio on 12/21/2021 3:53 PM
 *  Developer: Sergey Leskov
 */

@HiltViewModel
class AnimeDetailsViewModel @Inject constructor(
    private val animeRepository: AnimeRepository,
    private val savedStateHandle: SavedStateHandle
) :
    ViewModel() {

    val loadingState: MutableState<Boolean> = mutableStateOf(false)

    val anime = MutableLiveData<AnimeResponse>()

    fun getAnimeById() {
        viewModelScope.launch {
            loadingState.value = true
            delay(1000)
            anime.postValue(animeRepository.getDataById(savedStateHandle.get<Int>("id") ?: 0))
            loadingState.value = false
        }
    }


}