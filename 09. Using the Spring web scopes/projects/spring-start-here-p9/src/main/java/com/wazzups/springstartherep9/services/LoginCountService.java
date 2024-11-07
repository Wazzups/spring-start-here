package com.wazzups.springstartherep9.services;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class LoginCountService {

    private int loginCount = 0;

    public int getLoginCount() {
        return loginCount;
    }

    public void addLoginCount() {
        this.loginCount++;
    }
}
