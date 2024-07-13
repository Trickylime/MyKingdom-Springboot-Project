package com.trickylime.springboot.mykingdom.game.player.villagers;

import jakarta.persistence.Embeddable;

@Embeddable
public class Villagers {

    private long workers = 0;
    private long farmers = 0;
    private long spies = 0;

    public Villagers() {
        this.workers = 10;
        this.farmers = 10;
        this.spies = 5;
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
        return getWorkers() + getFarmers() + getSpies();
    }
}
