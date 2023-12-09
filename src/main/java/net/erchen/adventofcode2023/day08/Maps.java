package net.erchen.adventofcode2023.day08;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public record Maps(char[] instruction, Map<String, Node> nodes) {


    public static Maps fromInput(String input) {
        return new Maps(input.lines().findFirst().orElse("").toCharArray(), input.lines().skip(2).map(Node::fromInput).collect(toMap(Node::name, Function.identity())));
    }

    public long navigateInstruction() {
        long steps = 0;
        int currentInstruction = 0;
        var currentNode = nodes.get("AAA");

        while (!currentNode.name().equals("ZZZ")) {
            steps++;
            currentNode = nodes.get(switch (instruction[currentInstruction]) {
                case 'L' -> currentNode.left();
                case 'R' -> currentNode.right();
                default -> throw new IllegalStateException("Unexpected value: " + instruction[currentInstruction]);
            });

            if (++currentInstruction>=instruction.length) {
                currentInstruction=0;
            }
        }

        return steps;
    }


    public long navigateInstructionAsGhost() {
        long steps = 0;
        int currentInstruction = 0;
        var currentNodes = nodes.values().stream().filter(node -> node.name().endsWith("A")).toArray(Node[]::new);

        while (!Arrays.stream(currentNodes).allMatch(node -> node.name().endsWith("Z"))) {
            steps++;
            for (int i=0; i<currentNodes.length; i++) {
                currentNodes[i] = nodes.get(switch (instruction[currentInstruction]) {
                    case 'L' -> currentNodes[i].left();
                    case 'R' -> currentNodes[i].right();
                    default -> throw new IllegalStateException("Unexpected value: " + instruction[currentInstruction]);
                });
            }

            if (++currentInstruction>=instruction.length) {
                currentInstruction=0;
            }
        }

        return steps;
    }
}