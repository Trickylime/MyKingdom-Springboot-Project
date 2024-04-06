package com.trickylime.springboot.mykingdom.game.player.weapons;

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
}
