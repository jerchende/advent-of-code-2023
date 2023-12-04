package net.erchen.adventofcode2023.day04;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class ScratchCardsTest {

    @SneakyThrows
    static String sampleInput() {
        return Files.readString(Path.of("src/test/resources/day04/sample.txt"));
    }

    @SneakyThrows
    static String solutionInput() {
        return Files.readString(Path.of("src/test/resources/day04/input.txt"));
    }

    @Test
    void shouldGetPoints_Sample() {
        var scratchCard = ScratchCards.fromInput(sampleInput());

        assertThat(scratchCard.points()).isEqualTo(13);
    }

    @Test
    void shouldGetPoints_Solution() {
        var scratchCard = ScratchCards.fromInput(solutionInput());

        assertThat(scratchCard.points()).isEqualTo(23441);
    }

    @Test
    void shouldTotalCards_Sample() {
        var scratchCard = ScratchCards.fromInput(sampleInput());

        assertThat(scratchCard.totalCards()).isEqualTo(30);
    }

    @Test
    void shouldTotalCards_Solution() {
        var scratchCard = ScratchCards.fromInput(solutionInput());

        assertThat(scratchCard.totalCards()).isEqualTo(5923918);
    }

}