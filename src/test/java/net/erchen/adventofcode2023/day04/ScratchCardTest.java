package net.erchen.adventofcode2023.day04;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ScratchCardTest {

    @Test
    void shouldParseFromInput() {
        var scratchCard = ScratchCard.fromInput("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53");

        assertThat(scratchCard.cardId()).isEqualTo(1);
        assertThat(scratchCard.winningNumbers()).containsExactlyInAnyOrder(41, 48, 83, 86, 17);
        assertThat(scratchCard.yourNumbers()).containsExactlyInAnyOrder(83, 86, 6, 31, 17, 9, 48, 53);
    }

    @Test
    void shouldGetYourWinningNumbers() {
        var scratchCard = ScratchCard.fromInput("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53");

        assertThat(scratchCard.yourWinningNumbers()).containsExactlyInAnyOrder(48, 83, 17, 86);
    }

    @ParameterizedTest
    @CsvSource({
            "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53,8",
            "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19,2",
            "Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1,2",
            "Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83,1",
            "Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36,0",
            "Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11,0"
    })
    void shouldGetPoints(String card, int expectedPoints) {
        var scratchCard = ScratchCard.fromInput(card);

        assertThat(scratchCard.points()).isEqualTo(expectedPoints);
    }
}