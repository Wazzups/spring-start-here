package com.wazzups.springstartherep2.config;

import com.wazzups.springstartherep2.Parrot;
import com.wazzups.springstartherep2.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    Parrot parrot() {
        Parrot parrot = new Parrot();
        parrot.setName("Kiki");
        return parrot;
    }

    @Bean
    Person person1() {
        Person person = new Person();
        person.setName("Moko");
        person.setParrot(parrot());
        return person;
    }

    @Bean
    Person person2(Parrot parrot) {
        Person person = new Person();
        person.setName("Miki");
        person.setParrot(parrot);
        return person;
    }

}
