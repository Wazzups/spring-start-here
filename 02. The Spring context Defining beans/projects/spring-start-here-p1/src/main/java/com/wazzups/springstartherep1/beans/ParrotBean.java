package com.wazzups.springstartherep1.beans;

import org.springframework.stereotype.Component;

@Component
public class ParrotBean {

    private String name = "Koko";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
