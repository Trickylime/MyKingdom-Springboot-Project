package com.trickylime.springboot.mykingdom.game.player.science;

public class Science {

    private boolean[] soldiers = new boolean[2];
    private int[] soldiersCost = {1_000, 100_000, 10_000_000};

    private boolean[] weapons = new boolean[3];
    private int[] weaponsCost = {30_000, 3_000_000, 300_000_000};

    private boolean[] wards = new boolean[5];
    private int[] wardsCost = {100_000, 100_000, 100_000, 30_000_000, 500_000_000};

    public Science() {
    }

    public boolean[] getSoldiers() {
        return soldiers;
    }

    public void setSoldiers(int i) {
        this.soldiers[i] = true;
    }

    public boolean[] getWeapons() {
        return weapons;
    }

    public void setWeapons(int i) {
        this.weapons[i] = true;
    }

    public boolean[] getWards() {
        return wards;
    }

    public void setWards(int i) {
        this.wards[i] = true;
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
