package com.trickylime.springboot.mykingdom.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("loginpage")
    public String customLogin() {
        return "loginpage"; // Ensure this matches the view name of your JSP
    }
}
