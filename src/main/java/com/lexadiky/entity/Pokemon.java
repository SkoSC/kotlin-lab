package com.lexadiky.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class Pokemon {

    @SerializedName("id")
    private final int id;
    @SerializedName("name")
    private final Name name;
    @SerializedName("type")
    private final List<String> types;
    @SerializedName("base")
    private final Stats stats;

    public Pokemon(int id, Name name, List<String> types, Stats stats) {
        this.id = id;
        this.name = name;
        this.types = types;
        this.stats = stats;
    }

    public int getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public List<String> getTypes() {
        return types;
    }

    public Stats getStats() {
        return stats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon that = (Pokemon) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(types, that.types) && Objects.equals(stats, that.stats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, types, stats);
    }

    @Override
    public String toString() {
        return "ApiPokemon{" +
                "id=" + id +
                ", name=" + name +
                ", types=" + types +
                ", stats=" + stats +
                '}';
    }
}
