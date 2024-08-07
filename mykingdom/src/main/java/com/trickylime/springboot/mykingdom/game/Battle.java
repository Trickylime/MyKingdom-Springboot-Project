package com.trickylime.springboot.mykingdom.game;

import com.trickylime.springboot.mykingdom.game.player.Player;
import jakarta.persistence.*;

@Entity
public class Battle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @ManyToOne
    @JoinColumn(name = "opponent_id", nullable = false)
    private Player opponent;
    private int battleTurnsSpent;
    private long attack;
    private long defense;
    private boolean win;
    private long gold;

    public Battle() {
        // Default constructor for JPA
    }
    public Battle(Player player, Player opponent, int battleTurnsSpent) {
        this.player = player;
        this.opponent = opponent;
        this.battleTurnsSpent = battleTurnsSpent;
        this.attack = (player.getAttack() * battleTurnsSpent) / 10;
        this.defense = opponent.getDefense();
        this.win = attack > defense;
        this.gold = win ? (long) (opponent.getGold() * 0.95) : 0;

        adjustPlayerValues(this.gold, this.battleTurnsSpent);
    }

    public void adjustPlayerValues(long gold, int battleTurnsSpent) {

        if (win) {
            player.setGold(gold);
            opponent.setGold(-gold);
        }

        player.setBattleTurns(-battleTurnsSpent);
    }

    public Player getPlayer() {
        return player;
    }

    public Player getOpponent() {
        return opponent;
    }

    public boolean isWin() {
        return win;
    }

    public long getAttack() {
        return attack;
    }

    public long getDefense() {
        return defense;
    }

    public long getGold() {
        return gold;
    }

    public String toHTML() {
        return """
                <div>your forces deal %d damage!</div>
                </br>
                <div>%s's defenses deal %d damage!</div>
                </br>
                <div>You %s the battle! %s
                """.formatted(attack, opponent.getUsername(), defense,
                win ? "won" : "lost", win ? "You stole " + gold + " gold!" : "");
    }

    @Override
    public String toString() {
        return """
                %s battles %s 
                %s deals %d damage
                %s defends %d damage
                %s %s %d gold!
                """.formatted(player.getUsername(), opponent.getUsername(), player.getUsername(), attack,
                opponent.getUsername(), defense, player.getUsername(), win ? "wins" : "lost", gold);
    }
}
