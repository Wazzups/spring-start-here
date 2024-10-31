package com.wazzups.springstartherep4;

import com.wazzups.springstartherep4.config.ProjectConfig;
import com.wazzups.springstartherep4.service.CommentService;
import com.wazzups.springstartherep4.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringStartHereP4Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

//        CommentService commentService1 = context.getBean("commentService1", CommentService.class);
//        CommentService commentService2 = context.getBean("commentService1", CommentService.class);
//
//        System.out.println(commentService1 == commentService2);

        CommentService commentService = context.getBean(CommentService.class);
        UserService userService = context.getBean(UserService.class);

        Comment comment = new Comment();
        comment.setText("My comment is the winner");
        commentService.saveComment(comment);
        userService.saveComment(comment);

        // To verify that the DI works and the repository instance inject has the same reference
        System.out.println(commentService.getCommentRepository() == userService.getCommentRepository());

        Person person = new Person();
        System.out.println(person.getSalary());
    }

}
