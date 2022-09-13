package com.freedasd.rickandmorty.di

import com.freedasd.rickandmorty.domain.Interactor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindInteractor(base: Interactor.Base) : Interactor
}