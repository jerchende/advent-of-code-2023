package net.erchen.adventofcode2022.day04;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ElfGroupTest {

    @Test
    void shouldInitFromInput() {
        var elfGroup = ElfGroup.fromInput("2-4,6-8");
        assertThat(elfGroup.elf1()).isEqualTo(new Section(2, 4));
        assertThat(elfGroup.elf2()).isEqualTo(new Section(6, 8));
    }

    @CsvSource({
            "2-4,6-8,false",
            "2-3,4-5,false",
            "5-7,7-9,false",
            "2-8,3-7,true",
            "6-6,4-6,true",
            "2-6,4-8,false",
            "4-6,6-6,true"
    })
    @ParameterizedTest
    void shouldFullyOverlaps(String section1S, String section2S, boolean isFullyOverlapped) {
        var section1 = Section.fromInput(section1S);
        var section2 = Section.fromInput(section2S);
        var elfGroup = new ElfGroup(section1, section2);

        assertThat(elfGroup.isFullyOverlapped()).isEqualTo(isFullyOverlapped);
    }

    @CsvSource({
            "2-4,6-8,false",
            "2-3,4-5,false",
            "5-7,7-9,true",
            "2-8,3-7,true",
            "6-6,4-6,true",
            "2-6,4-8,true",
            "4-6,6-6,true"
    })
    @ParameterizedTest
    void shouldPartiallyOverlaps(String section1S, String section2S, boolean isPartiallyOverlapped) {
        var section1 = Section.fromInput(section1S);
        var section2 = Section.fromInput(section2S);
        var elfGroup = new ElfGroup(section1, section2);

        assertThat(elfGroup.isPartiallyOverlapped()).isEqualTo(isPartiallyOverlapped);
    }
}