package com.sevendice.core;

import java.util.Optional;

public class Cell {
    private final Position pos;
    private DieStack occupant; // wrapper: which player and which die sits here, nullable

    public Cell(Position pos) {
        this.pos = pos;
    }

    public Position getPosition() { return pos; }

    public Optional<DieStack> getOccupant() { return Optional.ofNullable(occupant); }

    public void setOccupant(DieStack stack) { this.occupant = stack; }

    public void clear() { this.occupant = null; }
}