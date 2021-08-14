package com.lexadiky.usecase;

import com.lexadiky.entity.PokemonStatisticsReport;
import com.lexadiky.entity.StatsStatistics;
import com.lexadiky.repository.PokemonStatsRepository;

public class MakeReportUseCase {

    private final PokemonStatsRepository repository;

    public MakeReportUseCase(PokemonStatsRepository repository) {
        this.repository = repository;
    }

    public PokemonStatisticsReport make() {
        try {
            StatsStatistics statistics = repository.getStatistics();
            return new PokemonStatisticsReport(true, statistics);
        } catch (Exception e) {
            return new PokemonStatisticsReport(false, null);
        }
    }
}
