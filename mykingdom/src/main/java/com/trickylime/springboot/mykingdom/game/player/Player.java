package com.trickylime.springboot.mykingdom.game.player;

import com.trickylime.springboot.mykingdom.game.Battle;
import com.trickylime.springboot.mykingdom.game.player.science.Science;
import com.trickylime.springboot.mykingdom.game.player.soldiers.Soldiers;
import com.trickylime.springboot.mykingdom.game.player.upgrades.Upgrades;
import com.trickylime.springboot.mykingdom.game.player.villagers.Villagers;
import com.trickylime.springboot.mykingdom.game.player.weapons.Weapons;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Player {
    @GeneratedValue

    private int id;
    private String username;
    private String email;
    private long food = 0;
    private long gold = 0;
    private int battleTurns = 0;
    private final Villagers villagers;
    private final Soldiers soldiers;
    private final Weapons weapons;
    private final Upgrades upgrades;
    private final Science science;
    private List<Battle> attackHistory;
    private List<Battle> defenseHistory;

    public Player(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.gold = 1_000_000;
        this.food = 1_000_000;
        this.battleTurns = 9;
        this.villagers = new Villagers();
        this.soldiers = new Soldiers();
        this.weapons = new Weapons();
        this.upgrades = new Upgrades();
        this.science = new Science();
        this.attackHistory = new ArrayList<>();
        this.defenseHistory = new ArrayList<>();
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

        long attack = soldiers.getAttackSoldierStrength()
                + weapons.getAttackWeaponStrength(attackers);
        attack += attack * getUpgrades().getMultiplier(upgrades.getAttackLevel());

        return attack;
    }

    public long getDefense() {

        long defenders = soldiers.getTotal("defense");

        long defense = soldiers.getDefenceSoldierStrength()
                + weapons.getDefenseWeaponStrength(defenders);
        defense += defense * getUpgrades().getMultiplier(upgrades.getDefenseLevel());

        return defense;
    }

    public long getSpy() {

        long spies = villagers.getSpies();

        long espionage = spies * 20;
        espionage += espionage * getUpgrades().getMultiplier((upgrades.getSpyLevel()));

        return espionage;
    }

    public long getFarmingIncome() {

        long farmers = villagers.getFarmers();
        long workers = villagers.getWorkers();

        long farmingIncome = (long) ((farmers * 3) + (workers * 0.1));
        farmingIncome += farmingIncome * getUpgrades().getMultiplier(upgrades.getFarmLevel());

        return farmingIncome;
    }

    public long getGoldIncome() {

        long workers = villagers.getWorkers();
        long farmers = villagers.getFarmers();

        return (long) ((workers * 2) + (farmers * 0.1));
    }

    public long getPopulation() {
        return villagers.getTotal() + soldiers.getTotal("total");
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

    public List<Battle> getAttackHistory() {
        return attackHistory;
    }

    public void addAttackHistory(Battle battle) {
        this.attackHistory.add(battle);
    }

    public List<Battle> getDefenseHistory() {
        return defenseHistory;
    }

    public void addDefenseHistory(Battle battle) {
        this.defenseHistory.add(battle);
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
