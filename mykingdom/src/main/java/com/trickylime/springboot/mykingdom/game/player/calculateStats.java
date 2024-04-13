package com.trickylime.springboot.mykingdom.game.player;

public class calculateStats {

    private long attack = 0;
    private long defense = 0;
    private long spy = 0;
    private long farming = 0;
    private long gold = 0;
    private long population = 0;

    private long[] attDefSpyFarmGoldPop = new long[6];

    public calculateStats() {
    }

    public long getAttack() {
        return attack;
    }

    public long getDefense() {
        return defense;
    }

    public long getSpy() {
        return spy;
    }

    public long getFarming() {
        return farming;
    }

    public long getGold() {
        return gold;
    }

    public long getPopulation() {
        return population;
    }
}
