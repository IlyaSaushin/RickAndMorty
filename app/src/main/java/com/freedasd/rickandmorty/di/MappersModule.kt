package com.freedasd.rickandmorty.di

import com.freedasd.rickandmorty.data.mappers.CharacterDataToDomainMapper
import com.freedasd.rickandmorty.data.mappers.CharacterListDataToDomainMapper
import com.freedasd.rickandmorty.domain.mappers.BaseCharacterDataToDomainMapper
import com.freedasd.rickandmorty.domain.mappers.BaseCharacterListDataToDomainMapper
import com.freedasd.rickandmorty.domain.mappers.CharacterDomainToUiMapper
import com.freedasd.rickandmorty.presentation.mappers.BaseCharacterDomainToUiMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MappersModule {

    @Binds
    abstract fun bindCharacterDataToDomainMapper(base: BaseCharacterDataToDomainMapper) : CharacterDataToDomainMapper

    @Binds
    abstract fun bindCharacterListDataToDomainMapper(base: BaseCharacterListDataToDomainMapper) : CharacterListDataToDomainMapper

    @Binds
    abstract fun bindCharacterDomainToUiMapper(base: BaseCharacterDomainToUiMapper) : CharacterDomainToUiMapper

    @Binds
    abstract fun bindCharacterListDomainToUiMapper(base: BaseCharacterDomainToUiMapper) : CharacterDomainToUiMapper
}