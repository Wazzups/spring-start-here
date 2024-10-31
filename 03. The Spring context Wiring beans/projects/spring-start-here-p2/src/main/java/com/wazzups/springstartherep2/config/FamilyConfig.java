package com.wazzups.springstartherep2.config;

import com.wazzups.springstartherep2.Children;
import com.wazzups.springstartherep2.House;
import com.wazzups.springstartherep2.Mother;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.wazzups")
public class FamilyConfig {


    /*
    @Bean
    Mother mother(Children children, House house) {
        Mother mother = new Mother();
        mother.setName("Mafalda");
        mother.setChildren(children);
        mother.setHouse(house);
        return mother;
    }
     */


}
