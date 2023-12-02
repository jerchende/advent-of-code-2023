package net.erchen.adventofcode2023.day02;

import net.erchen.codingpuzzlescommon.regexp.RegExpUtil;

import java.util.regex.Pattern;

public record CubeConundrumExamination(int red, int green, int blue) {

    private static final Pattern PATTERN_RED = Pattern.compile("([0-9]+) red");
    private static final Pattern PATTERN_GREEN = Pattern.compile("([0-9]+) green");
    private static final Pattern PATTERN_BLUE = Pattern.compile("([0-9]+) blue");

    public static CubeConundrumExamination fromInput(String input) {
        return new CubeConundrumExamination(
                RegExpUtil.find(PATTERN_RED.matcher(input), 1).orElse(0),
                RegExpUtil.find(PATTERN_GREEN.matcher(input), 1).orElse(0),
                RegExpUtil.find(PATTERN_BLUE.matcher(input), 1).orElse(0));
    }

    public boolean isPossible(CubeTriple max) {
        return red <= max.red() && green <= max.green() && blue <= max.blue();
    }
}
