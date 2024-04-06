package com.trickylime.springboot.mykingdom.game.player.science;

public class Science {

    private boolean[] soldiersUnlocked = new boolean[2];
    private int[] soldiersCost = {1_000, 100_000, 10_000_000};

    private boolean[] weaponsUnlocked = new boolean[3];
    private int[] weaponsCost = {30_000, 3_000_000, 300_000_000};

    private boolean[] wardsUnlocked = new boolean[5];
    private int[] wardsCost = {100_000, 100_000, 100_000, 30_000_000, 500_000_000};

    public Science() {
    }

    public boolean[] getSoldiersUnlocked() {
        return soldiersUnlocked;
    }

    public void setSoldiersUnlocked(int i) {
        this.soldiersUnlocked[i] = true;
    }

    public boolean[] getWeaponsUnlocked() {
        return weaponsUnlocked;
    }

    public void setWeaponsUnlocked(int i) {
        this.weaponsUnlocked[i] = true;
    }

    public boolean[] getWards() {
        return wardsUnlocked;
    }

    public void setWards(int i) {
        this.wardsUnlocked[i] = true;
    }

    public int getSoldiersCost(int i) {
        return soldiersCost[i];
    }

    public int getWeaponsCost(int i) {
        return weaponsCost[i];
    }

    public int getWardsCost(int i) {
        return wardsCost[i];
    }
}
