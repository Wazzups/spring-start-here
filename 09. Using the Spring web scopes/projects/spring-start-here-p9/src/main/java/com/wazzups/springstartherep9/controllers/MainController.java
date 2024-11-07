package com.wazzups.springstartherep9.controllers;

import com.wazzups.springstartherep9.services.LoggedUserManagementService;
import com.wazzups.springstartherep9.services.LoginCountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;


    MainController(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    @GetMapping("/main")
    public String home(Model model, @RequestParam(required = false) String logout) {
        if (logout != null) {
            loggedUserManagementService.setUsername(null);
        }

        int count = loginCountService.getLoginCount();
        String username = loggedUserManagementService.getUsername();
        if (username == null) {
            return "redirect:/";
        }

        model.addAttribute("username", username);
        model.addAttribute("count", count);

        return "main.html";
    }
}
