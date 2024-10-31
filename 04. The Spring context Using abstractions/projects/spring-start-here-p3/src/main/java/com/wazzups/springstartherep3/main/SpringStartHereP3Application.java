package com.wazzups.springstartherep3.main;

import com.wazzups.springstartherep3.main.services.CommentService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringStartHereP3Application {

    public static void main(String[] args) {
//        DBCommentRepository repo = new DBCommentRepository();
//        EmailCommentNotificationProxy proxy = new EmailCommentNotificationProxy();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringStartHereP3Application.class);

        Comment comment = new Comment();
        comment.setAuthor("Rui");
        comment.setText("Carlos vai comer");

        CommentService commentService = context.getBean(CommentService.class);

        commentService.publishComment(comment);


    }

}
