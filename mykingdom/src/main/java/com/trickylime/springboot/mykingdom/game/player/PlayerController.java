package com.trickylime.springboot.mykingdom.game.player;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    public String trainApprentice(@RequestParam int attackerLvl1, @RequestParam int defenderLvl1,
                                  @RequestParam int attackerLvl2, @RequestParam int defenderLvl2,
                                  @RequestParam int attackerLvl3, @RequestParam int defenderLvl3, ModelMap model) {

        Player player = getLoggedInUser();
        model.put("player", player);

        if(playerService.trainApprentice(player, attackerLvl1, defenderLvl1, attackerLvl2, defenderLvl2,
                attackerLvl3, defenderLvl3)) {
            return "redirect:soldiers";
        } else {
            model.put("errorMessage", "Insufficient food. Please try again.");
            model.put("player", player);

            return "soldiers";
        }
    }



    private Player getLoggedInUser() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();
        List<Player> playerList = playerService.findByUsername(username);

        return playerList.get(0);
    }
}
