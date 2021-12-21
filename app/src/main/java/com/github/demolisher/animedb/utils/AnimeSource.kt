package com.github.demolisher.animedb.utils

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.demolisher.animedb.data.AnimeRepository
import com.github.demolisher.animedb.domain.response.AnimeResponse
import retrofit2.HttpException
import java.io.IOException

/**
 *  Created by Android Studio on 12/21/2021 9:47 PM
 *  Developer: Sergey Leskov
 */

class AnimeSource(private val repository: AnimeRepository) : PagingSource<Int, AnimeResponse>() {

    override fun getRefreshKey(state: PagingState<Int, AnimeResponse>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state?.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, AnimeResponse> {
        val page = params.key ?: 1
        return try {
            val data = repository.getAnime(page)
            LoadResult.Page(data = data,
            prevKey = if (page == 1) null else page -1,
            nextKey = if (data.isEmpty()) null else page + 1)

        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}