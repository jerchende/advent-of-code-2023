package net.erchen.adventofcode2023.day03;

import net.erchen.codingpuzzlescommon.matrix.Matrix;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public record GondolaLiftEngineSchematic(Matrix<Character> engineSchematic) {

    public static GondolaLiftEngineSchematic fromInput(String input) {
        return new GondolaLiftEngineSchematic(Matrix.fromInput(input, "\n", "", s -> s.charAt(0)));
    }

    List<Integer> partNumbers() {
        Set<Matrix.Field> processPartNumbers = new HashSet<>();
        return engineSchematic.allFields()
                .filter(field -> !isNumber(field) && field.getValue() != '.')
                .flatMap(Matrix.Field::getAdjacentsWithDiagonals)
                .filter(GondolaLiftEngineSchematic::isNumber)
                .map(field -> findAllDigits(field, processPartNumbers))
                .filter(Objects::nonNull)
                .toList();
    }

    Integer gearRatioSum() {
        return engineSchematic.allFields()
                .filter(field -> field.getValue() == '*')
                .map(field -> {
                    Set<Matrix.Field> processPartNumbers = new HashSet<>();
                    return field.getAdjacentsWithDiagonals()
                            .filter(GondolaLiftEngineSchematic::isNumber)
                            .map(adjacentField -> findAllDigits(adjacentField, processPartNumbers))
                            .filter(Objects::nonNull)
                            .toList();
                })
                .filter(list -> list.size() == 2).
                mapToInt(list -> list.get(0) * list.get(1)).
                sum();
    }

    public Integer partNumbersSum() {
        return partNumbers().stream().mapToInt(Integer::intValue).sum();
    }

    private static boolean isNumber(Matrix<Character>.Field field) {
        return field.getValue() >= '0' && field.getValue() <= '9';
    }

    private Integer findAllDigits(Matrix<Character>.Field field, Set<Matrix.Field> processedFields) {
        if (processedFields.contains(field)) {
            return null;
        }
        var left = field.left();
        if (left.isPresent() && isNumber(left.get())) {
            return findAllDigits(left.get(), processedFields);
        }

        var current = field;
        var number = "";
        while (current != null && isNumber(current)) {
            processedFields.add(current);
            number += current.getValue();
            current = current.right().orElse(null);
        }

        return Integer.parseInt(number);
    }

}
