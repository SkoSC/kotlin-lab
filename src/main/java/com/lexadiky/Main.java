package com.lexadiky;

import com.google.gson.Gson;
import com.lexadiky.repository.PokemonStatsRepository;
import com.lexadiky.service.PokemonService;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        PokemonService pokemonService = new PokemonService(new Gson());
        PokemonStatsRepository statsRepository = new PokemonStatsRepository(pokemonService);

        System.out.println(statsRepository.getStatistics());
    }
}
