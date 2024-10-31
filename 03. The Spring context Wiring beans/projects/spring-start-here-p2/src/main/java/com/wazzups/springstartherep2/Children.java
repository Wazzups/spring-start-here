package com.wazzups.springstartherep2;

import org.springframework.stereotype.Component;

@Component
public class Children {
    private String name = "Roberta";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Children{" +
            "name='" + name + '\'' +
            '}';
    }
}
