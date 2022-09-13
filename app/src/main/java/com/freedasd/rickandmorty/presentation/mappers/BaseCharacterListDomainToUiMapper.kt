package com.freedasd.rickandmorty.presentation.mappers

import com.freedasd.rickandmorty.domain.mappers.CharacterListDomainToUiMapper
import com.freedasd.rickandmorty.domain.modules.CharacterDomain
import com.freedasd.rickandmorty.presentation.modules.CharacterListUi
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class BaseCharacterListDomainToUiMapper @Inject constructor(
    private val characterDomainToUiMapper: BaseCharacterDomainToUiMapper
) : CharacterListDomainToUiMapper {

    override fun mapSuccess(list: List<CharacterDomain>) = CharacterListUi.Success(list.map { it.mapToUi(characterDomainToUiMapper) })

    override fun mapFail(e: Exception) = CharacterListUi.Fail(e)
}