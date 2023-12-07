package net.erchen.adventofcode2023.day07;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class CamelCardGameTest {

    @SneakyThrows
    static String sampleInput() {
        return Files.readString(Path.of("src/test/resources/day07/sample.txt"));
    }

    @SneakyThrows
    static String solutionInput() {
        return Files.readString(Path.of("src/test/resources/day07/input.txt"));
    }

    @Test
    void shouldParseInput() {
        var game = CamelCardGame.fromInput(sampleInput());

        assertThat(game.hands()).hasSize(5);
    }

    @Test
    void shouldGetWinnings_Sample() {
        var game = CamelCardGame.fromInput(sampleInput());

        assertThat(game.winnings()).isEqualTo(6440);
    }

    @Test
    void shouldGetWinnings_Solution() {
        var game = CamelCardGame.fromInput(solutionInput());

        assertThat(game.winnings()).isEqualTo(250453939L);
    }

    @Test
    void shouldGetWinningsWithJokers_Sample() {
        var game = CamelCardGame.fromInputWithJokers(sampleInput());

        assertThat(game.winnings()).isEqualTo(5905);
    }

    @Test
    void shouldGetWinningsWithJokers_Solution() {
        var game = CamelCardGame.fromInputWithJokers(solutionInput());

        assertThat(game.winnings()).isEqualTo(248652697L);
    }
}