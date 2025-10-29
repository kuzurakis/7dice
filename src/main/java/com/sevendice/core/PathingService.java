package com.sevendice.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * PathingService реализует правила движения кости по полю:
 *  - движение "вниз по столбцу" (увеличение row)
 *  - при переходе за нижнюю клетку столбца — переход на верх следующего столбца справа
 *  - если следующий столбец выходит за поле — это считается "выходом за поле" (exited=true)
 *
 * Метод traverse возвращает список внутренних позиций, через которые пройдет кость (не включая
 * выход за поле), флаг exited и индекс столбца, в котором кость должна будет стартовать при следующем входе.
 */
public class PathingService {

    public static final class PathResult {
        private final List<Position> positions;
        private final boolean exited;
        private final int exitColumn; // column index where die would start after exit (>= board.getCols() if outside)

        public PathResult(List<Position> positions, boolean exited, int exitColumn) {
            this.positions = Collections.unmodifiableList(new ArrayList<>(positions));
            this.exited = exited;
            this.exitColumn = exitColumn;
        }

        public List<Position> getPositions() { return positions; }
        public boolean isExited() { return exited; }
        public int getExitColumn() { return exitColumn; }

        @Override
        public String toString() {
            return "PathResult{positions=" + positions + ", exited=" + exited + ", exitColumn=" + exitColumn + "}";
        }
    }

    /**
     * Пройти до steps шагов, начиная от стартовой позиции (start). Возвращает последовательность
     * внутренних позиций (только те, что находятся на поле) и признак выхода за поле.
     *
     * start — текущая позиция кости (текущая клетка). Точки включения: метод считает шаги как перемещения
     * на следующие клетки (т.е. не включает стартовую в возвращаемую последовательность).
     */
    public PathResult traverse(Position start, int steps, Board board) {
        Objects.requireNonNull(start, "start");
        Objects.requireNonNull(board, "board");
        if (steps < 0) throw new IllegalArgumentException("steps must be >= 0");

        List<Position> visited = new ArrayList<>();
        int curCol = start.getCol();
        int curRow = start.getRow();
        int cols = board.getCols();
        int rows = board.getRows();

        for (int i = 0; i < steps; i++) {
            int nextRow = curRow + 1;
            int nextCol = curCol;
            if (nextRow >= rows) {
                nextRow = 0;
                nextCol = curCol + 1;
            }
            // if nextCol is outside board -> exit
            if (nextCol >= cols) {
                // did not add an out-of-board position
                return new PathResult(visited, true, nextCol);
            }
            // add in-board position
            Position p = new Position(nextCol, nextRow);
            visited.add(p);
            curCol = nextCol;
            curRow = nextRow;
        }
        // finished steps without exiting
        return new PathResult(visited, false, -1);
    }
}
