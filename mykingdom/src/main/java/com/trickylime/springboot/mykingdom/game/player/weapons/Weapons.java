package com.trickylime.springboot.mykingdom.game.player.weapons;

public class Weapons {

    private long attackWepLvl0 = 1;
    private long attackWepLvl1 = 0;
    private long attackWepLvl2 = 0;
    private long attackWepLvl3 = 0;

    private long defendWepLvl0 = 1;
    private long defendWepLvl1 = 0;
    private long defendWepLvl2 = 0;
    private long defendWepLvl3 = 0;

    private final long wepLvl0Cost = 10;
    private final long wepLvl1Cost = 100;
    private final long wepLvl2Cost = 10_00;
    private final long wepLvl3Cost = 100_000;

    private final long wepLvl0RefundCost = wepLvl0Cost / 2;
    private final long wepLvl1RefundCost = wepLvl1Cost / 2;
    private final long wepLvl2RefundCost = wepLvl2Cost / 2;
    private final long wepLvl3RefundCost = wepLvl3Cost / 2;

    private final long wepLvl0Str = 10;
    private final long wepLvl1Str = 1000;
    private final long wepLvl2Str = 100_000;
    private final long wepLvl3Str = 1_000_000;

    public Weapons() {
    }

    public long getAttackWepLvl0() {
        return attackWepLvl0;
    }

    public void setAttackWepLvl0(long attackWepLvl0) {
        this.attackWepLvl0 += attackWepLvl0;
    }

    public long getAttackWepLvl1() {
        return attackWepLvl1;
    }

    public void setAttackWepLvl1(long attackWepLvl1) {
        this.attackWepLvl1 += attackWepLvl1;
    }

    public long getAttackWepLvl2() {
        return attackWepLvl2;
    }

    public void setAttackWepLvl2(long attackWepLvl2) {
        this.attackWepLvl2 += attackWepLvl2;
    }

    public long getAttackWepLvl3() {
        return attackWepLvl3;
    }

    public void setAttackWepLvl3(long attackWepLvl3) {
        this.attackWepLvl3 += attackWepLvl3;
    }

    public long getDefendWepLvl0() {
        return defendWepLvl0;
    }

    public void setDefendWepLvl0(long defendWepLvl0) {
        this.defendWepLvl0 += defendWepLvl0;
    }

    public long getDefendWepLvl1() {
        return defendWepLvl1;
    }

    public void setDefendWepLvl1(long defendWepLvl1) {
        this.defendWepLvl1 += defendWepLvl1;
    }

    public long getDefendWepLvl2() {
        return defendWepLvl2;
    }

    public void setDefendWepLvl2(long defendWepLvl2) {
        this.defendWepLvl2 += defendWepLvl2;
    }

    public long getDefendWepLvl3() {
        return defendWepLvl3;
    }

    public void setDefendWepLvl3(long defendWepLvl3) {
        this.defendWepLvl3 += defendWepLvl3;
    }

    public long getWepLvl0Cost() {
        return wepLvl0Cost;
    }

    public long getWepLvl1Cost() {
        return wepLvl1Cost;
    }

    public long getWepLvl2Cost() {
        return wepLvl2Cost;
    }

    public long getWepLvl3Cost() {
        return wepLvl3Cost;
    }

    public long getWepLvl0Str() {
        return wepLvl0Str;
    }

    public long getWepLvl1Str() {
        return wepLvl1Str;
    }

    public long getWepLvl2Str() {
        return wepLvl2Str;
    }

    public long getWepLvl3Str() {
        return wepLvl3Str;
    }

    public long getWepLvl0RefundCost() {
        return wepLvl0RefundCost;
    }

    public long getWepLvl1RefundCost() {
        return wepLvl1RefundCost;
    }

    public long getWepLvl2RefundCost() {
        return wepLvl2RefundCost;
    }

    public long getWepLvl3RefundCost() {
        return wepLvl3RefundCost;
    }
}
