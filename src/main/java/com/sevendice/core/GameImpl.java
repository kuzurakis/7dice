package com.sevendice.core;

import java.util.List;
import java.util.Random;

public class GameImpl implements Game {
    private final Board board;
    private final List<Player> players;
    private final Random rng;
    private final long seed;
    public GameImpl(Board board, List<Player> players, Random rng, long seed) {
        this.board = board;
        this.players = players;
        this.rng = rng;
        this.seed = seed;
    }
    @Override public Board getBoard() { return board; }
    @Override public List<Player> getPlayers() { return players; }
    @Override public long getSeed() { return seed; }

    // TODO: реализация ходов, логики правил, capture resolver, scoring engine и т.д.
}