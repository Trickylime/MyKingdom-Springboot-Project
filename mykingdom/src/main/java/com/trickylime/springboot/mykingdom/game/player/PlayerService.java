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

        long totalSpend = player.getSoldiers().getApprenticeWarCost() * apprenticeWarriors;
        if (player.getFood() >= totalSpend) {
            player.getSoldiers().setApprenticeWarriors(apprenticeWarriors);
            player.setFood(-totalSpend);

            return true;
        }

        return false;
    }

    public boolean trainApprentice(Player player, int attackerLvl1, int defenderLvl1, int attackerLvl2,
                                   int defenderLvl2, int attackerLvl3, int defenderLvl3) {

        long level1Cost = (player.getSoldiers().getAttDefLvl1Cost() * attackerLvl1)
                + (player.getSoldiers().getAttDefLvl1Cost() * defenderLvl1);

        long level2Cost = (player.getSoldiers().getAttDefLvl2Cost() * attackerLvl2)
                + (player.getSoldiers().getAttDefLvl2Cost() * defenderLvl2);

        long level3Cost = (player.getSoldiers().getAttDefLvl3Cost() * attackerLvl3)
                + (player.getSoldiers().getAttDefLvl3Cost() * defenderLvl3);

        long totalSpend = level1Cost + level2Cost + level3Cost;

        long apprenticeCost = attackerLvl1 + attackerLvl2 + attackerLvl3 + defenderLvl1 + defenderLvl2 + defenderLvl3;

        if (player.getFood() >= totalSpend && player.getSoldiers().getApprenticeWarriors() >= apprenticeCost) {
            player.getSoldiers().setAttackerLvl1(attackerLvl1);
            player.getSoldiers().setAttackerLvl2(attackerLvl2);
            player.getSoldiers().setAttackerLvl3(attackerLvl3);

            player.getSoldiers().setDefenderLvl1(defenderLvl1);
            player.getSoldiers().setDefenderLvl2(defenderLvl2);
            player.getSoldiers().setDefenderLvl3(defenderLvl3);

            player.setFood(-totalSpend);
            player.getSoldiers().setApprenticeWarriors(-apprenticeCost);

            return true;
        }

        return false;
    }

    public boolean buyWeapons(Player player, int attackWepLvl0, int defendWepLvl0, int attackWepLvl1, int defendWepLvl1,
                              int attackWepLvl2, int defendWepLvl2, int attackWepLvl3, int defendWepLvl3) {

        long level0Cost = (attackWepLvl0 + defendWepLvl0) * player.getWeapons().getWepLvl0Cost();
        long level1Cost = (attackWepLvl1 + defendWepLvl1) * player.getWeapons().getWepLvl1Cost();
        long level2Cost = (attackWepLvl2 + defendWepLvl2) * player.getWeapons().getWepLvl2Cost();
        long level3Cost = (attackWepLvl3 + defendWepLvl3) * player.getWeapons().getWepLvl3Cost();

        long totalSpend = level0Cost + level1Cost + level2Cost + level3Cost;

        if (player.getGold() >= totalSpend) {
            player.getWeapons().setAttackWepLvl0(attackWepLvl0);
            player.getWeapons().setAttackWepLvl1(attackWepLvl1);
            player.getWeapons().setAttackWepLvl2(attackWepLvl2);
            player.getWeapons().setAttackWepLvl3(attackWepLvl3);

            player.getWeapons().setDefendWepLvl0(defendWepLvl0);
            player.getWeapons().setDefendWepLvl1(defendWepLvl1);
            player.getWeapons().setDefendWepLvl2(defendWepLvl2);
            player.getWeapons().setDefendWepLvl3(defendWepLvl3);

            player.setGold(-totalSpend);

            return true;
        }

        return false;
    }

    public boolean sellWeapons(Player player, int attackWepLvl0, int defendWepLvl0, int attackWepLvl1, int defendWepLvl1,
                              int attackWepLvl2, int defendWepLvl2, int attackWepLvl3, int defendWepLvl3) {

        long level0RefundCost = (attackWepLvl0 + defendWepLvl0) * player.getWeapons().getWepLvl0RefundCost();
        long level1RefundCost = (attackWepLvl1 + defendWepLvl1) * player.getWeapons().getWepLvl1RefundCost();
        long level2RefundCost = (attackWepLvl2 + defendWepLvl2) * player.getWeapons().getWepLvl2RefundCost();
        long level3RefundCost = (attackWepLvl3 + defendWepLvl3) * player.getWeapons().getWepLvl3RefundCost();

        long totalRefund = level0RefundCost + level1RefundCost + level2RefundCost + level3RefundCost;

        if (player.getWeapons().getAttackWepLvl0() >= attackWepLvl0
                && player.getWeapons().getDefendWepLvl0() >= defendWepLvl0
                && player.getWeapons().getAttackWepLvl1() >= attackWepLvl1
                && player.getWeapons().getDefendWepLvl1() >= defendWepLvl1
                && player.getWeapons().getAttackWepLvl1() >= attackWepLvl2
                && player.getWeapons().getDefendWepLvl1() >= defendWepLvl2
                && player.getWeapons().getAttackWepLvl1() >= attackWepLvl3
                && player.getWeapons().getDefendWepLvl1() >= defendWepLvl3) {

            player.getWeapons().setAttackWepLvl0(-attackWepLvl0);
            player.getWeapons().setAttackWepLvl1(-attackWepLvl1);
            player.getWeapons().setAttackWepLvl2(-attackWepLvl2);
            player.getWeapons().setAttackWepLvl3(-attackWepLvl3);

            player.getWeapons().setDefendWepLvl0(-defendWepLvl0);
            player.getWeapons().setDefendWepLvl1(-defendWepLvl1);
            player.getWeapons().setDefendWepLvl2(-defendWepLvl2);
            player.getWeapons().setDefendWepLvl3(-defendWepLvl3);

            player.setGold(totalRefund);

            return true;
        }

        return false;
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
