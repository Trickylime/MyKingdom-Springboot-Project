package com.trickylime.springboot.mykingdom.game;

import com.trickylime.springboot.mykingdom.game.player.Player;
import com.trickylime.springboot.mykingdom.game.player.PlayerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

@Service
@Transactional
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;
    private static List<Player> players = new ArrayList<>();

    public Player findByUsername(String username) {

        Predicate<? super Player> predicate =
                player -> player.getUsername().equalsIgnoreCase(username);

        List<Player> filteredPlayers = players.stream()
                .filter(predicate)
                .toList();

        if (!filteredPlayers.isEmpty()) return filteredPlayers.get(0);

        throw new NoSuchElementException("Player with username '" + username + "' not found");
    }

    public Player findPlayerByUsername(String username) {
        return playerRepository.findByUsername(username).orElse(null);
    }

    public List<Player> getAllPlayersList() {
        return playerRepository.findAll();
    }

    public boolean buyVillagers(Player player, int workers, int farmers, int spies) {

        int totalSpend = (workers + farmers + spies) * 20;
        if(totalSpend <= player.getFood()) {
            player.getVillagers().setWorkers(workers);
            player.getVillagers().setFarmers(farmers);
            player.getVillagers().setSpies(spies);

            player.setFood(-totalSpend);

            return true;
        }

        return false;
    }

    public boolean sellVillagers(Player player, int workers, int farmers, int spies) {

        if (player.getVillagers().getWorkers() >= workers
                && player.getVillagers().getFarmers() >= farmers
                && player.getVillagers().getSpies() >= spies) {
            player.getVillagers().setWorkers(-workers);
            player.getVillagers().setFarmers(-farmers);
            player.getVillagers().setSpies(-spies);

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
            totalSpend += (attackers[i] + defenders[i]) * player.getSoldiers().getSoldiersCost(i);
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

            for(int i = 0; i < attackWeapons.length; i++) {
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


        switch(upgradeValue) {
            case "attack" -> {
                long upgradeCost = player.getUpgrades().getAttackUpgradeCost();
                if (player.getGold() >= upgradeCost) {
                    player.getUpgrades().upgradeAttack();
                    player.setGold(-upgradeCost);
                    return true;
                }
            }
            case "defense" -> {
                long upgradeCost = player.getUpgrades().getDefenseUpgradeCost();
                if (player.getGold() >= upgradeCost) {
                    player.getUpgrades().upgradeDefense();
                    player.setGold(-upgradeCost);
                    return true;
                }
            }
            case "spy" -> {
                long upgradeCost = player.getUpgrades().getSpyUpgradeCost();
                if (player.getGold() >= upgradeCost) {
                    player.getUpgrades().upgradeSpy();
                    player.setGold(-upgradeCost);
                    return true;
                }
            }
            case "farm" -> {
                long upgradeCost = player.getUpgrades().getFarmUpgradeCost();
                if (player.getGold() >= upgradeCost) {
                    player.getUpgrades().upgradeFarming();
                    player.setGold(-upgradeCost);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean buyScience(Player player, String researchValue) {

        int levelIndex = Integer.parseInt(String.valueOf(researchValue.charAt(researchValue.length() - 1)));
        researchValue = researchValue.substring(0, 3);

        switch (researchValue) {
            case "atk" -> {
                if(player.getGold() >= player.getScience().getSoldiersCost(levelIndex)) {
                    player.getScience().setAttackersUnlocked(levelIndex);
                    player.setGold(-player.getScience().getSoldiersCost(levelIndex));
                    return true;
                }
            }
            case "def" -> {
                if (player.getGold() >= player.getScience().getSoldiersCost(levelIndex)) {
                    player.getScience().setDefendersUnlocked(levelIndex);
                    player.setGold(-player.getScience().getSoldiersCost(levelIndex));
                    return true;
                }
            }
            case "wea" -> {
                if (player.getGold() >= player.getScience().getWeaponsCost(levelIndex - 1)) {
                    player.getScience().setWeaponsUnlocked(levelIndex);
                    player.setGold(-player.getScience().getWeaponsCost(levelIndex - 1));
                    return true;
                }
            }
            case "war" -> {
                if (player.getGold() >= player.getScience().getWardsCost(levelIndex)) {
                    player.getScience().setWardsUnlocked(levelIndex);
                    player.setGold(-player.getScience().getWardsCost(levelIndex));
                    return true;
                }
            }
        }
        return false;
    }

    public int calculateBattleCount(Player player, Player opponent) {
        int opponentBattleCount = 0;
        for (int i = 0; i < opponent.getDefenseHistory().size(); i++) {
            if (opponent.getDefenseHistory().get(i).getPlayer() == player) {
                opponentBattleCount++;
                if (opponentBattleCount >= 5) break;
            }
        }
        return opponentBattleCount;
    }

    public enum BattleResult {
        SUCCESS,
        INSUFFICIENT_BATTLE_TURNS,
        MAX_BATTLE_COUNT_REACHED
    }


    public BattleResult battleOpponents(Player player, String opponentUsername, int battleTurnsSpent) {

        Player opponent = findPlayerByUsername(opponentUsername);

        if (battleTurnsSpent > player.getBattleTurns()) {
            return BattleResult.INSUFFICIENT_BATTLE_TURNS;
        }

        if (calculateBattleCount(player, opponent) == 5) {
            return BattleResult.MAX_BATTLE_COUNT_REACHED;
        }

        Battle battle = new Battle(player, opponent, battleTurnsSpent);
        player.addAttackHistory(battle);
        opponent.addDefenseHistory(battle);

        System.out.println(battle);
        return BattleResult.SUCCESS;
    }

    public boolean spyOnOpponents(Player player, Player opponent) {

        return player.getSpy() > opponent.getSpy();
    }
}
