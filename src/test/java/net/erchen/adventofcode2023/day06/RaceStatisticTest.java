package net.erchen.adventofcode2023.day06;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceStatisticTest {

    static final List<RaceStatistic> SAMPLE = List.of(
            new RaceStatistic(7,9),
            new RaceStatistic(15,40),
            new RaceStatistic(30,200)
    );

    static final List<RaceStatistic> SOLUTION = List.of(
            new RaceStatistic(49,356),
            new RaceStatistic(87,1378),
            new RaceStatistic(78,1502),
            new RaceStatistic(95,1882)
    );

    static final List<RaceStatistic> SAMPLE_PART2 = List.of(
            new RaceStatistic(71530,940200)
    );

    static final List<RaceStatistic> SOLUTION_PART2 = List.of(
            new RaceStatistic(49877895,356137815021882L)
    );


    @Test
    void shouldGetWinningCombinations_Sample() {
        assertThat(SAMPLE.stream().map(RaceStatistic::winningCombinations)).containsExactly(4L,8L,9L);

    }
    @Test
    void shouldGetWinningCombinations_Solution() {
        assertThat(SOLUTION.stream().map(RaceStatistic::winningCombinations)).containsExactly(32L, 46L, 9L, 38L);

    }

    @Test
    void shouldGetWinningCombinations_Sample_Part2() {
        assertThat(SAMPLE_PART2.stream().map(RaceStatistic::winningCombinations)).containsExactly(71503L);
    }

    @Test
    void shouldGetWinningCombinations_Solution_Part2() {
        assertThat(SOLUTION_PART2.stream().map(RaceStatistic::winningCombinations)).containsExactly(32607562L);
    }
}