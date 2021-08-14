package com.lexadiky.usecase

import com.lexadiky.service.PokemonService

class CountPokemonUseCase(private val service: PokemonService) {

    fun run(): Int = service.pokemon.size
}