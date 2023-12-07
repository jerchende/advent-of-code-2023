package net.erchen.adventofcode2023.day07;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Map;


@EqualsAndHashCode
public class CamelCard implements Comparable<CamelCard> {

    private final static Map<Character, Integer> ORDER = Map.ofEntries(
            Map.entry('2', 2),
            Map.entry('3', 3),
            Map.entry('4', 4),
            Map.entry('5', 5),
            Map.entry('6', 6),
            Map.entry('7', 7),
            Map.entry('8', 8),
            Map.entry('9', 9),
            Map.entry('T', 10),
            Map.entry('J', 11),
            Map.entry('Q', 12),
            Map.entry('K', 13),
            Map.entry('A', 14));

    @Getter
    private final char value;

    public CamelCard(char value) {
        this.value = value;
    }

    public boolean isJoker() {
        return false;
    }

    public static CamelCard[] fromInput(String input) {
        return input.chars().mapToObj(c -> new CamelCard((char) c)).toArray(CamelCard[]::new);
    }


    int orderValue() {
        return ORDER.get(this.value);
    }

    @Override
    public int compareTo(CamelCard other) {
        return Integer.compare(this.orderValue(), other.orderValue());
    }
}
