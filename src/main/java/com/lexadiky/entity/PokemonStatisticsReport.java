package com.lexadiky.entity;

public class PokemonStatisticsReport {

    private final boolean isSuccess;
    private final StatsStatistics statistics;


    public PokemonStatisticsReport(boolean isSuccess, StatsStatistics statistics) {
        this.isSuccess = isSuccess;
        this.statistics = statistics;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public StatsStatistics getStatistics() {
        return statistics;
    }
}
