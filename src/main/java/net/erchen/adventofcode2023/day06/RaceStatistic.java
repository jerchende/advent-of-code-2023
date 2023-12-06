package net.erchen.adventofcode2023.day06;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public record RaceStatistic(long time, long distance) {


    public long winningCombinations() {
        long winningCombinations=0;
        for (long i = 0; i < time; i++) {

            if ((time-i)*i > distance) {
                winningCombinations++;
            }
        }

        return winningCombinations;
    }

}
