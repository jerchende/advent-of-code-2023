package net.erchen.adventofcode2023.day07;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public record CamelCardHand(CamelCard[] hand, long orderValue, int bid) implements Comparable<CamelCardHand> {

    public static CamelCardHand fromInput(String input) {
        return new CamelCardHand(CamelCard.fromInput(input.substring(0, 5)), Integer.parseInt(input.substring(6)));
    }

    public static CamelCardHand fromInputWithJokers(String input) {
        return new CamelCardHand(CamelCardWithJoker.fromInput(input.substring(0, 5)), Integer.parseInt(input.substring(6)));
    }


    public CamelCardHand(CamelCard[] hand, int bid) {
        this(hand, calculateValue(hand), bid);
    }

    private static long calculateValue(CamelCard[] hand) {
        return (calculateTypeValue(hand) << 20) |
                ((long) hand[0].orderValue() << 16) |
                ((long) hand[1].orderValue() << 12) |
                ((long) hand[2].orderValue() << 8) |
                ((long) hand[3].orderValue() << 4) |
                ((long) hand[4].orderValue());
    }

    static long calculateTypeValue(CamelCard[] hand) {
        var cardsPerType = Stream.of(hand).collect(groupingBy(c -> c, counting()));
        final long jokers = cardsPerType.entrySet()
                .stream()
                .filter(e -> e.getKey().isJoker()).findFirst()
                .map(joker -> {
                    cardsPerType.remove(joker.getKey());
                    return joker;
                })
                .map(Map.Entry::getValue).orElse(0L);

        if (jokers == 5 || cardsPerType.containsValue(5L - jokers)) { // Five of a kind
            return 6;
        }
        if (cardsPerType.containsValue(4L - jokers)) { // Four of a kind
            return 5;
        }
        if ((cardsPerType.containsValue(3L) && cardsPerType.containsValue(2L)) || (jokers == 1 && cardsPerType.values().stream().filter(count -> count == 2).count() == 2L)) { // Full house
            return 4;
        }
        if (cardsPerType.containsValue(3L - jokers)) { // Three of a kind
            return 3;
        }
        if (cardsPerType.values().stream().filter(count -> count == 2).count() == 2L) { // Two pair
            return 2;
        }
        if (cardsPerType.containsValue(2L - jokers)) { // One pair
            return 1;
        }
        // High card
        return 0;
    }


    @Override
    public int compareTo(CamelCardHand o) {
        return Long.compare(this.orderValue, o.orderValue);
    }
}
