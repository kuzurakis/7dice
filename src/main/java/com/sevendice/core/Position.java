package com.sevendice.core;

import java.util.Objects;

public final class Position {
    private final int col;
    private final int row;
    public Position(int col, int row) {
        if (col < 0 || row < 0) throw new IllegalArgumentException("Negative coordinate");
        this.col = col;
        this.row = row;
    }
    public int getCol() { return col; }
    public int getRow() { return row; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position p = (Position) o;
        return col == p.col && row == p.row;
    }
    @Override
    public int hashCode() { return Objects.hash(col, row); }
    @Override
    public String toString(){ return "P(" + col + "," + row + ")"; }
}