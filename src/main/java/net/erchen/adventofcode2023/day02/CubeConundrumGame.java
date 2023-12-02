package net.erchen.adventofcode2023.day02;

import net.erchen.codingpuzzlescommon.parser.SeparatorParser;
import net.erchen.codingpuzzlescommon.regexp.RegExpUtil;

import java.util.List;
import java.util.regex.Pattern;

public record CubeConundrumGame(int id, List<CubeConundrumExamination> examinations) {

    private static final Pattern PATTERN_ID = Pattern.compile("Game ([0-9]+):");


    public static CubeConundrumGame fromInput(String input) {
        return new CubeConundrumGame(
                RegExpUtil.find(PATTERN_ID.matcher(input), 1).orElseThrow(),
                SeparatorParser.parseInput(input.substring(input.indexOf(':') + 1), ";", CubeConundrumExamination::fromInput));
    }

    public boolean isPossible(CubeTriple max) {
        return examinations.stream().allMatch(examination -> examination.isPossible(max));
    }

    public CubeTriple fewest() {
        return new CubeTriple(
                examinations.stream().mapToInt(CubeConundrumExamination::red).max().orElse(0),
                examinations.stream().mapToInt(CubeConundrumExamination::green).max().orElse(0),
                examinations.stream().mapToInt(CubeConundrumExamination::blue).max().orElse(0)
        );
    }

    public int power() {
        var fewest = fewest();
        return fewest.red() * fewest.green() * fewest.blue();
    }

}
