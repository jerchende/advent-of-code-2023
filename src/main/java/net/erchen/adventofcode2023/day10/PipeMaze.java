package net.erchen.adventofcode2023.day10;

import net.erchen.codingpuzzlescommon.matrix.Matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public record PipeMaze(Matrix<PipeType> matrix) {

    public static PipeMaze fromInput(String input) {
        return new PipeMaze(Matrix.fromInput(input, "\n", "", PipeType::fromRepresentation));
    }

    Matrix<PipeType>.Field animal() {
        return matrix.allFields().filter(field -> field.getValue() == PipeType.animal).findFirst().orElseThrow();
    }

    public List<Matrix<PipeType>.Field> pipeline() {
        List<Matrix<PipeType>.Field> pipeline = new LinkedList<>();
        pipeline.add(animal());

        var currentField = animal();
        while (true) {
            PipeType currentFieldValue = currentField.getValue();
            PipeType rightFieldValue = currentField.right().filter(field -> !pipeline.contains(field)).map(Matrix.Field::getValue).orElse(PipeType.ground);
            PipeType leftFieldValue = currentField.left().filter(field -> !pipeline.contains(field)).map(Matrix.Field::getValue).orElse(PipeType.ground);
            PipeType topFieldValue = currentField.top().filter(field -> !pipeline.contains(field)).map(Matrix.Field::getValue).orElse(PipeType.ground);
            PipeType bottomFieldValue = currentField.bottom().filter(field -> !pipeline.contains(field)).map(Matrix.Field::getValue).orElse(PipeType.ground);

            // right
            if (hasFieldsMatching(currentFieldValue, PipeType.animal, PipeType.horizontal, PipeType.lPipe, PipeType.fPipe) && hasFieldsMatching(rightFieldValue, PipeType.horizontal, PipeType.jPipe, PipeType.sevenPipe)) {
                currentField = currentField.right().get();
                pipeline.add(currentField);
                continue;
            }

            // left
            if (hasFieldsMatching(currentFieldValue, PipeType.animal, PipeType.horizontal, PipeType.jPipe, PipeType.sevenPipe) && hasFieldsMatching(leftFieldValue, PipeType.horizontal, PipeType.lPipe, PipeType.fPipe)) {
                currentField = currentField.left().get();
                pipeline.add(currentField);
                continue;
            }

            // top
            if (hasFieldsMatching(currentFieldValue, PipeType.animal, PipeType.vertical, PipeType.lPipe, PipeType.jPipe) && hasFieldsMatching(topFieldValue, PipeType.vertical, PipeType.fPipe, PipeType.sevenPipe)) {
                currentField = currentField.top().get();
                pipeline.add(currentField);
                continue;
            }

            // bottom
            if (hasFieldsMatching(currentFieldValue, PipeType.animal, PipeType.vertical, PipeType.fPipe, PipeType.sevenPipe) && hasFieldsMatching(bottomFieldValue, PipeType.vertical, PipeType.lPipe, PipeType.jPipe)) {
                currentField = currentField.bottom().get();
                pipeline.add(currentField);
                continue;
            }

            break;
        }

        return pipeline;
    }

 /*   public long countFullySurroundedByPipeline() {
        // Get the pipeline fields for easy reference
        List<Matrix<PipeType>.Field> pipelineFields = this.pipeline();
        Map<Matrix<PipeType>.Field, Boolean> cache = new HashMap<>();

        // Stream through all fields in the matrix
        return matrix.allFields().filter(field -> isFullySurrounded(field, pipelineFields, cache)).count();
    }

    static boolean isFullySurrounded(final Matrix<PipeType>.Field currentField, final List<Matrix<PipeType>.Field> pipeline, Map<Matrix<PipeType>.Field, Boolean> cache) {
        Boolean cached = cache.get(currentField);
        if (cached!=null) {
            return cached;
        }

        if (currentField.right().isEmpty() || currentField.left().isEmpty() || currentField.top().isEmpty() || currentField.bottom().isEmpty()) {
            cache.put(currentField, false);
            return false;
        }

        var rightField = currentField.right().filter(pipeline::contains).orElse(null);
        var leftField = currentField.left().filter(pipeline::contains).orElse(null);
        var topField = currentField.top().filter(pipeline::contains).orElse(null);
        var bottomField = currentField.bottom().filter(pipeline::contains).orElse(null);

        boolean isFullySurrounded = ((pipeline.contains(rightField) && rightField.getValue() == PipeType.vertical) || isFullySurrounded(currentField.right().get(), pipeline, cache)) &&
                //((pipeline.contains(leftField) && leftField.getValue() == PipeType.vertical) || isFullySurrounded(currentField.left().get(), pipeline, cache)) &&
                //((pipeline.contains(topField) && topField.getValue() == PipeType.horizontal) || isFullySurrounded(currentField.top().get(), pipeline, cache)) &&
                ((pipeline.contains(bottomField) && bottomField.getValue() == PipeType.horizontal) || isFullySurrounded(currentField.bottom().get(), pipeline, cache));
        cache.put(currentField, isFullySurrounded);
        return isFullySurrounded;
    }*/

    static boolean hasFieldsMatching(PipeType current, PipeType... allowedTypes) {
        return Arrays.asList(allowedTypes).contains(current);
    }
}
