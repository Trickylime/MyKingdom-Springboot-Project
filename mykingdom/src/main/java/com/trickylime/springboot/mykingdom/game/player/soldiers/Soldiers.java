package com.trickylime.springboot.mykingdom.game.player.soldiers;

import java.util.Arrays;

public class Soldiers {

    private final String[] attackerNames = {"Swordsmen", "Great Swordsmen", "Master Swordsmen"};
    private final String[] defenderNames = {"Bowmen", "Great Bowmen", "Master Bowmen"};

    private long apprenticeWarriors = 1;
    private final long apprenticeWarriorsCost = 20;
    private final long apprenticeWarriorsStrength = 1;

    private long[] attackers = {1, 0, 0};
    private long[] defenders = {1, 0, 0};

    private final long[] soldiersCost = {100, 1000, 10_000};

    private final long[] soldiersStrength = {10, 200, 5000};

    public Soldiers() {
    }

    public long getAttackSoldierStrength() {
        return calculateSoldierStrength(attackers);
    }

    public long getDefenceSoldierStrength() {
        return calculateSoldierStrength(defenders);
    }

    public long calculateSoldierStrength(long[] soldiers) {

        long soldierStrengthTotal = 0;

        for (int i = 0; i < soldiers.length; i++) {
            soldierStrengthTotal += soldiers[i] * soldiersStrength[i];
        }

        soldierStrengthTotal += apprenticeWarriors * apprenticeWarriorsStrength;

        return soldierStrengthTotal;
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

    public long getTotal(String request) {

        long attackSoldiersTotal = Arrays.stream(attackers).sum();
        long defenseSoldiersTotal = Arrays.stream(defenders).sum();

        return switch (request) {
            case "attack" -> attackSoldiersTotal;
            case "defense" -> defenseSoldiersTotal;
            case "total" -> attackSoldiersTotal + defenseSoldiersTotal + apprenticeWarriors;
            default -> throw new IllegalStateException("Unexpected value: " + request);
        };
    }
}
