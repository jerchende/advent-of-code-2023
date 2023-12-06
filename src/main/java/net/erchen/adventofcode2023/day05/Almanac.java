package net.erchen.adventofcode2023.day05;

import net.erchen.codingpuzzlescommon.structure.Pair;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public record Almanac(List<Long> seeds, Map<Pair<Category, Category>, List<MappingDefinition>> mapping) {

    public static Almanac fromInput(String input) {

        return new Almanac(parseSeeds(input.lines().findFirst().orElseThrow()), parseMapping(input.lines().skip(2)));
    }

    private static List<Long> parseSeeds(String input) {
        return Arrays.stream(input.substring("seeds :".length()).split(" ")).map(Long::parseLong).toList();
    }

    private static Map<Pair<Category, Category>, List<MappingDefinition>> parseMapping(Stream<String> input) {
        Map<Pair<Category, Category>, List<MappingDefinition>> mapping = new HashMap<>();
        AtomicReference<Pair<Category, Category>> currentMapping = new AtomicReference<>();
        input.filter(s -> !s.isEmpty())
                .forEach(line -> {
                    if (line.contains(":")) {
                        var categoryMapping = line.split("[- ]");
                        currentMapping.set(new Pair<>(Category.valueOf(categoryMapping[0]), Category.valueOf(categoryMapping[2])));
                        mapping.put(currentMapping.get(), new LinkedList<>());
                    } else {
                        var split = line.split(" ");

                        var sourceStart = Long.parseLong(split[1]);
                        var destinationStart = Long.parseLong(split[0]);
                        var rangeLength = Long.parseLong(split[2]);

                        mapping.get(currentMapping.get()).add(new MappingDefinition(sourceStart, destinationStart, rangeLength));
                    }
                });
        return mapping;
    }

    public Map<Category, Long> resolveSeed(Long seed) {
        Map<Category, Long> resolved = new HashMap<>();
        Category currentCategory = Category.seed;
        Long currentValue = seed;

        while (true) {
            resolved.put(currentCategory, currentValue);
            var currentMappingKey = findMappingKeyWithLeft(currentCategory);
            if (currentMappingKey.isEmpty()) {
                return resolved;
            }
            currentValue = resolveMappedValue(mapping.get(currentMappingKey.get()), currentValue);
            currentCategory = currentMappingKey.get().right();

        }
    }

    private Long resolveMappedValue(List<MappingDefinition> mappingDefinitions, Long currentValue) {
        return currentValue + mappingDefinitions.stream()
                .filter(md -> currentValue >= md.sourceStart() && currentValue < md.sourceStart() + md.rangeLength())
                .findFirst()
                .map(md -> md.destinationStart() - md.sourceStart())
                .orElse(0L);
    }

    public long lowestLocation() {
        return seeds.stream().map(this::resolveSeed).mapToLong(m -> m.get(Category.location)).min().orElseThrow();
    }

    private Optional<Pair<Category, Category>> findMappingKeyWithLeft(Category currentCategory) {
        return mapping.keySet().stream().filter(k -> k.left() == currentCategory).findFirst();
    }
}
