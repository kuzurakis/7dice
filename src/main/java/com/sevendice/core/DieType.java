package com.sevendice.core;

public enum DieType {
    D4(4), D6(6), D8(8), D10(10), D10TENS(10), D12(12), D20(20);

    private final int sides;

    DieType(int sides) {
        this.sides = sides;
    }

    public int getSides() {
        return sides;
    }
}