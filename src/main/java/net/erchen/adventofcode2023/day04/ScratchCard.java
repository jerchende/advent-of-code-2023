package net.erchen.adventofcode2023.day04;

import java.util.Arrays;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public record ScratchCard(int cardId,  Set<Integer> winningNumbers,  Set<Integer> yourNumbers) {

    public static ScratchCard fromInput(String input) {
        var split = input.substring(input.indexOf(':') + 1).split("\\|");
        return new ScratchCard(
                Integer.parseInt(input.substring(5, input.indexOf(":")).trim()),
                toIntSet(split[0]),
                toIntSet(split[1]));
    }

    private static Set<Integer> toIntSet(String input) {
        return Arrays.stream(input.split(" "))
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .collect(toSet());
    }

    public Set<Integer> yourWinningNumbers() {
        return winningNumbers.stream().filter(yourNumbers::contains).collect(toSet());
    }

    public int winningNumberCount() {
        return yourWinningNumbers().size();
    }

    public int points() {
        var count = winningNumberCount();
        return count==0?0: (int) Math.pow(2, count - 1);
    }
}
