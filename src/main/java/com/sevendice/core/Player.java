package com.sevendice.core;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Player {
    private final String id;
    private final String name;
    private final List<Die> dice = new ArrayList<>();

    public Player(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public List<Die> getDice() { return dice; }
}