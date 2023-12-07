package net.erchen.adventofcode2023.day07;

import java.util.List;
import java.util.stream.IntStream;

public record CamelCardGame(List<CamelCardHand> hands) {

    public static CamelCardGame fromInput(String input) {
        return new CamelCardGame(input.lines().map(CamelCardHand::fromInput).toList());
    }

    public static CamelCardGame fromInputWithJokers(String input) {
        return new CamelCardGame(input.lines().map(CamelCardHand::fromInputWithJokers).toList());
    }


    public long winnings() {
        var orderedHands = hands.stream().sorted().toList();
        return IntStream.range(0, orderedHands.size())
                .map(i -> (1+i) * orderedHands.get(i).bid())
                .sum();
    }
}
