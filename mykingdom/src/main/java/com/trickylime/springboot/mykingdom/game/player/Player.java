package com.trickylime.springboot.mykingdom.game.player;

import com.trickylime.springboot.mykingdom.game.player.science.Science;
import com.trickylime.springboot.mykingdom.game.player.soldiers.Soldiers;
import com.trickylime.springboot.mykingdom.game.player.upgrades.Upgrades;
import com.trickylime.springboot.mykingdom.game.player.villagers.Villagers;
import com.trickylime.springboot.mykingdom.game.player.weapons.Weapons;

public class Player {

    private int id;
    private String username;
    private String email;
    private long food = 1000;
    private long gold = 100_000_000_000L;
    private int battleTurns = 10;
    private long attack = 10;
    private long defense = 10;
    private long spy = 10;
    private final Villagers villagers;
    private final Soldiers soldiers;
    private final Weapons weapons;
    private final Upgrades upgrades;
    private final Science science;

    private long[] attDefSpyFarmGoldPop = new long[6];

    public Player(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.villagers = new Villagers();
        this.soldiers = new Soldiers();
        this.weapons = new Weapons();
        this.upgrades = new Upgrades();
        this.science = new Science();
    }

    public long[] getAttDefSpyFarmGoldPop() {


        long attackTotal = getSoldiers().getSoldierAttDefTotal()[0];
        long farmingIncome = (getVillagers().getFarmers() * 20);
        farmingIncome += farmingIncome * getUpgrades().getMultiplyer(upgrades.getFarmLevel());

        long goldIncome = (getVillagers().getWorkers() * 100) + (getVillagers().getFarmers() * 10);
        long population = getVillagers().getTotal() + getSoldiers().getTotal("total");
        attDefSpyFarmGoldPop[0] = getSoldiers().getSoldierAttDefTotal()[0];
        attDefSpyFarmGoldPop[1] = getSoldiers().getSoldierAttDefTotal()[1];
//        attDefSpyFarmGoldPop[2] =;
//        attDefSpyFarmGoldPop[3] =;
//        attDefSpyFarmGoldPop[4] =;
//        attDefSpyFarmGoldPop[5] =;
        return attDefSpyFarmGoldPop;
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

    public long getAttack() {

        long attackers = soldiers.getTotal("attack");
        long defenders = soldiers.getTotal("defense");

        this.attack = soldiers.getSoldierAttDefTotal()[0]
                + weapons.getWeaponAttDefTotal(attackers, defenders)[0];
        this.attack += this.attack * getUpgrades().getMultiplyer(upgrades.getAttackLevel());

        return attack;
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

    public Villagers getVillagers() {
        return villagers;
    }

    public Soldiers getSoldiers() {
        return soldiers;
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
