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

        String username = getLoggedInUsername(model);
        List<Player> playerList = playerService.findByUsername(username);
        Player player = playerList.get(0);

        model.put("player", player);

        return "main";
    }

    @RequestMapping(value = "villagers", method = RequestMethod.GET)
    public String listCurrentVillagers(ModelMap model) {

        String username = getLoggedInUsername(model);
        List<Player> playerList = playerService.findByUsername(username);
        Player player = playerList.get(0);

        model.put("player", player);


        return "villagers";
    }

    @RequestMapping(value = "villagers", method = RequestMethod.POST)
    public String addVillagers(@RequestParam int workers, @RequestParam int farmers,
                               @RequestParam int spies, ModelMap model) {

        String username = getLoggedInUsername(model);
        List<Player> playerList = playerService.findByUsername(username);
        Player player = playerList.get(0);

        playerService.addVillagers(player, workers, farmers, spies);

        return "redirect:villagers";
    }

    private String getLoggedInUsername(ModelMap model) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
