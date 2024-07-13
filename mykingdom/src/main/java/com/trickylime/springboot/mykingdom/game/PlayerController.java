package com.trickylime.springboot.mykingdom.game;

import com.trickylime.springboot.mykingdom.game.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PlayerController {

    @Autowired
    private PlayerService playerService;

//    public PlayerController(PlayerService playerService) {
//        this.playerService = playerService;
//    }

    @RequestMapping("main")
    public String listPlayerStats(@ModelAttribute("player") Player player, ModelMap model) {
        return "main";
    }

    @RequestMapping(value = "villagers", method = RequestMethod.GET)
    public String villagersPage(@ModelAttribute("player") Player player, ModelMap model) {
        return "villagers";
    }


    @RequestMapping(value = "buyVillagers", method = RequestMethod.POST)
    public String buyVillagers(@ModelAttribute("player") Player player,
                               @RequestParam int workers, @RequestParam int farmers, @RequestParam int spies,
                               ModelMap model) {

        if (playerService.buyVillagers(player, workers, farmers, spies)) {
            return "redirect:villagers";
        } else {
            model.put("errorMessage", "Insufficient food. Please try again.");
            model.put("player", player);

            return "villagers";
        }
    }

    @RequestMapping(value = "sellVillagers", method = RequestMethod.POST)
    public String sellVillagers(@ModelAttribute("player") Player player,
                                @RequestParam int workers, @RequestParam int farmers, @RequestParam int spies,
                                ModelMap model) {

        if (playerService.sellVillagers(player, workers, farmers, spies)) {
            return "redirect:villagers";
        } else {
            model.put("errorMessage", "Insufficient villagers. Please try again.");
            model.put("player", player);

            return "villagers";
        }
    }

    @RequestMapping(value = "soldiers", method = RequestMethod.GET)
    public String soldiersPage(@ModelAttribute("player") Player player, ModelMap model) {

        return "soldiers";
    }

    @RequestMapping(value = "hireApprentice", method = RequestMethod.POST)
    public String hireApprentice(@ModelAttribute("player") Player player,
                                 @RequestParam int apprenticeWarriors, ModelMap model) {

        if(playerService.hireApprentice(player, apprenticeWarriors)) {
            return "redirect:soldiers";
        } else {
            model.put("errorMessage", "Insufficient food. Please try again.");
            model.put("player", player);

            return "soldiers";
        }
    }

    @RequestMapping(value = "trainApprentice", method = RequestMethod.POST)
    public String trainApprentice(@ModelAttribute("player") Player player,
                                  @RequestParam long[] attackers, @RequestParam long[] defenders, ModelMap model) {

        if(playerService.trainApprentice(player, attackers, defenders)) {
            return "redirect:soldiers";
        } else {
            model.put("errorMessage", "Insufficient food. Please try again.");
            model.put("player", player);

            return "soldiers";
        }
    }

    @RequestMapping(value = "weapons", method = RequestMethod.GET)
    public String weaponsPage(@ModelAttribute("player") Player player, ModelMap model) {

        return "weapons";
    }

    @RequestMapping(value = "buyWeapons", method = RequestMethod.POST)
    public String buyWeapons(@ModelAttribute("player") Player player,
                             @RequestParam long[] attackWeapons, @RequestParam long[] defenseWeapons, ModelMap model) {

        if(playerService.buyWeapons(player, attackWeapons, defenseWeapons)) {
            return "redirect:weapons";
        } else {
            model.put("errorMessage", "Insufficient gold. Please try again.");
            model.put("player", player);

            return "weapons";
        }
    }

    @RequestMapping(value = "sellWeapons", method = RequestMethod.POST)
    public String sellWeapons(@ModelAttribute("player") Player player,
                              @RequestParam long[] attackWeapons, @RequestParam long[] defenseWeapons, ModelMap model) {

        if(playerService.sellWeapons(player, attackWeapons, defenseWeapons)) {
            return "redirect:weapons";
        } else {
            model.put("errorMessage", "Insufficient weapons. Please try again.");
            model.put("player", player);

            return "weapons";
        }
    }

    @RequestMapping(value = "upgrades", method = RequestMethod.GET)
    public String upgradesPage(@ModelAttribute("player") Player player, ModelMap model) {

        return "upgrades";
    }

    @RequestMapping(value = "upgrades", method = RequestMethod.POST)
    public String buyUpgrade(@ModelAttribute("player") Player player,
                             @RequestParam String upgradeValue, ModelMap model) {

        if (playerService.buyUpgrade(player, upgradeValue)) {
            return "redirect:upgrades";
        } else {
            model.put("errorMessage", "Insufficient Gold. Please try again.");
            model.put("player", player);

            return "upgrades";
        }
    }

    @RequestMapping(value = "science", method = RequestMethod.GET)
    public String sciencePage(@ModelAttribute("player") Player player, ModelMap model) {

        return "science";
    }

    @RequestMapping(value = "research", method = RequestMethod.POST)
    public String buyScience(@ModelAttribute("player") Player player,
                             @RequestParam String researchValue, ModelMap model) {

        if (playerService.buyScience(player, researchValue)) {
            return "redirect:science";
        } else {
            model.put("errorMessage", "Insufficient Gold. Please try again.");
            model.put("player", player);

            return "science";
        }
    }

    @RequestMapping(value = "rankings", method = RequestMethod.GET)
    public String playerRankings(@ModelAttribute("player") Player player, ModelMap model) {

        List<Player> playerList = playerService.getAllPlayersList();
        model.put("playerList", playerList);

        return "rankings";
    }

    @RequestMapping(value = "stats/{username}", method = RequestMethod.GET)
    public String opponentStats(@ModelAttribute("player") Player player,
                                @PathVariable String username,
                                @RequestParam(value = "errorMessage", required = false) String errorMessage,
                                ModelMap model) {

        Player opponent = playerService.findPlayerByUsername(username);
        model.put("opponent", opponent);
        model.put("battleCount", playerService.calculateBattleCount(player, opponent));

        if (errorMessage != null) {
            model.put("errorMessage", errorMessage);
        }

        return "stats";
    }

    @RequestMapping(value = "battle", method = RequestMethod.POST)
    public String battleOpponent(@ModelAttribute("player") Player player,
                                 @RequestParam String opponentUsername, @RequestParam int battleTurnsSpent,
                                 RedirectAttributes redirectAttributes, ModelMap model) {

        Player opponent = playerService.findPlayerByUsername(opponentUsername);
        model.put("opponent", opponent);

        PlayerService.BattleResult result = playerService.battleOpponents(player, opponentUsername, battleTurnsSpent);
        String errorMessage = "";

        switch (result) {
            case SUCCESS -> {
                String battleResults = player.getAttackHistory().get(player.getAttackHistory().size() - 1).toHTML();
                model.put("battleResults", battleResults);
                return "battle";
            }
            case INSUFFICIENT_BATTLE_TURNS -> errorMessage = "Insufficient turns. Please try again.";
            case MAX_BATTLE_COUNT_REACHED -> errorMessage = "You've attacked this poor player too much. Please wait and try again.";
        }
        redirectAttributes.addFlashAttribute("errorMessage", errorMessage);
        return "redirect:stats/" + opponentUsername;
    }

    @RequestMapping(value = "spy", method = RequestMethod.POST)
    public String spyOnPlayer(@ModelAttribute("player") Player player,
                              @RequestParam String opponentUsername, ModelMap model) {

        Player opponent = playerService.findPlayerByUsername(opponentUsername);
        model.put("opponent", opponent);

        if (playerService.spyOnOpponents(player, opponent)) {
            return "spy";
        }

        return "caught";
    }

    @RequestMapping(value = "history")
    public String combatHistory(@ModelAttribute("player") Player player, ModelMap model) {

        List<Battle> attackHistory = player.getAttackHistory();
        model.put("attackHistory", attackHistory);

        List<Battle> defenseHistory = player.getDefenseHistory();
        model.put("defenseHistory", defenseHistory);

        return "history";
    }

    public Player getLoggedInUser() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

        return playerService.findPlayerByUsername(username);
    }

    @ModelAttribute("player")
    public Player getPlayer() {
        return getLoggedInUser();
    }

}
