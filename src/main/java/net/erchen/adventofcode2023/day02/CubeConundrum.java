package net.erchen.adventofcode2023.day02;

import net.erchen.codingpuzzlescommon.parser.SeparatorParser;

import java.util.List;

public record CubeConundrum(List<CubeConundrumGame> games) {

    public static CubeConundrum fromInput(String input) {
        return new CubeConundrum(SeparatorParser.parseInput(input, "\n", CubeConundrumGame::fromInput));
    }

    public List<CubeConundrumGame> possibleGames(CubeTriple bag) {
        return games.stream().filter(game -> game.isPossible(bag)).toList();
    }

    public int power() {
        return games.stream().mapToInt(CubeConundrumGame::power).sum();
    }
}
