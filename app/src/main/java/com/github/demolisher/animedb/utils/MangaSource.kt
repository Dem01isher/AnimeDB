package com.github.demolisher.animedb.utils

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.demolisher.animedb.data.manga.MangaRepository
import com.github.demolisher.animedb.domain.response.AnimeResponse
import retrofit2.HttpException
import javax.inject.Inject

/**
 *  Created by Android Studio on 12/23/2021 12:09 PM
 *  Developer: Sergey Leskov
 */

class MangaSource @Inject constructor(private val repository: MangaRepository) :
    PagingSource<Int, AnimeResponse>() {

    override fun getRefreshKey(state: PagingState<Int, AnimeResponse>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, AnimeResponse> {
        val page = params.key ?: 1
        return try {
            val data = repository.getAllData(page)
            LoadResult.Page(
                data = data,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (data.isEmpty()) null else page + 1
            )

        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}