import com.google.gson.Gson;
import com.lexadiky.entity.PokemonStatisticsReport;
import com.lexadiky.entity.StatsStatistics;
import com.lexadiky.repository.PokemonStatsRepository;
import com.lexadiky.service.PokemonService;
import com.lexadiky.usecase.CountPokemonUseCase;
import com.lexadiky.usecase.MakeReportUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PokemonStatsRepositoryTest {

    @Test
    public void test1() {
        PokemonService pokemonService = new PokemonService(new Gson());
        PokemonStatsRepository statsRepository = new PokemonStatsRepository(pokemonService);

        StatsStatistics actual = statsRepository.getStatistics();
        StatsStatistics expected = new StatsStatistics() {{
            averageHp = 68.83930778739185;
            averageAttack = 76.16810877626699;
            averageDefence = 71.80593325092707;
            averageSpAttack = 69.48207663782448;
            averageSpDefense = 69.96415327564895;
            averageSpeed = 65.70210135970333;
        }};
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        PokemonService pokemonService = new PokemonService(new Gson());
        PokemonStatsRepository statsRepository = new PokemonStatsRepository(pokemonService);

        int actual = statsRepository.countPokemonWithNameStartingWithB();
        Assertions.assertEquals(45, actual);
    }

    @Test
    public void test3() {
        PokemonService pokemonService = new PokemonService(new Gson());
        PokemonStatsRepository statsRepository = new PokemonStatsRepository(pokemonService);

        int actual = statsRepository.countPokemonWithType("Grass");
        Assertions.assertEquals(97, actual);
    }

    @Test
    public void test4() {
        PokemonService pokemonService = new PokemonService(new Gson());
        PokemonStatsRepository statsRepository = new PokemonStatsRepository(pokemonService);

        int actual = statsRepository.countGrassTypePokemon();
        Assertions.assertEquals(97, actual);
    }

    @Test
    public void test5() {
        PokemonService pokemonService = new PokemonService(new Gson());
        int actual = new CountPokemonUseCase(pokemonService).run();
        Assertions.assertEquals(809, actual);
    }

    @Test
    public void test6() {
        PokemonService pokemonService = new PokemonService(new Gson());
        PokemonStatsRepository statsRepository = new PokemonStatsRepository(pokemonService);

        PokemonStatisticsReport actual = new MakeReportUseCase(statsRepository).make();
        StatsStatistics expected = new StatsStatistics() {{
            averageHp = 68.83930778739185;
            averageAttack = 76.16810877626699;
            averageDefence = 71.80593325092707;
            averageSpAttack = 69.48207663782448;
            averageSpDefense = 69.96415327564895;
            averageSpeed = 65.70210135970333;
        }};
        Assertions.assertTrue(actual.isSuccess());
        Assertions.assertEquals(expected, actual.getStatistics());
    }
}
