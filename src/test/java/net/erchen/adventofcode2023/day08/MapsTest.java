package net.erchen.adventofcode2023.day08;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class MapsTest {

    @SneakyThrows
    static String sampleInput() {
        return Files.readString(Path.of("src/test/resources/day08/sample.txt"));
    }

    @SneakyThrows
    static String sample2Input() {
        return Files.readString(Path.of("src/test/resources/day08/sample2.txt"));
    }

    @SneakyThrows
    static String sample3Input() {
        return Files.readString(Path.of("src/test/resources/day08/sample3.txt"));
    }


    @SneakyThrows
    static String solutionInput() {
        return Files.readString(Path.of("src/test/resources/day08/input.txt"));
    }


    @Test
    void shouldParseInput() {
        Maps maps = Maps.fromInput(sampleInput());

        assertThat(maps.instruction()).contains('R','L');
        assertThat(maps.nodes()).containsKeys("AAA", "BBB", "CCC", "DDD", "EEE", "GGG", "ZZZ");
    }

    @Test
    void shouldNavigate_Sample() {
        Maps maps = Maps.fromInput(sampleInput());

        assertThat(maps.navigateInstruction()).isEqualTo(2);
    }
    @Test
    void shouldNavigate_Sample2() {
        Maps maps = Maps.fromInput(sample2Input());

        assertThat(maps.navigateInstruction()).isEqualTo(6);
    }

    @Test
    void shouldNavigate_Solution() {
        Maps maps = Maps.fromInput(solutionInput());

        assertThat(maps.navigateInstruction()).isEqualTo(12643L);
    }

    @Test
    void shouldNavigateAsGhost_Sample() {
        Maps maps = Maps.fromInput(sample3Input());

        assertThat(maps.navigateInstructionAsGhost()).isEqualTo(6);
    }
}