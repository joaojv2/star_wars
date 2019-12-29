package com.joao.santana.data.mappers

import com.joao.santana.data.mappers.base.BaseMapper
import com.joao.santana.data.models.remote.CharactersResponseBody
import com.joao.santana.domain.aggregate.Characters

class CharactersResponseToCharacters(
    private val characterResponseToCharacter: CharacterResponseToCharacter
) : BaseMapper<CharactersResponseBody, Characters> {

    override fun map(input: CharactersResponseBody): Characters {
        return Characters(
            input.count,
            input.next,
            input.previous,
            input.results?.map { characterResponseToCharacter.map(it) }
        )
    }
}