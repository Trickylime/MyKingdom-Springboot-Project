package com.trickylime.springboot.mykingdom.game.player.upgrades;

import jakarta.persistence.Embeddable;

@Embeddable
public class Upgrades {

    private int attackLevel = 0;
    private int defenseLevel = 0;
    private int spyLevel = 0;
    private int farmLevel = 0;
    private long attackUpgradeCost = 100;
    private long defenseUpgradeCost = 100;
    private long spyUpgradeCost = 100;
    private long farmUpgradeCost = 100;

    public Upgrades() {
    }

    public double getMultiplier(int upgrade) {
        return 0.03 * upgrade;
    }

    public void upgradeAttack() {
        attackLevel++;
        attackUpgradeCost += attackUpgradeCost * 0.2;
    }
    public void upgradeDefense() {
        defenseLevel++;
        defenseUpgradeCost += defenseUpgradeCost * 0.2;
    }
    public void upgradeSpy() {
        spyLevel++;
        spyUpgradeCost += spyUpgradeCost * 0.2;
    }
    public void upgradeFarming() {
        farmLevel++;
        farmUpgradeCost += farmUpgradeCost * 0.2;
    }

    public int getAttackLevel() {
        return attackLevel;
    }

    public int getDefenseLevel() {
        return defenseLevel;
    }

    public int getSpyLevel() {
        return spyLevel;
    }

    public int getFarmLevel() {
        return farmLevel;
    }

    public long getAttackUpgradeCost() {
        return attackUpgradeCost;
    }

    public long getDefenseUpgradeCost() {
        return defenseUpgradeCost;
    }

    public long getSpyUpgradeCost() {
        return spyUpgradeCost;
    }

    public long getFarmUpgradeCost() {
        return farmUpgradeCost;
    }
}
