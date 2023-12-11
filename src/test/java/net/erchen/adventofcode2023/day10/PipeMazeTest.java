package net.erchen.adventofcode2023.day10;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class PipeMazeTest {

    @SneakyThrows
    static String solutionInput() {
        return Files.readString(Path.of("src/test/resources/day10/input.txt"));
    }


    public static final String SIMPLE_MAZE = """
            .....
            .S-7.
            .|.|.
            .L-J.
            .....
            """;

    @Test
    void shouldParseInput() {
        PipeMaze pipeMaze = PipeMaze.fromInput(SIMPLE_MAZE);

        assertThat(pipeMaze.matrix().dimension()).isEqualTo(5);
    }

    @Test
    void shouldGetAnimal() {
        PipeMaze pipeMaze = PipeMaze.fromInput(SIMPLE_MAZE);

        assertThat(pipeMaze.animal().getX()).isEqualTo(1);
        assertThat(pipeMaze.animal().getY()).isEqualTo(1);
    }

    @Test
    void shouldGetPipeline() {
        PipeMaze pipeMaze = PipeMaze.fromInput(SIMPLE_MAZE);

        assertThat(pipeMaze.pipeline()).hasSize(8);
    }

    @Test
    void shouldGetPipeline_Solution() {
        PipeMaze pipeMaze = PipeMaze.fromInput(solutionInput());

        assertThat(pipeMaze.pipeline()).hasSize(6690 * 2);
    }

    /*
    @Test
    void shouldCountSurroundedFields1() {
        PipeMaze pipeMaze = PipeMaze.fromInput(SIMPLE_MAZE);

        assertThat(pipeMaze.countFullySurroundedByPipeline()).isEqualTo(1);
    }

    @Test
    void shouldCountSurroundedFields2() {
        PipeMaze pipeMaze = PipeMaze.fromInput("""
                ...........
                .S-------7.
                .|F-----7|.
                .||.....||.
                .||.....||.
                .|L-7.F-J|.
                .|..|.|..|.
                .L--J.L--J.
                ...........""");

        assertThat(pipeMaze.countFullySurroundedByPipeline()).isEqualTo(4);
    }

    @Test
    void shouldCountSurroundedFields3() {
        PipeMaze pipeMaze = PipeMaze.fromInput(solutionInput());

        assertThat(pipeMaze.countFullySurroundedByPipeline()).isGreaterThan(357);
    }
     */

    @Test
    @Disabled
    void printPipeline() {
        PipeMaze pipeMaze = PipeMaze.fromInput(solutionInput());
        var mainPipeline = pipeMaze.pipeline();

        for (int x = 0; x <= pipeMaze.matrix().dimension(); x++) {
            for (int y = 0; y <= pipeMaze.matrix().dimension(); y++) {
                System.out.print(mainPipeline.contains(pipeMaze.matrix().field(x, y)) ? pipeMaze.matrix().field(x, y).getValue().representation : ' ');
            }
            System.out.print("\n");
        }

    }
}