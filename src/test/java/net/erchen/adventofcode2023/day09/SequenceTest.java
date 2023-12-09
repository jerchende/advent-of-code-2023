package net.erchen.adventofcode2023.day09;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class SequenceTest {

    @SneakyThrows
    static String sampleInput() {
        return Files.readString(Path.of("src/test/resources/day09/sample.txt"));
    }

    @SneakyThrows
    static String solutionInput() {
        return Files.readString(Path.of("src/test/resources/day09/input.txt"));
    }


    @Test
    void shouldParseInput() {
        Sequence sequence = Sequence.fromInput("0 3 6 9 12 15");

        assertThat(sequence.values()).containsExactly(0, 3, 6, 9, 12, 15);
    }

    @Test
    void differences() {
        Sequence sequence = Sequence.fromInput("0 3 6 9 12 15");

        assertThat(sequence.differences().get().values()).containsExactly(3, 3, 3, 3, 3);
        assertThat(sequence.differences().get().differences().get().values()).containsExactly(0, 0, 0, 0);
        assertThat(sequence.differences().get().differences().get().differences()).isEmpty();
    }

    @ParameterizedTest
    @CsvSource({
            "0 3 6 9 12 15,18",
            "3 3 3 3 3,3",
            "0 0 0 0, 0",
            "1 3 6 10 15 21,28",
            "10 13 16 21 30 45,68"
    })
    void predictNext(String input, int expectedNext) {

        assertThat(Sequence.fromInput(input).predictNext()).isEqualTo(expectedNext);
    }

    @Test
    void predictAllNext_Sample() {
        int sum = Sequence.fromInputs(sampleInput()).mapToInt(Sequence::predictNext).sum();

        assertThat(sum).isEqualTo(114);
    }

    @Test
    void predictAllNext_Solution() {
        int sum = Sequence.fromInputs(solutionInput()).mapToInt(Sequence::predictNext).sum();

        assertThat(sum).isEqualTo(1993300041);
    }

    @ParameterizedTest
    @CsvSource({
            "10 13 16 21 30 45,5",
            "3 3 5 9 15,5",
            "0 2 4 6,-2",
            "2 2 2, 2",
            "0 0,0",
    })
    void predictPrevious(String input, int expectedPrevious) {

        assertThat(Sequence.fromInput(input).predictPrevious()).isEqualTo(expectedPrevious);
    }

    @Test
    void predictAllNext_Previous() {
        int sum = Sequence.fromInputs(solutionInput()).mapToInt(Sequence::predictPrevious).sum();

        assertThat(sum).isEqualTo(1038);
    }
}