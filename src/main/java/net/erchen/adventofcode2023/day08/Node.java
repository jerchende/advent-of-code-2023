package net.erchen.adventofcode2023.day08;

public record Node(String name, String left, String right) {
    public static Node fromInput(String input) {
        return new Node(input.substring(0,3), input.substring(7, 10), input.substring(12,15));
    }
}
