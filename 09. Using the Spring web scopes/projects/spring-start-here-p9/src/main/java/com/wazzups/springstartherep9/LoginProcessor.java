package com.wazzups.springstartherep9;

import com.wazzups.springstartherep9.services.LoggedUserManagementService;
import com.wazzups.springstartherep9.services.LoginCountService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
    private String username;
    private String password;

    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    public LoginProcessor(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    public boolean login() {
        boolean loggedIn = false;
        loginCountService.addLoginCount();

        if ("natalie".equals(this.username) && "password".equals(this.password)) {
            loggedIn = true;
            loggedUserManagementService.setUsername(this.username);
        }

        return loggedIn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
