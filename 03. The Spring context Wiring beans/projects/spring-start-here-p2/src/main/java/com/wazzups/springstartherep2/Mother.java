package com.wazzups.springstartherep2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mother {

    private String name;

//    @Autowired
    private final Children children;

//    @Autowired
    private final House house;

//    @Autowired Not needed anymore!
    public Mother(Children children, House house) {
        this.children = children;
        this.house = house;
    }

    public Children getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // With final fields don't make sense to have setters
//    public void setChildren(Children children) {
//        this.children = children;
//    }

    public House getHouse() {
        return house;
    }

//    public void setHouse(House house) {
//        this.house = house;
//    }

    @Override
    public String toString() {
        return "Mother{" +
            "name='" + name + '\'' +
            ", children=" + children +
            ", house=" + house +
            '}';
    }
}
