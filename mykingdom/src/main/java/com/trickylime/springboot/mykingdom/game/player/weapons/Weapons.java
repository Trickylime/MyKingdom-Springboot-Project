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

    public Weapons() {
    }

    public long getAttackWeaponStrength(long attackers) {

        boolean tooManyWeapons = attackers < getTotal("attack");
        long attackWeaponTotal = getTotal("attack");
        return calculateWeaponStrength(attackers, attackWeapons, tooManyWeapons, attackWeaponTotal);
    }

    public long getDefenseWeaponStrength(long defenders) {

        boolean tooManyWeapons = defenders < getTotal("defense");
        long defenseWeaponTotal = getTotal("defense");
        return calculateWeaponStrength(defenders, defenseWeapons, tooManyWeapons, defenseWeaponTotal);
    }

    public long calculateWeaponStrength(long soldiers, long[] weapons, boolean tooManyWeapons, long weaponTotal) {

        long weaponStrengthTotal = 0;
        long[] weaponsCopy = Arrays.copyOf(weapons, weapons.length);

        if (tooManyWeapons) {
            long weaponDiff = weaponTotal - soldiers;

            for (int i = weaponsCopy.length - 1; i >= 0; i--) {
                if (weaponsCopy[i] < weaponDiff) {
                    weaponDiff -= weaponsCopy[i];
                    weaponsCopy[i] = 0;
                } else {
                    weaponsCopy[i] -= weaponDiff;
                    weaponDiff = 0;
                }
            }
        }

        for (int i = 0; i < weaponsCopy.length; i++) {
            weaponStrengthTotal += weaponsCopy[i] * weaponStrength[i];
        }

        return weaponStrengthTotal;
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
