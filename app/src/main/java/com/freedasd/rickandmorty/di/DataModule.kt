package com.freedasd.rickandmorty.di

import com.freedasd.rickandmorty.data.BaseRepository
import com.freedasd.rickandmorty.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindRepository(impl: BaseRepository) : Repository
}