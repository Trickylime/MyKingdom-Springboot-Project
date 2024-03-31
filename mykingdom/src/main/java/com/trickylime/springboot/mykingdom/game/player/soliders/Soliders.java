package com.trickylime.springboot.mykingdom.game.player.soliders;

public class Soliders {

    private long apprenticeWarriors = 0;
    private long attackerLvl1 = 1;
    private long attackerLvl2 = 0;
    private long attackerLvl3 = 0;
    private long defenderLvl1 = 1;
    private long defenderLvl2 = 0;
    private long defenderLvl3 = 0;
    private long apprenticeWarCost = 20;
    private long apprenticeWarStr = 1;
    private long attDefLvl1Cost = 100;
    private long attDefLvl2Cost = 1000;
    private long attDefLvl3Cost = 10_000;
    private long attDefLvl1Str = 10;
    private long attDefLvl2Str = 200;
    private long attDefLvl3Str = 5000;

    public Soliders() {
    }

    public long getApprenticeWarriors() {
        return apprenticeWarriors;
    }

    public void setApprenticeWarriors(long apprenticeWarriors) {
        this.apprenticeWarriors += apprenticeWarriors;
    }

    public long getAttackerLvl1() {
        return attackerLvl1;
    }

    public void setAttackerLvl1(long attackerLvl1) {
        this.attackerLvl1 += attackerLvl1;
    }

    public long getAttackerLvl2() {
        return attackerLvl2;
    }

    public void setAttackerLvl2(long attackerLvl2) {
        this.attackerLvl2 += attackerLvl2;
    }

    public long getAttackerLvl3() {
        return attackerLvl3;
    }

    public void setAttackerLvl3(long attackerLvl3) {
        this.attackerLvl3 += attackerLvl3;
    }

    public long getDefenderLvl1() {
        return defenderLvl1;
    }

    public void setDefenderLvl1(long defenderLvl1) {
        this.defenderLvl1 += defenderLvl1;
    }

    public long getDefenderLvl2() {
        return defenderLvl2;
    }

    public void setDefenderLvl2(long defenderLvl2) {
        this.defenderLvl2 += defenderLvl2;
    }

    public long getDefenderLvl3() {
        return defenderLvl3;
    }

    public void setDefenderLvl3(long defenderLvl3) {
        this.defenderLvl3 += defenderLvl3;
    }

    public long getAttDefLvl1Cost() {
        return attDefLvl1Cost;
    }

    public void setAttDefLvl1Cost(long attDefLvl1Cost) {
        this.attDefLvl1Cost = attDefLvl1Cost;
    }

    public long getAttDefLvl2Cost() {
        return attDefLvl2Cost;
    }

    public void setAttDefLvl2Cost(long attDefLvl2Cost) {
        this.attDefLvl2Cost = attDefLvl2Cost;
    }

    public long getAttDefLvl3Cost() {
        return attDefLvl3Cost;
    }

    public void setAttDefLvl3Cost(long attDefLvl3Cost) {
        this.attDefLvl3Cost = attDefLvl3Cost;
    }

    public long getAttDefLvl1Str() {
        return attDefLvl1Str;
    }

    public void setAttDefLvl1Str(long attDefLvl1Str) {
        this.attDefLvl1Str += attDefLvl1Str;
    }

    public long getAttDefLvl2Str() {
        return attDefLvl2Str;
    }

    public void setAttDefLvl2Str(long attDefLvl2Str) {
        this.attDefLvl2Str += attDefLvl2Str;
    }

    public long getAttDefLvl3Str() {
        return attDefLvl3Str;
    }

    public void setAttDefLvl3Str(long attDefLvl3Str) {
        this.attDefLvl3Str += attDefLvl3Str;
    }

    public long getApprenticeWarCost() {
        return apprenticeWarCost;
    }

    public void setApprenticeWarCost(long apprenticeWarCost) {
        this.apprenticeWarCost = apprenticeWarCost;
    }

    public long getApprenticeWarStr() {
        return apprenticeWarStr;
    }

    public void setApprenticeWarStr(long apprenticeWarStr) {
        this.apprenticeWarStr += apprenticeWarStr;
    }
}
