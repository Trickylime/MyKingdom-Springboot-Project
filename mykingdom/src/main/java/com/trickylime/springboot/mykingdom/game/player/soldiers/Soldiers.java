package com.trickylime.springboot.mykingdom.game.player.soldiers;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;

import java.util.List;

@Embeddable
public class Soldiers {

    private final List<String> attackerNames = List.of("Swordsmen", "Great Swordsmen", "Master Swordsmen");
    private final List<String> defenderNames = List.of("Bowmen", "Great Bowmen", "Master Bowmen");

    private long apprenticeWarriors = 1;
    private final long apprenticeWarriorsCost = 20;
    private final long apprenticeWarriorsStrength = 1;

    @ElementCollection
    private List<Long> attackers = List.of(1L, 0L, 0L);
    @ElementCollection
    private List<Long> defenders = List.of(1L, 0L, 0L);

    @ElementCollection
    private final List<Long> soldiersCost = List.of(100L, 1000L, 10_000L);
    @ElementCollection
    private final List<Long> soldiersStrength = List.of(10L, 200L, 5000L);

    public Soldiers() {
    }

    public long getAttackSoldierStrength() {
        return calculateSoldierStrength(attackers);
    }

    public long getDefenceSoldierStrength() {
        return calculateSoldierStrength(defenders);
    }

    public long calculateSoldierStrength(List<Long> soldiers) {
        long soldierStrengthTotal = 0;

        for (int i = 0; i < soldiers.size(); i++) {
            soldierStrengthTotal += soldiers.get(i) * soldiersStrength.get(i);
        }

        soldierStrengthTotal += apprenticeWarriors * apprenticeWarriorsStrength;

        return soldierStrengthTotal;
    }

    public String getAttackerNames(int index) {
        return attackerNames.get(index);
    }

    public String getDefenderNames(int index) {
        return defenderNames.get(index);
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
        return attackers.get(level);
    }

    public void setAttackers(int level, long attackers) {
        this.attackers.set(level, this.attackers.get(level) + attackers);
    }

    public long getDefenders(int level) {
        return defenders.get(level);
    }

    public void setDefenders(int level, long defenders) {
        this.defenders.set(level, this.defenders.get(level) + defenders);
    }

    public long getSoldiersCost(int level) {
        return soldiersCost.get(level);
    }

    public long getSoldiersStrength(int level) {
        return soldiersStrength.get(level);
    }

    public long getTotal(String request) {
        long attackSoldiersTotal = attackers.stream().mapToLong(Long::longValue).sum();
        long defenseSoldiersTotal = defenders.stream().mapToLong(Long::longValue).sum();

        return switch (request) {
            case "attack" -> attackSoldiersTotal;
            case "defense" -> defenseSoldiersTotal;
            case "total" -> attackSoldiersTotal + defenseSoldiersTotal + apprenticeWarriors;
            default -> throw new IllegalStateException("Unexpected value: " + request);
        };
    }
}
