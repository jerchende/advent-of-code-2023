package net.erchen.adventofcode2023.day03;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class GondolaLiftEngineSchematicTest {

    @SneakyThrows
    static String sampleInput() {
        return Files.readString(Path.of("src/test/resources/day03/sample.txt"));
    }

    @SneakyThrows
    static String solutionInput() {
        return Files.readString(Path.of("src/test/resources/day03/input.txt"));
    }

    @Test
    void shouldGetPartNumbers() {
        var gondolaLiftEngineSchematic = GondolaLiftEngineSchematic.fromInput(sampleInput());

        assertThat(gondolaLiftEngineSchematic.partNumbers()).containsExactlyInAnyOrder(467,35,633,617,592,755,664,598);
    }

    @Test
    void shouldGetPartNumbersSum_Sample() {
        var gondolaLiftEngineSchematic = GondolaLiftEngineSchematic.fromInput(sampleInput());

        assertThat(gondolaLiftEngineSchematic.partNumbersSum()).isEqualTo(4361);
    }

    @Test
    void shouldGetPartNumbersSum_Solution() {
        var gondolaLiftEngineSchematic = GondolaLiftEngineSchematic.fromInput(solutionInput());

        assertThat(gondolaLiftEngineSchematic.partNumbersSum()).isEqualTo(544433);
    }

    @Test
    void shouldGetGearRatio_Sample() {
        var gondolaLiftEngineSchematic = GondolaLiftEngineSchematic.fromInput(sampleInput());

        assertThat(gondolaLiftEngineSchematic.gearRatioSum()).isEqualTo(467835);
    }

    @Test
    void shouldGetGearRatioSum_Solution() {
        var gondolaLiftEngineSchematic = GondolaLiftEngineSchematic.fromInput(solutionInput());

        assertThat(gondolaLiftEngineSchematic.gearRatioSum()).isEqualTo(76314915);
    }
}