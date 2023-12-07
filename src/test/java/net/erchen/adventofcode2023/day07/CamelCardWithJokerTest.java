package net.erchen.adventofcode2023.day07;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CamelCardWithJokerTest {

    @Test
    void shouldDetectJoker() {
        assertThat(new CamelCardWithJoker('J').isJoker()).isTrue();
        assertThat(new CamelCardWithJoker('A').isJoker()).isFalse();
    }

    @Test
    void shouldReturnCustomJokerOrderValue() {
        assertThat(new CamelCardWithJoker('J').orderValue()).isEqualTo(1);
    }
}