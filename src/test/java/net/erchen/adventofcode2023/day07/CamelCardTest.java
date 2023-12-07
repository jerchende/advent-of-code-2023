package net.erchen.adventofcode2023.day07;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CamelCardTest {

    @Test
    void shouldParseFromInput() {
        var camelCards = CamelCard.fromInput("23AKQ");

        assertThat(camelCards).containsExactly(
                new CamelCard('2'),
                new CamelCard('3'),
                new CamelCard('A'),
                new CamelCard('K'),
                new CamelCard('Q')
        );
    }

    @Test
    void shouldOrder() {
        var camelCards = CamelCard.fromInput("A6T5K47J89Q32");

        var sorted = Arrays.stream(camelCards).sorted().toList();

        assertThat(sorted).extracting(CamelCard::getValue).containsExactly('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A');
    }
}