package com.trickylime.springboot.mykingdom.game.player;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PlayerController {

    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping("main")
    public String ListPlayerStats(ModelMap model) {

        Player player = getLoggedInUser();
        model.put("player", player);

        return "main";
    }

    @RequestMapping(value = "villagers", method = RequestMethod.GET)
    public String villagersPage(ModelMap model) {

        Player player = getLoggedInUser();
        model.put("player", player);

        return "villagers";
    }


    @RequestMapping(value = "buyVillagers", method = RequestMethod.POST)
    public String buyVillagers(@RequestParam int workers, @RequestParam int farmers, @RequestParam int spies,
                               ModelMap model) {

        Player player = getLoggedInUser();

        if (playerService.buyVillagers(player, workers, farmers, spies)) {
            return "redirect:villagers";
        } else {
            model.put("errorMessage", "Insufficient food. Please try again.");
            model.put("player", player);

            return "villagers";
        }
    }

    @RequestMapping(value = "sellVillagers", method = RequestMethod.POST)
    public String sellVillagers(@RequestParam int workers, @RequestParam int farmers, @RequestParam int spies,
                                ModelMap model) {

        Player player = getLoggedInUser();

        if (playerService.sellVillagers(player, workers, farmers, spies)) {
            return "redirect:villagers";
        } else {
            model.put("errorMessage", "Insufficient villagers. Please try again.");
            model.put("player", player);

            return "villagers";
        }
    }

    @RequestMapping(value = "soldiers", method = RequestMethod.GET)
    public String soldiersPage(ModelMap model) {

        Player player = getLoggedInUser();
        model.put("player", player);

        return "soldiers";
    }

    @RequestMapping(value = "hireApprentice", method = RequestMethod.POST)
    public String hireApprentice(@RequestParam int apprenticeWarriors, ModelMap model) {

        Player player = getLoggedInUser();
        model.put("player", player);

        if(playerService.hireApprentice(player, apprenticeWarriors)) {
            return "redirect:soldiers";
        } else {
            model.put("errorMessage", "Insufficient food. Please try again.");
            model.put("player", player);

            return "soldiers";
        }
    }

    @RequestMapping(value = "trainApprentice", method = RequestMethod.POST)
    public String trainApprentice(@RequestParam long[] attackers, @RequestParam long[] defenders, ModelMap model) {

        Player player = getLoggedInUser();
        model.put("player", player);

        if(playerService.trainApprentice(player, attackers, defenders)) {
            return "redirect:soldiers";
        } else {
            model.put("errorMessage", "Insufficient food. Please try again.");
            model.put("player", player);

            return "soldiers";
        }
    }

    @RequestMapping(value = "weapons", method = RequestMethod.GET)
    public String weaponsPage(ModelMap model) {

        Player player = getLoggedInUser();
        model.put("player", player);

        return "weapons";
    }

    @RequestMapping(value = "buyWeapons", method = RequestMethod.POST)
    public String buyWeapons(@RequestParam long[] attackWeapons, @RequestParam long[] defenseWeapons, ModelMap model) {

        Player player = getLoggedInUser();
        model.put("player", player);

        if(playerService.buyWeapons(player, attackWeapons, defenseWeapons)) {
            return "redirect:weapons";
        } else {
            model.put("errorMessage", "Insufficient gold. Please try again.");
            model.put("player", player);

            return "weapons";
        }
    }

    @RequestMapping(value = "sellWeapons", method = RequestMethod.POST)
    public String sellWeapons(@RequestParam long[] attackWeapons, @RequestParam long[] defenseWeapons, ModelMap model) {

        Player player = getLoggedInUser();
        model.put("player", player);

        if(playerService.sellWeapons(player, attackWeapons, defenseWeapons)) {
            return "redirect:weapons";
        } else {
            model.put("errorMessage", "Insufficient weapons. Please try again.");
            model.put("player", player);

            return "weapons";
        }
    }

    @RequestMapping(value = "upgrades", method = RequestMethod.GET)
    public String upgradesPage(ModelMap model) {

        Player player = getLoggedInUser();
        model.put("player", player);

        return "upgrades";
    }

    @RequestMapping(value = "upgrades", method = RequestMethod.POST)
    public String buyUpgrade(@RequestParam String upgradeValue, ModelMap model) {

        Player player = getLoggedInUser();
        model.put("player", player);

        if (playerService.buyUpgrade(player, upgradeValue)) {
            return "redirect:upgrades";
        } else {
            model.put("errorMessage", "Insufficient Gold. Please try again.");
            model.put("player", player);

            return "upgrades";
        }
    }

    @RequestMapping(value = "science", method = RequestMethod.GET)
    public String sciencePage(ModelMap model) {

        Player player = getLoggedInUser();
        model.put("player", player);

        return "science";
    }

    @RequestMapping(value = "research", method = RequestMethod.POST)
    public String buyScience(@RequestParam String researchValue, ModelMap model) {

        Player player = getLoggedInUser();
        model.put("player", player);

        if (playerService.buyScience(player, researchValue)) {
            return "redirect:science";
        } else {
            model.put("errorMessage", "Insufficient Gold. Please try again.");
            model.put("player", player);

            return "science";
        }
    }

    @RequestMapping(value = "rankings", method = RequestMethod.GET)
    public String playerRankings(ModelMap model) {

        Player player = getLoggedInUser();
        model.put("player", player);

        List<Player> playerList = playerService.getPlayers();
        model.put("playerList", playerList);

        return "rankings";
    }

    @RequestMapping(value = "stats/{username}", method = RequestMethod.GET)
    public String opponentStats(@PathVariable String username, ModelMap model) {

        Player player = getLoggedInUser();
        model.put("player", player);

        Player opponent = playerService.findByUsername(username).get(0);
        model.put("opponent", opponent);

        return "stats";
    }

    @RequestMapping(value = "battle", method = RequestMethod.POST)
    public String battleOpponent(@RequestParam String opponentUsername, @RequestParam int battleTurns, ModelMap model) {

        Player player = getLoggedInUser();
        model.put("player", player);

        Player opponent = playerService.findByUsername(opponentUsername).get(0);
        model.put("opponent", opponent);


        if (playerService.battleOpponents(player, opponentUsername, battleTurns)) {
            return "battle";
        } else {
            model.put("errorMessage", "Insufficient turns. Please try again.");
            model.put("player", player);

            return "redirect:stats";
        }
    }

    @RequestMapping(value = "spy", method = RequestMethod.POST)
    public String spyOnPlayer(@RequestParam String opponentUsername, ModelMap model) {

        Player player = getLoggedInUser();
        model.put("player", player);

        Player opponent = playerService.findByUsername(opponentUsername).get(0);
        model.put("opponent", opponent);

        playerService.spyOnOpponents(player, opponentUsername);

        return "spy";
    }

    private Player getLoggedInUser() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();
        List<Player> playerList = playerService.findByUsername(username);

        return playerList.get(0);
    }
}
