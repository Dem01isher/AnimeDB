package com.github.demolisher.animedb.views.list_of_manga

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.demolisher.animedb.data.AnimeRepository
import com.github.demolisher.animedb.domain.response.AnimeResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *  Created by Android Studio on 12/21/2021 6:30 PM
 *  Developer: Sergey Leskov
 */

@HiltViewModel
class ListOfMangaVIewModel @Inject constructor(private val repository: AnimeRepository): ViewModel() {

    val listOfMangas = MutableLiveData<List<AnimeResponse>>()

    init {
        viewModelScope.launch {
            listOfMangas.postValue(repository.getMangas())
        }
    }
}