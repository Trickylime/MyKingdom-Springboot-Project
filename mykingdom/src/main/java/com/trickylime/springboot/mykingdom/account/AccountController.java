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
    public String createAccount(@RequestParam String email, @RequestParam String username, @RequestParam String password,
                                ModelMap model) {

        AccountService.ValidAccountResult result = accountService.createAccount(email, username, password);
        switch (result) {
            case INVALID_EMAIL_CHARACTERS -> {
                return "redirect:main";
            }
            case INVALID_USERNAME_CHARACTERS -> {
                return "redirect:main";
            }
            case INVALID_EMAIL_IN_USE -> {
                return "redirect:main";
            }
            case INVALID_USERNAME_IN_USE -> {
                return "redirect:main";
            }
        }

        return "redirect:loginpage";
    }

}
