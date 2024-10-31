package com.wazzups.springstartherep6;

import com.wazzups.springstartherep6.services.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringStartHereP6Application {

    public static void main(String[] args) {
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        ApplicationContext context = SpringApplication.run(SpringStartHereP6Application.class, args);

        CommentService commentService = context.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setAuthor("Natasha");
        comment.setText("Demo comment");

        commentService.publishComment(comment);
    }

}
