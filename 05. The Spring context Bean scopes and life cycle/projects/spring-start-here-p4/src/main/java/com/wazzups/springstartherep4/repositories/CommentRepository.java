package com.wazzups.springstartherep4.repositories;

import com.wazzups.springstartherep4.Comment;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentRepository {

    public void save(Comment comment) {
        System.out.println("Comment persisted: " + comment);
    }
}
