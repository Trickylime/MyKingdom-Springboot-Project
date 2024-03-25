package com.trickylime.springboot.mykingdom.game.player;

public class VillagerSupplyForm {

    private int workers;
    private int farmers;
    private int spies;

    public VillagerSupplyForm() {
    }

    public int getWorkers() {
        return workers;
    }

    public void setWorkers(int workers) {
        this.workers = workers;
    }

    public int getFarmers() {
        return farmers;
    }

    public void setFarmers(int farmers) {
        this.farmers = farmers;
    }

    public int getSpies() {
        return spies;
    }

    public void setSpies(int spies) {
        this.spies = spies;
    }

    @Override
    public String toString() {
        return "VillagerSupplyForm{" +
                "workers=" + workers +
                ", farmers=" + farmers +
                ", spies=" + spies +
                '}';
    }
}
