package com.wazzups.springstartherep2;

public class Parrot {
    public Parrot(){
        System.out.println("Parrot created");
    }

    public Parrot(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Parrot{" +
            "name='" + name + '\'' +
            '}';
    }
}
