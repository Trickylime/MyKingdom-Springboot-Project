package com.trickylime.springboot.mykingdom.game.player.soliders;

public class Soliders {

    private final String[] attackerNames = {"Swordsmen", "Great Swordsmen", "Master Swordsmen"};
    private final String[] defenderNames = {"Bowmen", "Great Bowmen", "Master Bowmen"};

    private long apprenticeWarriors = 1;
    private long apprenticeWarriorsCost = 20;
    private long apprenticeWarriorsStrength = 1;

    private long[] attackers = {1, 0, 0};
    private long[] defenders = {1, 0, 0};

    private long[] soldiersCost = {100, 1000, 10_000};

    private long[] soldiersStrength = {10, 200, 5000};

    public Soliders() {
    }

    public String getAttackerNames(int index) {
        return attackerNames[index];
    }

    public String getDefenderNames(int index) {
        return defenderNames[index];
    }

    public long getApprenticeWarriors() {
        return apprenticeWarriors;
    }

    public void setApprenticeWarriors(long apprenticeWarriors) {
        this.apprenticeWarriors += apprenticeWarriors;
    }

    public long getApprenticeWarriorsCost() {
        return apprenticeWarriorsCost;
    }

    public long getApprenticeWarriorsStrength() {
        return apprenticeWarriorsStrength;
    }

    public long getAttackers(int level) {
        return attackers[level];
    }

    public void setAttackers(int level, long attackers) {
        this.attackers[level] += attackers;
    }

    public long getDefenders(int level) {
        return defenders[level];
    }

    public void setDefenders(int level, long defenders) {
        this.defenders[level] += defenders;
    }

    public long getSoldiersCost(int level) {
        return soldiersCost[level];
    }

    public long getSoldiersStrength(int level) {
        return soldiersStrength[level];
    }
}
