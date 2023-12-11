package net.erchen.adventofcode2023.day10;


import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public enum PipeType {
    vertical('|'),
    horizontal('-'),
    lPipe('L'),
    jPipe('J'),
    sevenPipe('7'),
    fPipe('F'),
    ground('.'),
    animal('S');


    final char representation;

    public static PipeType fromRepresentation(String representation) {
        return Arrays.stream(PipeType.values()).filter(pipeType -> pipeType.representation == representation.charAt(0)).findFirst().orElseThrow();
    }
}
