package net.erchen.adventofcode2023.day02;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class CubeConundrumTest {

    public static final CubeTriple BAG = new CubeTriple(12, 13, 14);

    @SneakyThrows
    static String sampleInput() {
        return Files.readString(Path.of("src/test/resources/day02/sample.txt"));
    }

    @SneakyThrows
    static String solutionInput() {
        return Files.readString(Path.of("src/test/resources/day02/input.txt"));
    }


    @Test
    void shouldParseInput() {

        var cubeConundrum = CubeConundrum.fromInput(sampleInput());

        assertThat(cubeConundrum.games()).hasSize(5);
    }

    @Test
    void possibleGames_Sample() {
        var cubeConundrum = CubeConundrum.fromInput(sampleInput());

        assertThat(cubeConundrum.possibleGames(BAG)).extracting(CubeConundrumGame::id).containsExactly(1,2,5);
    }

    @Test
    void possibleGames_Solution() {
        var cubeConundrum = CubeConundrum.fromInput(solutionInput());

        var sum = cubeConundrum.possibleGames(BAG).stream().mapToInt(CubeConundrumGame::id).sum();

        assertThat(sum).isEqualTo(2164);
    }

    @Test
    void fewest_Sample() {
        var cubeConundrum = CubeConundrum.fromInput(sampleInput());

        assertThat(cubeConundrum.games()).extracting(CubeConundrumGame::power).containsExactly(48,12,1560,630,36);
        assertThat(cubeConundrum.power()).isEqualTo(2286);
    }

    @Test
    void fewest_Solution() {
        var cubeConundrum = CubeConundrum.fromInput(solutionInput());

        assertThat(cubeConundrum.power()).isEqualTo(2286);
    }

}