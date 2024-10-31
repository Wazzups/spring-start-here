package com.wazzups.springstartherep2.main;

import com.wazzups.springstartherep2.Mother;
import com.wazzups.springstartherep2.Person;
import com.wazzups.springstartherep2.config.FamilyConfig;
import com.wazzups.springstartherep2.config.ProjectConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringStartHereP2Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FamilyConfig.class);
        Mother mother = context.getBean("mother", Mother.class);

        System.out.println(mother);
    }

}
