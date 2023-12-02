package net.erchen.adventofcode2023.day02;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CubeConundrumGameTest {

    @Test void shouldParseFromInput() {
        var cubeConundrumGame = CubeConundrumGame.fromInput("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red");

        assertThat(cubeConundrumGame.id()).isEqualTo(3);
        assertThat(cubeConundrumGame.examinations()).hasSize(3);
    }

    @Test
    void fewest() {
        var game = CubeConundrumGame.fromInput("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red");

        assertThat(game.fewest().red()).isEqualTo(20);
        assertThat(game.fewest().green()).isEqualTo(13);
        assertThat(game.fewest().blue()).isEqualTo(6);
    }

    @Test
    void power() {
        var game = CubeConundrumGame.fromInput("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red");

        assertThat(game.power()).isEqualTo(1560);
    }
}