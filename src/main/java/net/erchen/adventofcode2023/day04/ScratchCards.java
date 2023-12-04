package net.erchen.adventofcode2023.day04;

import net.erchen.codingpuzzlescommon.parser.SeparatorParser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public record ScratchCards(List<ScratchCard> cards) {

    public static ScratchCards fromInput(String input) {
        return new ScratchCards(SeparatorParser.parseInput(input, "\n", ScratchCard::fromInput));
    }

    public int points() {
        return cards.stream().mapToInt(ScratchCard::points).sum();
    }

    public int totalCards() {
        List<AtomicInteger> cardAmount = new ArrayList<>(cards.size());

        for (int i = 0; i < cards.size(); i++) {
            cardAmount.add(i, new AtomicInteger(1));
        }

        for (int i = 0; i < cards.size(); i++) {
            int copiesOfCurrentCard = cardAmount.get(i).get();
            var currentCard = cards.get(i);
            int winningNumberCount = currentCard.winningNumberCount();

            for (int j = i + 1; j <= i + winningNumberCount && j < cards.size(); j++) {
                cardAmount.get(j).addAndGet(copiesOfCurrentCard);
            }
        }
        return cardAmount.stream().mapToInt(AtomicInteger::get).sum();
    }
}
