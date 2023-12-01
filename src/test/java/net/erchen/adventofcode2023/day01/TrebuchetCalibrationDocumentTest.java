package net.erchen.adventofcode2023.day01;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class TrebuchetCalibrationDocumentTest {

    @SneakyThrows
    static String sampleInput() {
        return Files.readString(Path.of("src/test/resources/day01/sample.txt"));
    }

    @SneakyThrows
    static String sample2Input() {
        return Files.readString(Path.of("src/test/resources/day01/sample2.txt"));
    }


    @SneakyThrows
    static String solutionInput() {
        return Files.readString(Path.of("src/test/resources/day01/input.txt"));
    }


    @Test
    void shouldCalculateCalibrationValueSum_Sample() {
        var trebuchetCalibrationDocument = TrebuchetCalibrationDocument.fromInput(sampleInput());

        assertThat(trebuchetCalibrationDocument.calibrationValueSum()).isEqualTo(142);
    }
    @Test
    void shouldCalculateCalibrationValueSum_Sample2() {
        var trebuchetCalibrationDocument = TrebuchetCalibrationDocument.fromInput(sample2Input());

        assertThat(trebuchetCalibrationDocument.calibrationValueSum()).isEqualTo(281);
    }

    @Test
    void shouldCalculateCalibrationValueSum_Solution() {
        var trebuchetCalibrationDocument = TrebuchetCalibrationDocument.fromInput(solutionInput());

        assertThat(trebuchetCalibrationDocument.calibrationValueSum()).isEqualTo(53340);
    }
}