package com.trickylime.springboot.mykingdom.game.player;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PlayerController {

    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping("main")
    public String ListPlayerStats(ModelMap model) {

        String username = getLoggedInUsername(model);
        List<Player> player = playerService.findByUsername(username);

        model.put("gold", player.get(0).getGold());
        model.put("food", player.get(0).getFood());
        model.put("battleturns", player.get(0).getBattleTurns());

        model.put("attack", player.get(0).getAttack());
        model.put("defense", player.get(0).getDefense());
        model.put("spy", player.get(0).getSpy());

       return "main";
    }

    @RequestMapping(value = "villagers", method = RequestMethod.GET)
    public String listCurrentVillagers(ModelMap model) {

        String username = getLoggedInUsername(model);
        List<Player> playerList = playerService.findByUsername(username);
        Player player = playerList.get(0);

        model.put("food", player.getFood());

        model.put("workers", player.getWorkers());
        model.put("farmers", player.getFarmers());
        model.put("spies", player.getSpies());

        model.addAttribute("supplyForm", new VillagerSupplyForm());

        return "villagers";
    }

    @RequestMapping(value = "villagers", method = RequestMethod.POST)
    public String addVillagers(@ModelAttribute VillagerSupplyForm supplyForm, ModelMap model) {

        String username = getLoggedInUsername(model);
        List<Player> playerList = playerService.findByUsername(username);
        Player player = playerList.get(0);

        playerService.addVillagers(player, supplyForm.getWorkers(), supplyForm.getFarmers(), supplyForm.getSpies());

        return "redirect:villagers";
    }

    private String getLoggedInUsername(ModelMap model) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
