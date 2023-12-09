package net.erchen.adventofcode2023.day09;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record Sequence(int[] values, Optional<Sequence> differences) {

    public Sequence(int[] values) {
        this(values, differences(values));
    }

    public static Stream<Sequence> fromInputs(String input) {
        return input.lines().map(Sequence::fromInput);
    }

    public static Sequence fromInput(String input) {
        return new Sequence(Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray());
    }

    static Optional<Sequence> differences(int[] values) {
        if (Arrays.stream(values).allMatch(i -> i == 0)) {
            return Optional.empty();
        }
        return Optional.of(new Sequence(IntStream.range(0, values.length - 1).map(i -> values[i + 1] - values[i]).toArray()));
    }

    public int predictNext() {
        return values[values.length - 1] + differences.map(Sequence::predictNext).orElse(0);
    }


    public int predictPrevious() {
        return values[0] - differences.map(Sequence::predictPrevious).orElse(0);
    }
}
