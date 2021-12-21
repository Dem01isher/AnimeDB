package com.github.demolisher.animedb.di

import com.github.demolisher.animedb.data.AnimeRepository
import com.github.demolisher.animedb.data.AnimeRepositoryImpl
import com.github.demolisher.animedb.data.remote.RemoteDataSource
import com.github.demolisher.animedb.data.remote.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

/**
 *  Created by Android Studio on 12/20/2021 2:47 PM
 *  Developer: Sergey Leskov
 */

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    fun provideAnimeRepository(remoteDataSource: RemoteDataSource): AnimeRepository =
        AnimeRepositoryImpl(remoteDataSource)

    @Provides
    fun provideRemoteDataSource(retrofit: Retrofit): RemoteDataSource =
        RemoteDataSourceImpl(retrofit = retrofit)
}