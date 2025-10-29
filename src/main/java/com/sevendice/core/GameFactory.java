package com.sevendice.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Фабрика создаёт начальную игру (скелет): board, players, dice.
 */
public class GameFactory {
    public static Game createNewGame(int playersCount) {
        // TODO: валидировать playersCount 2..5
        Board board = switch (playersCount) {
            case 2 -> new Board(4,4);
            case 3 -> new Board(5,5);
            case 4 -> new Board(6,6);
            case 5 -> new Board(7,7);
            default -> throw new IllegalArgumentException("players 2..5");
        };
        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= playersCount; i++) {
            Player p = new Player("Player " + i);
            // добавить 7 костей каждому
            p.getDice().add(new Die(DieType.D4));
            p.getDice().add(new Die(DieType.D6));
            p.getDice().add(new Die(DieType.D8));
            p.getDice().add(new Die(DieType.D10));
            p.getDice().add(new Die(DieType.D10TENS));
            p.getDice().add(new Die(DieType.D12));
            p.getDice().add(new Die(DieType.D20));
            players.add(p);
        }
        long seed = System.currentTimeMillis();
        Random rng = new Random(seed);
        return new GameImpl(board, players, rng, seed);
    }
}