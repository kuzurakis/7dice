package com.sevendice.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Board представляет сетку MxN, умеет возвращать Cell и итератор пути для кости.
 * Важная логика маршрута: "вниз по столбцу → при переходе за нижнюю — верх следующего столбца справа".
 * Если кость выходит за поле (после последней клетки поля), она помечается как "вышла" и далее стартует с первой клетки этого столбца (по правилам) — поведение обеспечит PathingService.
 */
public class Board {
    private final int cols;
    private final int rows;
    private final Cell[][] grid;

    public Board(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.grid = new Cell[cols][rows];
        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                grid[c][r] = new Cell(new Position(c, r));
            }
        }
    }

    public int getCols() { return cols; }
    public int getRows() { return rows; }

    public Cell getCell(int col, int row) {
        if (col < 0 || col >= cols || row < 0 || row >= rows) throw new IndexOutOfBoundsException();
        return grid[col][row];
    }

    public Cell getStartCell() {
        return grid[0][0];
    }

    /**
     * Path iterator: возвращает последовательность позиций от заданной начальной (inclusive=false) на N шагов,
     * следуя правилам движения (вниз по столбцу, переход к следующему столбцу справа).
     * Если при проходе позиция выходит за поле — будет выброшен NoSuchElementException (маршрут кончается).
     */
    public Iterator<Position> pathFrom(Position start, int steps) {
        return new PathIterator(start, steps);
    }

    private class PathIterator implements Iterator<Position> {
        private int remaining;
        private int curCol;
        private int curRow;

        public PathIterator(Position start, int steps) {
            this.remaining = steps;
            this.curCol = start.getCol();
            this.curRow = start.getRow();
        }

        @Override
        public boolean hasNext() {
            // если следующий шаг пересекал бы за пределы поля, то маршрута больше нет
            int nextRow = curRow + 1;
            int nextCol = curCol;
            if (nextRow >= rows) {
                nextRow = 0;
                nextCol = curCol + 1;
            }
            return remaining > 0 && nextCol < cols;
        }

        @Override
        public Position next() {
            if (!hasNext()) throw new NoSuchElementException();
            // advance
            curRow++;
            if (curRow >= rows) {
                curRow = 0;
                curCol++;
            }
            remaining--;
            return new Position(curCol, curRow);
        }
    }
}