package com.sevendice.core;

public class DieStack {
    private final Player owner;
    private final Die die;

    public DieStack(Player owner, Die die) {
        this.owner = owner;
        this.die = die;
    }

    public Player getOwner() { return owner; }
    public Die getDie() { return die; }
}