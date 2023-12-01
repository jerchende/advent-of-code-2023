package net.erchen.adventofcode2023.day01;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record TrebuchetCalibrationLine(int firstValue, int lastValue) {

    final static List<String> DIGITS = List.of("one", "two","three","four","five","six","seven","eight","nine");
    final static Pattern PATTERN_FIRST = Pattern.compile(".*?([0-9]|one|two|three|four|five|six|seven|eight|nine).*");
    final static Pattern PATTERN_LAST= Pattern.compile(".*([0-9]|one|two|three|four|five|six|seven|eight|nine).*?");


    public static TrebuchetCalibrationLine fromInput(String input) {
        var matcherFirst = PATTERN_FIRST.matcher(input);

        var matcherLast = PATTERN_LAST.matcher(input);
        if (!(matcherLast.find() && matcherFirst.find())) {
            throw new IllegalArgumentException("Cant find digit in "+input);
        }
        return new TrebuchetCalibrationLine(toInt(matcherFirst.group(1)), toInt(matcherLast.group(1)));
    }

    private static int toInt(String digit) {
        if (digit.matches("[0-9]")) {
            return Integer.parseInt(digit);
        }

        return DIGITS.indexOf(digit)+1;
    }

    public int calibrationValue() {
        return 10*firstValue + lastValue;
    }
}
