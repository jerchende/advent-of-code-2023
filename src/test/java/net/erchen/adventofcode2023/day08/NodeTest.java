package net.erchen.adventofcode2023.day08;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NodeTest {

    @Test
    void shouldParseInput() {
        Node node = Node.fromInput("AAA = (BBB, CCC)");

        assertThat(node.name()).isEqualTo("AAA");
        assertThat(node.left()).isEqualTo("BBB");
        assertThat(node.right()).isEqualTo("CCC");

    }
}