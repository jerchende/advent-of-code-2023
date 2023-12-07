package net.erchen.adventofcode2023.day07;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CamelCardHandTest {

    @Test
    void shouldParseInput() {
        var camelCardHand = CamelCardHand.fromInput("32T3K 765");

        assertThat(camelCardHand.hand()).extracting(CamelCard::getValue).containsExactly('3', '2', 'T', '3', 'K');
        assertThat(camelCardHand.bid()).isEqualTo(765);
    }

    @Test
    void shouldCalculateOrderValue() {
        var camelCardHand = CamelCardHand.fromInput("22222 0");

        assertThat(Long.toBinaryString(camelCardHand.orderValue())).isEqualTo("11000100010001000100010");
    }

    @ParameterizedTest
    @CsvSource({
            "AAAAA,6",
            "AAAA2,5",
            "AAA22,4",
            "AAA12,3",
            "AA221,2",
            "AA234,1",
            "AD234,0"
    })
    void shouldCalculateTypeValue(String hand, int expectedTypeValue) {
        assertThat(CamelCardHand.calculateTypeValue(CamelCard.fromInput(hand))).isEqualTo(expectedTypeValue);
    }

    @ParameterizedTest
    @CsvSource({
            "AAAAA,6",
            "AAAAJ,6",
            "AAAJJ,6",
            "AAJJJ,6",
            "AJJJJ,6",
            "AAAA2,5",
            "AAAJ2,5",
            "AAJJ2,5",
            "AJJJ2,5",
            "AAA22,4",
            "AAJ22,4",
            "AAA12,3",
            "AAJ12,3",
            "AJJ12,3",
            "AA221,2",
            "AA234,1",
            "AJ234,1",
            "AD234,0"
    })
    void shouldCalculateTypeValueWithJokers(String hand, int expectedTypeValue) {
        assertThat(CamelCardHand.calculateTypeValue(CamelCardWithJoker.fromInput(hand))).isEqualTo(expectedTypeValue);
    }

    @Test
    void shouldSort() {
        var hands = List.of(
                CamelCardHand.fromInput("32T3K 1"),
                CamelCardHand.fromInput("T55J5 4"),
                CamelCardHand.fromInput("KK677 3"),
                CamelCardHand.fromInput("KTJJT 2"),
                CamelCardHand.fromInput("QQQJA 5"));

        assertThat(hands.stream().sorted()).extracting(CamelCardHand::bid).containsExactly(1, 2, 3, 4, 5);
    }
}