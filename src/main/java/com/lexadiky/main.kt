package com.lexadiky

import com.google.gson.Gson
import com.lexadiky.service.PokemonService

fun main() {
    PokemonService(Gson()).pokemon
        .flatMap { it.types }
        .distinct()
        .forEach { println(it) }
}