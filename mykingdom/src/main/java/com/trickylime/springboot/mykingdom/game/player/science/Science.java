package com.trickylime.springboot.mykingdom.game.player.science;

public class Science {

    private boolean[] attackersUnlocked = {true, false, false};
    private boolean[] defendersUnlocked = {true, false, false};

    private int[] soldiersCost = {1_000, 100_000, 10_000_000};

    private boolean[] weaponsUnlocked = {true, false, false, false};
    private int[] weaponsCost = {30_000, 3_000_000, 300_000_000};

    private boolean[] wardsUnlocked = new boolean[5];
    private int[] wardsCost = {100_000, 100_000, 100_000, 30_000_000, 500_000_000};

    public Science() {
    }

    public boolean getAttackersUnlocked(int level) {
        return attackersUnlocked[level];
    }

    public void setAttackersUnlocked(int i) {
        this.attackersUnlocked[i] = true;
    }

    public boolean getDefendersUnlocked(int level) {
        return defendersUnlocked[level];
    }

    public void setDefendersUnlocked(int i) {
        this.defendersUnlocked[i] = true;
    }

    public boolean getWeaponsUnlocked(int level) {
        return weaponsUnlocked[level];
    }

    public void setWeaponsUnlocked(int i) {
        this.weaponsUnlocked[i] = true;
    }

    public boolean getWardsUnlocked(int level) {
        return wardsUnlocked[level];
    }

    public void setWardsUnlocked(int i) {
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
