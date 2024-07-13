package com.trickylime.springboot.mykingdom.account;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "loginpage";
    }

    @RequestMapping(value = "createAccount", method = RequestMethod.POST)
    public String createAccount(@RequestParam("email") String email, @RequestParam("username") String username,
            @RequestParam("password") String password, ModelMap model) {

        try {
            accountService.createAccount(email, username, password);
            return "success";
        } catch (IllegalArgumentException e) {
            String message = e.getMessage();
            if (message.contains("Email")) {
                model.addAttribute("errorMessageEmail", message);
            } else if (message.contains("Username")) {
                model.addAttribute("errorMessageUsername", message);
            } else if (message.contains("Password")) {
                model.addAttribute("errorMessagePassword", message);
            }
            return "redirect:loginpage";
        }
    }

}
