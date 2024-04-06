package com.trickylime.springboot.mykingdom.game.player;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class PlayerService {

    private static List<Player> players = new ArrayList<>();
    private static int playerCount = 0;
    static {
        players.add(new Player(playerCount++, "admin", "tricky@gmail.com"));
        players.add(new Player(playerCount++, "Cristian", "cristian@gmail.com"));
        players.add(new Player(playerCount++, "Dean", "dean@gmail.com"));
        players.add(new Player(playerCount++, "Steve", "steve@gmail.com"));
        players.add(new Player(playerCount++, "Katy", "katy@gmail.com"));
    }

    public List<Player> findByUsername(String username) {

        Predicate<? super Player> predicate =
                player -> player.getUsername().equalsIgnoreCase(username);

        return players.stream().filter(predicate).toList();
    }

    public Player addPlayer(String username, String email) {

        Player player = new Player(playerCount++, username, email);
        players.add(player);

        return player;
    }

    public boolean buyVillagers(Player player, int workers, int farmers, int spies) {

        int totalSpend = (workers + farmers + spies) * 20;
        if(totalSpend <= player.getFood()) {
            player.setWorkers(workers);
            player.setFarmers(farmers);
            player.setSpies(spies);

            player.setFood(-totalSpend);

            return true;
        }

        return false;
    }

    public boolean sellVillagers(Player player, int workers, int farmers, int spies) {

        if (player.getWorkers() >= workers && player.getFarmers() >= farmers && player.getSpies() >= spies) {
            player.setWorkers(-workers);
            player.setFarmers(-farmers);
            player.setSpies(-spies);

            int refundFood = (workers + farmers + spies) * 15;
            player.setFood(refundFood);

            return true;
        }

        return false;
    }

    public boolean hireApprentice(Player player, int apprenticeWarriors) {

        long totalSpend = player.getSoldiers().getApprenticeWarriorsCost() * apprenticeWarriors;
        if (player.getFood() >= totalSpend) {
            player.getSoldiers().setApprenticeWarriors(apprenticeWarriors);
            player.setFood(-totalSpend);

            return true;
        }

        return false;
    }

    public boolean trainApprentice(Player player, long[] attackers, long[] defenders) {

        long totalSpend = 0;
        long apprenticeCost = 0;

        for (int i = 0; i < attackers.length; i++) {
            totalSpend += attackers[i] + defenders[i] * player.getSoldiers().getSoldiersCost(i);
            apprenticeCost += attackers[i] + defenders[i];
        }

        if (player.getFood() >= totalSpend && player.getSoldiers().getApprenticeWarriors() >= apprenticeCost) {
            for (int i = 0; i < attackers.length; i++) {
                player.getSoldiers().setAttackers(i, attackers[i]);
                player.getSoldiers().setDefenders(i, defenders[i]);
            }

            player.setFood(-totalSpend);
            player.getSoldiers().setApprenticeWarriors(-apprenticeCost);

            return true;
        }

        return false;
    }

    public boolean buyWeapons(Player player, long[] attackWeapons, long[] defenseWeapons) {

        long totalSpend = 0;

        for (int i = 0; i < attackWeapons.length; i++) {
            totalSpend += (attackWeapons[i] + defenseWeapons[i]) * player.getWeapons().getWeaponCost(i);
        }

        if (player.getGold() >= totalSpend) {

            for(int i = 0; i <= 3; i++) {
                player.getWeapons().setAttackWeapons(i, attackWeapons[i]);
                player.getWeapons().setDefenseWeapons(i, defenseWeapons[i]);
            }

            player.setGold(-totalSpend);

            return true;
        }

        return false;
    }

    public boolean sellWeapons(Player player, long[] attackWeapons, long[] defenseWeapons) {

        for (int i = 0; i < attackWeapons.length; i++) {
            if (attackWeapons[i] > player.getWeapons().getAttackWeapons(i)
                    ||defenseWeapons[i] > player.getWeapons().getDefenseWeapons(i)) {
                return false;
            }
        }

        long totalRefund = 0;

        for (int i = 0; i < attackWeapons.length; i++) {
            totalRefund += (attackWeapons[i] + defenseWeapons[i]) * player.getWeapons().getWeaponRefundCost(i);

            player.getWeapons().setAttackWeapons(i, -attackWeapons[i]);
            player.getWeapons().setDefenseWeapons(i, -defenseWeapons[i]);
        }

        player.setGold(totalRefund);

        return true;
    }

    public boolean buyUpgrade(Player player, String upgradeValue) {

        long upgradeCost = 0;

        switch(upgradeValue) {
            case "attack" -> {
                upgradeCost = player.getUpgrades().getAttackUpgradeCost();
                if (player.getGold() >= upgradeCost) {
                    player.getUpgrades().upgradeAttack();
                    player.setGold(-upgradeCost);
                    return true;
                }
            }
            case "defense" -> {
                upgradeCost = player.getUpgrades().getDefenseUpgradeCost();
                if (player.getGold() >= upgradeCost) {
                    player.getUpgrades().upgradeDefense();
                    player.setGold(-upgradeCost);
                    return true;
                }
            }
            case "spy" -> {
                upgradeCost = player.getUpgrades().getSpyUpgradeCost();
                if (player.getGold() >= upgradeCost) {
                    player.getUpgrades().upgradeSpy();
                    player.setGold(-upgradeCost);
                    return true;
                }
            }
            case "farm" -> {
                upgradeCost = player.getUpgrades().getFarmUpgradeCost();
                if (player.getGold() >= upgradeCost) {
                    player.getUpgrades().upgradeFarming();
                    player.setGold(-upgradeCost);
                    return true;
                }
            }
        }
        return false;
    }
}
