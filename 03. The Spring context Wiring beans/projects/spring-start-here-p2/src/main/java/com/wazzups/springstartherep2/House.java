package com.wazzups.springstartherep2;

import org.springframework.stereotype.Component;

@Component
public class House {

    private String address = "Rua das Eiras";

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "House{" +
            "address='" + address + '\'' +
            '}';
    }
}
