package com.freedasd.rickandmorty.di

import com.freedasd.rickandmorty.data.modules.CharacterData
import com.freedasd.rickandmorty.domain.modules.CharacterDomain
import com.freedasd.rickandmorty.presentation.modules.CharacterUi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class EntitiesModule {

    @Binds
    abstract fun bindCharacterData(base: com.freedasd.rickandmorty.data.modules.CharacterData.Base) : CharacterData

    @Binds
    abstract fun bindCharacterDomain(base: CharacterDomain.Base) : CharacterDomain

    @Binds
    abstract fun bindCharacterUi(base: CharacterUi.Base) : CharacterUi
}