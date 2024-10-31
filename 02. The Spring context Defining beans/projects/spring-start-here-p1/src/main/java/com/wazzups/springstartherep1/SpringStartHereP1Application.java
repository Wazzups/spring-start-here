package com.wazzups.springstartherep1;

import com.wazzups.springstartherep1.beans.ParrotBean;
import com.wazzups.springstartherep1.config.ParrotConfig;
import java.util.function.Supplier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringStartHereP1Application {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ParrotConfig.class);

        ParrotBean parrot = context.getBean(ParrotBean.class); // Getting a reference of a bean of type Parrot from the context

        Parrot p = new Parrot();
        p.setName("Kiki");

        Supplier<Parrot> parrotSupplier = () -> p;

        context.registerBean(Parrot.class, parrotSupplier);

        context.registerBean(Parrot.class, parrotSupplier, bc -> bc.setPrimary(true));


        System.out.println(parrot.getName());
    }

}
