package com.freedasd.rickandmorty.di

import com.freedasd.rickandmorty.presentation.CharacterListRender
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PresentationModule {

    @Binds
    abstract fun bindCharacterListRender(base: CharacterListRender.Base) : CharacterListRender
}