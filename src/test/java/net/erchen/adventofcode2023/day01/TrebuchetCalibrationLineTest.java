package net.erchen.adventofcode2023.day01;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class TrebuchetCalibrationLineTest {

    @ParameterizedTest
    @CsvSource({
        "1abc2,1,2",
        "pqr3stu8vwx,3,8",
        "a1b2c3d4e5f,1,5",
        "treb7uchet,7,7",
        "two1nine,2,9",
        "eightwothree,8,3",
        "abcone2threexyz,1,3",
        "xtwone3four,2,4",
        "4nineeightseven2,4,2",
        "zoneight234,1,4",
        "7pqrstsixteen,7,6"
    })
    void shouldParse(String input, int first, int last) {
        var trebuchetCalibrationLine = TrebuchetCalibrationLine.fromInput(input);

        assertThat(trebuchetCalibrationLine.firstValue()).isEqualTo(first);
        assertThat(trebuchetCalibrationLine.lastValue()).isEqualTo(last);
    }


    @ParameterizedTest
    @CsvSource({
        "1,2,12",
        "3,8,38",
        "1,5,15",
        "7,7,77"
    })
    void shouldCalcCalibrationValue(int first, int last, int expected) {
        var trebuchetCalibrationLine = new TrebuchetCalibrationLine(first, last);

        assertThat(trebuchetCalibrationLine.lastValue()).isEqualTo(last);
    }
}