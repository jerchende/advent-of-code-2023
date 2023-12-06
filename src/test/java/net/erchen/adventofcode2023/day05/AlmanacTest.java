package net.erchen.adventofcode2023.day05;

import lombok.SneakyThrows;
import net.erchen.codingpuzzlescommon.structure.Pair;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class AlmanacTest {

    @SneakyThrows
    static String sampleInput() {
        return Files.readString(Path.of("src/test/resources/day05/sample.txt"));
    }

    @SneakyThrows
    static String solutionInput() {
        return Files.readString(Path.of("src/test/resources/day05/input.txt"));
    }


    @Test
    void shouldParseFromInput() {

        var almanac = Almanac.fromInput(sampleInput());

        assertThat(almanac.seeds()).containsExactly(79L, 14L, 55L, 13L);
        assertThat(almanac.mapping()).containsKeys(
                new Pair<>(Category.seed, Category.soil),
                new Pair<>(Category.soil, Category.fertilizer),
                new Pair<>(Category.fertilizer, Category.water),
                new Pair<>(Category.water, Category.light),
                new Pair<>(Category.light, Category.temperature),
                new Pair<>(Category.temperature, Category.humidity),
                new Pair<>(Category.humidity, Category.location)
        );
        assertThat(almanac.mapping().get(new Pair<>(Category.seed, Category.soil)))
                .contains(new MappingDefinition(98,50,2))
                .contains(new MappingDefinition(50,52,48));
    }

    @Test
    void shouldResolveMapping() {
        var almanac = Almanac.fromInput(sampleInput());

        assertThat(almanac.resolveSeed(79L))
                .containsEntry(Category.seed, 79L)
                .containsEntry(Category.soil, 81L)
                .containsEntry(Category.fertilizer, 81L)
                .containsEntry(Category.water, 81L)
                .containsEntry(Category.light, 74L)
                .containsEntry(Category.temperature, 78L)
                .containsEntry(Category.humidity, 78L)
                .containsEntry(Category.location, 82L);
    }

    @Test
    void shouldFindLowestLocation_Sample() {
        var almanac = Almanac.fromInput(sampleInput());

        assertThat(almanac.lowestLocation()).isEqualTo(35);
    }

    @Test
    void shouldFindLowestLocation_Solution() {
        var almanac = Almanac.fromInput(solutionInput());

        assertThat(almanac.lowestLocation()).isEqualTo(836040384L);
    }
}