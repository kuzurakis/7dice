package com.sevendice.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class PathingServiceTest {

    @Test
    public void traverseWithinBoard() {
        Board board = new Board(3,3);
        PathingService svc = new PathingService();
        Position start = new Position(0,0);
        PathingService.PathResult r = svc.traverse(start, 4, board);
        assertFalse(r.isExited());
        List<Position> pos = r.getPositions();
        assertEquals(4, pos.size());
        assertEquals(new Position(0,1), pos.get(0));
        assertEquals(new Position(0,2), pos.get(1));
        assertEquals(new Position(1,0), pos.get(2));
        assertEquals(new Position(1,1), pos.get(3));
    }

    @Test
    public void traverseImmediateExit() {
        Board board = new Board(2,2);
        PathingService svc = new PathingService();
        Position start = new Position(1,1);
        PathingService.PathResult r = svc.traverse(start, 1, board);
        assertTrue(r.isExited());
        assertEquals(0, r.getPositions().size());
        assertEquals(2, r.getExitColumn());
    }

    @Test
    public void traverseExactToLastCell() {
        Board board = new Board(2,2);
        PathingService svc = new PathingService();
        Position start = new Position(0,1);
        PathingService.PathResult r = svc.traverse(start, 1, board);
        assertFalse(r.isExited());
        List<Position> pos = r.getPositions();
        assertEquals(1, pos.size());
        assertEquals(new Position(1,0), pos.get(0));
    }
}