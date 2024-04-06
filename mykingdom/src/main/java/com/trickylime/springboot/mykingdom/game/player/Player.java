package com.trickylime.springboot.mykingdom.game.player;

import com.trickylime.springboot.mykingdom.game.player.science.Science;
import com.trickylime.springboot.mykingdom.game.player.soliders.Soliders;
import com.trickylime.springboot.mykingdom.game.player.upgrades.Upgrades;
import com.trickylime.springboot.mykingdom.game.player.weapons.Weapons;

public class Player {

    private int id;
    private String username;
    private String email;
    private long food = 1000;
    private long gold = 100_000;
    private int battleTurns = 10;
    private int attack = 10;
    private int defense = 10;
    private int spy = 10;
    private long workers = 10;
    private long farmers = 10;
    private long spies = 10;
    private final Soliders soliders;
    private final Weapons weapons;
    private final Upgrades upgrades;
    private final Science science;

    public Player(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.soliders = new Soliders();
        this.weapons = new Weapons();
        this.upgrades = new Upgrades();
        this.science = new Science();
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public long getFood() {
        return food;
    }

    public long getGold() {
        return gold;
    }

    public int getBattleTurns() {
        return battleTurns;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpy() {
        return spy;
    }

    public void setFood(long food) {
        this.food += food;
    }

    public void setGold(long gold) {
        this.gold += gold;
    }

    public void setBattleTurns(int battleTurns) {
        this.battleTurns += battleTurns;
    }

    public void setAttack(int attack) {
        this.attack += attack;
    }

    public void setDefense(int defense) {
        this.defense += defense;
    }

    public void setSpy(int spy) {
        this.spy += spy;
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

    public Soliders getSoldiers() {
        return soliders;
    }

    public Weapons getWeapons() {
        return weapons;
    }

    public Upgrades getUpgrades() {
        return upgrades;
    }

    public Science getScience() {
        return science;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", food=" + food +
                ", gold=" + gold +
                ", battleTurns=" + battleTurns +
                '}';
    }
}
