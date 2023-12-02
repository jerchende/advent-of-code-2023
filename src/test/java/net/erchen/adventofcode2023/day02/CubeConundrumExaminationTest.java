package net.erchen.adventofcode2023.day02;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CubeConundrumExaminationTest {

    @ParameterizedTest
    @CsvSource(delimiter = '#', value =
        {
            "3 blue, 4 red#4#0#3",
            "1 red, 2 green, 6 blue#1#2#6",
            "2 green#0#2#0",
            "5 blue, 4 red, 13 green#4#13#5"
        })
    void shouldParseFromInput(String input, int expectedRed, int expectedGreen, int expectedBlue) {

        var cubeConundrumExamination = CubeConundrumExamination.fromInput(input);

        assertThat(cubeConundrumExamination.red()).isEqualTo(expectedRed);
        assertThat(cubeConundrumExamination.green()).isEqualTo(expectedGreen);
        assertThat(cubeConundrumExamination.blue()).isEqualTo(expectedBlue);
    }
}