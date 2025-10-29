package com.sevendice.core;

import java.util.List;

public interface Game {
    Board getBoard();
    List<Player> getPlayers();
    long getSeed();
    // TODO: методы getCurrentPlayer(), makeMove(), save(), load(), endTurn(), etc.
}