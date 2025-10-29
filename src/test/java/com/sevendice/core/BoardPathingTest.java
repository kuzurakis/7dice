package com.sevendice.core;

import org.junit.jupiter.api.Test;
import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.*;

public class BoardPathingTest {
    @Test
    public void testPathingTwoByTwo() {
        Board board = new Board(2,2);
        Position start = new Position(0,0);
        Iterator<Position> it = board.pathFrom(start, 3);
        assertTrue(it.hasNext());
        Position p1 = it.next(); // (0,1)
        assertEquals(new Position(0,1), p1);
        Position p2 = it.next(); // (1,0)
        assertEquals(new Position(1,0), p2);
        Position p3 = it.next(); // (1,1)
        assertEquals(new Position(1,1), p3);
        assertFalse(it.hasNext());
    }
}