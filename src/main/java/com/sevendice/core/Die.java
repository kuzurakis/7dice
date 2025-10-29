package com.sevendice.core;

import java.util.Random;
import java.util.Objects;

public class Die {
    private final DieType type;
    private int faceUp; // last rolled face (for D10TENS store 0..90)
    public Die(DieType type) {
        this.type = Objects.requireNonNull(type);
        this.faceUp = 0;
    }
    public DieType getType() { return type; }
    public int getFaceUp() { return faceUp; }

    public int roll(Random rng) {
        int raw = rng.nextInt(type.getSides()) + 1; // 1..sides
        if (type == DieType.D10TENS) {
            // convert 1..10 -> 0,10..90: interpret face 10 as 0 tens (i.e., 0)
            int tens = (raw % 10) * 10;
            this.faceUp = tens;
            return tens;
        } else {
            this.faceUp = raw;
            return raw;
        }
    }
}