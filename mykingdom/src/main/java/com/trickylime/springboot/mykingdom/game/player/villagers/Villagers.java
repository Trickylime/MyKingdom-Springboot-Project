package com.trickylime.springboot.mykingdom.game.player.villagers;

public class Villagers {

    private long workers = 10;
    private long farmers = 10;
    private long spies = 10;
    private long total = 30;

    public Villagers() {
    }

    public long getWorkers() {
        return workers;
    }

    public void setWorkers(long workers) {
        this.workers += workers;
    }

    public long getFarmers() {
        return farmers;
    }

    public void setFarmers(long farmers) {
        this.farmers += farmers;
    }

    public long getSpies() {
        return spies;
    }

    public void setSpies(long spies) {
        this.spies += spies;
    }

    public long getTotal() {
        this.total = getWorkers() + getFarmers() + getSpies();
        return total;
    }
}
