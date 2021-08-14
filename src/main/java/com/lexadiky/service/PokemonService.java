package com.lexadiky.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lexadiky.entity.Pokemon;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;

public class PokemonService {

    private final Type pokemonType = new TypeToken<List<Pokemon>>() {}.getType();
    private final Gson gson;

    public PokemonService(Gson gson) {
        this.gson = gson;
    }

    public List<Pokemon> getPokemon() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream("pokemon.json");
        if (stream == null) {
            throw new IOException("Can't find file pokemon.json");
        }
        Scanner scanner = new Scanner(stream);
        StringBuilder jsonBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {
            jsonBuilder.append(scanner.nextLine());
        }
        return gson.fromJson(jsonBuilder.toString(), pokemonType);
    }
}
