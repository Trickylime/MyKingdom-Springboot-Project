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
}
