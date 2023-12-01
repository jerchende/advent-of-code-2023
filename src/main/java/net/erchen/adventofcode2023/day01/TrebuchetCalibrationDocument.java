package net.erchen.adventofcode2023.day01;

import net.erchen.codingpuzzlescommon.parser.SeparatorParser;

import java.util.List;

public record TrebuchetCalibrationDocument(List<TrebuchetCalibrationLine> calibrationLines) {

    public static TrebuchetCalibrationDocument fromInput(String input) {
        return new TrebuchetCalibrationDocument(SeparatorParser.parseInput(input, "\n", TrebuchetCalibrationLine::fromInput));
    }


    public int calibrationValueSum() {
        return calibrationLines.stream().mapToInt(TrebuchetCalibrationLine::calibrationValue).sum();
    }

}
