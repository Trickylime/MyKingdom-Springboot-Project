package com.trickylime.springboot.mykingdom.game.player.weapons;

import java.util.Arrays;

public class Weapons {

    private final String[] attackWeaponNames = {"Wooden Sword", "Steel Sword", "Earth Shaking Great Sword",
                                                "Planet Splitting God Sword"};
    private final String[] defenseWeaponNames = {"Slingshot", "Longbow", "Skull Splitting Compound Bow",
                                                "Soul Piercing Crystal God Bow"};
    private long[] attackWeapons = {1, 0, 0, 0};

    private long[] defenseWeapons = {1, 0, 0, 0};

    private final int[] weaponCost = {10, 100, 1_000, 100_000};

    private final int[] weaponRefundCost = {weaponCost[0] / 2, weaponCost[1] / 2, weaponCost[2] / 2, weaponCost[3] / 2};

    private final long[] weaponStrength = {10, 1000, 100_000, 1_00_000};

    private long[] weaponAttDefTotal = new long[2];

    public Weapons() {
    }

    public long[] getWeaponAttDefTotal(long attackers, long defenders) {

        if (attackers > Arrays.stream(attackWeapons).sum() && defenders > Arrays.stream(defenseWeapons).sum()) {
            for (int i = 0; i < attackWeapons.length; i++) {
                weaponAttDefTotal[0] += attackWeapons[i] * weaponStrength[i];
                weaponAttDefTotal[1] += defenseWeapons[i] * weaponStrength[i];
            }

        } else {

            long[] usableAttackWeapons = attackWeapons;
            long[] usableDefenseWeapons = defenseWeapons;

            long attackDiff = getTotal("attack") - attackers;
            long defenseDiff = getTotal("defense") - defenders;

            for (int i = attackWeapons.length - 1; i >= 0; i--) {

                if (usableAttackWeapons[i] < attackDiff) {
                    attackDiff -= usableAttackWeapons[i];
                } else {
                    usableAttackWeapons[i] = attackDiff;
                    attackDiff = 0;
                }

                if (usableDefenseWeapons[i] < defenseDiff) {
                    defenseDiff -= usableDefenseWeapons[i];
                } else {
                    usableDefenseWeapons[i] = defenseDiff;
                    defenseDiff = 0;
                }
            }

            for (int i = 0; i < attackWeapons.length; i++) {
                weaponAttDefTotal[0] += usableAttackWeapons[i] * weaponStrength[i];
                weaponAttDefTotal[1] += usableDefenseWeapons[i] * weaponStrength[i];
            }

        }

        return weaponAttDefTotal;


    }

    public String getAttackWeaponNames(int level) {
        return attackWeaponNames[level];
    }

    public String getDefenseWeaponNames(int level) {
        return defenseWeaponNames[level];
    }

    public long getAttackWeapons(int level) {
        return attackWeapons[level];
    }

    public void setAttackWeapons(int level, long attackWeapons) {
        this.attackWeapons[level] += attackWeapons;
    }

    public long getDefenseWeapons(int level) {
        return defenseWeapons[level];
    }

    public void setDefenseWeapons(int level, long defenseWeapons) {
        this.defenseWeapons[level] += defenseWeapons;
    }

    public int getWeaponCost(int level) {
        return weaponCost[level];
    }

    public int getWeaponRefundCost(int level) {
        return weaponRefundCost[level];
    }

    public long getWeaponStrength(int level) {
        return weaponStrength[level];
    }
    public long getTotal(String request) {

        long attackWeaponsTotal = Arrays.stream(attackWeapons).sum();
        long defenseWeaponsTotal = Arrays.stream(defenseWeapons).sum();

        return switch (request) {
            case "attack" -> attackWeaponsTotal;
            case "defense" -> defenseWeaponsTotal;
            case "total" -> attackWeaponsTotal + defenseWeaponsTotal;
            default -> throw new IllegalStateException("Unexpected value: " + request);
        };
    }
}
