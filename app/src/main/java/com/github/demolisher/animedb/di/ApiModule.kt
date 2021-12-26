package com.github.demolisher.animedb.di

import com.github.demolisher.animedb.data.remote.RemoteDataSource
import com.github.demolisher.animedb.data.remote.RemoteDataSourceImpl
import com.github.demolisher.animedb.data.user.AuthRepository
import com.github.demolisher.animedb.data.user.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 *  Created by Android Studio on 12/20/2021 2:47 PM
 *  Developer: Sergey Leskov
 */

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

//    @Singleton
//    @Provides
//    fun provideAnimeRepository(remoteDataSource: RemoteDataSource) =
//        AnimeRepository(remoteDataSource)

    @Singleton
    @Provides
    fun provideRemoteDataSource(retrofit: Retrofit): RemoteDataSource =
        RemoteDataSourceImpl(retrofit = retrofit)

    @Provides
    fun provideAuthRepository(remoteDataSource: RemoteDataSource): AuthRepository =
        AuthRepositoryImpl(remoteDataSource)
}