package com.freedasd.rickandmorty.domain.mappers

import com.freedasd.rickandmorty.data.mappers.CharacterListDataToDomainMapper
import com.freedasd.rickandmorty.data.modules.CharacterData
import com.freedasd.rickandmorty.domain.modules.CharactersListDomain

class BaseCharacterListDataToDomainMapper(
    private val characterDataToDomainMapper: BaseCharacterDataToDomainMapper
): CharacterListDataToDomainMapper {

    override fun mapSuccess(list: List<CharacterData>) = CharactersListDomain.Success(list.map{ it.mapToDomain(characterDataToDomainMapper) })

    override fun mapFail(ex: Exception) = CharactersListDomain.Fail(ex)
}