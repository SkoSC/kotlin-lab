package com.lexadiky.repository;

import com.lexadiky.entity.Pokemon;
import com.lexadiky.entity.Stats;
import com.lexadiky.entity.StatsStatistics;
import com.lexadiky.service.PokemonService;
import com.lexadiky.util.StringUtilKt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class PokemonStatsRepository {

    private final PokemonService service;

    public PokemonStatsRepository(PokemonService service) {
        this.service = service;
    }

    public StatsStatistics getStatistics() {
        try {
            return getStatisticsInner(service.getPokemon());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int countPokemonWithNameStartingWithB() {
        try {
            int acc = 0;
            List<Pokemon> pokemon = service.getPokemon();
            for (Pokemon pmon : pokemon) {
                if (StringUtilKt.getStartsWithLetterB(pmon.getName().getEnglish())) {
                    acc += 1;
                }
            }

            return acc;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int countPokemonWithType(String type) {
        try {
            int acc = 0;
            List<Pokemon> pokemon = service.getPokemon();
            for (Pokemon pmon : pokemon) {
                if (pmon.getTypes().contains(type)) {
                    acc += 1;
                }
            }
            return acc;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int countGrassTypePokemon() {
        try {
            int acc = 0;
            List<Pokemon> pokemon = service.getPokemon();
            for (Pokemon pmon : pokemon) {
                for (String type : pmon.getTypes()) {
                    if (StringUtilKt.isGrass(type)) {
                        acc += 1;
                    }
                }
            }
            return acc;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected StatsStatistics getStatisticsInner(List<Pokemon> pokemon) {
        List<Stats> stats = new LinkedList<>();
        for (Pokemon poke : pokemon) {
            stats.add(poke.getStats());
        }

        return new StatsStatistics() {{
            averageHp = averageOf(extractHpList(stats));
            averageDefence = averageOf(extractDefenceList(stats));
            averageAttack = averageOf(extractAttackList(stats));
            averageSpAttack = averageOf(extractSpAttackList(stats));
            averageSpDefense = averageOf(extractSpDefenceList(stats));
            averageSpeed = averageOf(extractSpeedList(stats));
        }};
    }

    private List<Integer> extractHpList(List<Stats> stats) {
        List<Integer> acc = new ArrayList<>();
        for (Stats stat : stats) {
            acc.add(stat.getHp());
        }

        return acc;
    }

    private List<Integer> extractDefenceList(List<Stats> stats) {
        List<Integer> acc = new ArrayList<>();
        for (Stats stat : stats) {
            acc.add(stat.getDefense());
        }

        return acc;
    }

    private List<Integer> extractAttackList(List<Stats> stats) {
        List<Integer> acc = new ArrayList<>();
        for (Stats stat : stats) {
            acc.add(stat.getAttack());
        }

        return acc;
    }

    private List<Integer> extractSpAttackList(List<Stats> stats) {
        List<Integer> acc = new ArrayList<>();
        for (Stats stat : stats) {
            acc.add(stat.getSpAttack());
        }

        return acc;
    }

    private List<Integer> extractSpDefenceList(List<Stats> stats) {
        List<Integer> acc = new ArrayList<>();
        for (Stats stat : stats) {
            acc.add(stat.getSpDefense());
        }

        return acc;
    }

    private List<Integer> extractSpeedList(List<Stats> stats) {
        List<Integer> acc = new ArrayList<>();
        for (Stats stat : stats) {
            acc.add(stat.getSpeed());
        }

        return acc;
    }

    private Double averageOf(List<Integer> ints) {
        double acc = 0;
        for (Integer anInt : ints) {
            acc += anInt;
        }

        return acc / ints.size();
    }
}
