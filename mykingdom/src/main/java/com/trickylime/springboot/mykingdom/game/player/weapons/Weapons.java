package com.trickylime.springboot.mykingdom.game.player.weapons;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;

import java.util.List;

@Embeddable
public class Weapons {

    private final List<String> attackWeaponNames = List.of("Wooden Sword", "Steel Sword", "Earth Shaking Great Sword", "Planet Splitting God Sword");
    private final List<String> defenseWeaponNames = List.of("Slingshot", "Longbow", "Skull Splitting Compound Bow", "Soul Piercing Crystal God Bow");

    @ElementCollection
    private List<Long> attackWeapons = List.of(1L, 0L, 0L, 0L);

    @ElementCollection
    private List<Long> defenseWeapons = List.of(1L, 0L, 0L, 0L);

    @ElementCollection
    private final List<Integer> weaponCost = List.of(10, 100, 1_000, 100_000);

    @ElementCollection
    private List<Integer> weaponRefundCost = List.of(weaponCost.get(0) / 2, weaponCost.get(1) / 2, weaponCost.get(2) / 2, weaponCost.get(3) / 2);

    @ElementCollection
    private List<Long> weaponStrength = List.of(10L, 1_000L, 100_000L, 1_000_000L);

    public Weapons() {
    }

    public long getAttackWeaponStrength(long attackers) {
        boolean tooManyWeapons = attackers < getTotal("attack");
        long attackWeaponTotal = getTotal("attack");
        return calculateWeaponStrength(attackers, attackWeapons, tooManyWeapons, attackWeaponTotal);
    }

    public long getDefenseWeaponStrength(long defenders) {
        boolean tooManyWeapons = defenders < getTotal("defense");
        long defenseWeaponTotal = getTotal("defense");
        return calculateWeaponStrength(defenders, defenseWeapons, tooManyWeapons, defenseWeaponTotal);
    }

    public long calculateWeaponStrength(long soldiers, List<Long> weapons, boolean tooManyWeapons, long weaponTotal) {
        long weaponStrengthTotal = 0;
        Long[] weaponsArray = weapons.toArray(new Long[0]);
        if (tooManyWeapons) {
            long weaponDiff = weaponTotal - soldiers;

            for (int i = weaponsArray.length - 1; i >= 0; i--) {
                if (weaponsArray[i] < weaponDiff) {
                    weaponDiff -= weaponsArray[i];
                    weaponsArray[i] = 0L;
                } else {
                    weaponsArray[i] -= weaponDiff;
                    weaponDiff = 0;
                }
            }
        }

        for (int i = 0; i < weaponsArray.length; i++) {
            weaponStrengthTotal += weaponsArray[i] * weaponStrength.get(i);
        }

        return weaponStrengthTotal;
    }

    public String getAttackWeaponNames(int level) {
        return attackWeaponNames.get(level);
    }

    public String getDefenseWeaponNames(int level) {
        return defenseWeaponNames.get(level);
    }

    public long getAttackWeapons(int level) {
        return attackWeapons.get(level);
    }

    public void setAttackWeapons(int level, long attackWeapons) {
        this.attackWeapons.set(level, this.attackWeapons.get(level) + attackWeapons);
    }

    public long getDefenseWeapons(int level) {
        return defenseWeapons.get(level);
    }

    public void setDefenseWeapons(int level, long defenseWeapons) {
        this.defenseWeapons.set(level, this.defenseWeapons.get(level) + defenseWeapons);
    }

    public int getWeaponCost(int level) {
        return weaponCost.get(level);
    }

    public int getWeaponRefundCost(int level) {
        return weaponRefundCost.get(level);
    }

    public long getWeaponStrength(int level) {
        return weaponStrength.get(level);
    }

    public long getTotal(String request) {
        long attackWeaponsTotal = attackWeapons.stream().mapToLong(Long::longValue).sum();
        long defenseWeaponsTotal = defenseWeapons.stream().mapToLong(Long::longValue).sum();

        return switch (request) {
            case "attack" -> attackWeaponsTotal;
            case "defense" -> defenseWeaponsTotal;
            case "total" -> attackWeaponsTotal + defenseWeaponsTotal;
            default -> throw new IllegalStateException("Unexpected value: " + request);
        };
    }
}