package com.wazzups.springstartherep4;

import org.springframework.stereotype.Service;

@Service
public class CommentService2 {

    public void sendComment(Comment comment) {
        CommentProcessor commentProcessor = new CommentProcessor();

        commentProcessor.setComment(comment);
        commentProcessor.validateComment(comment);
        commentProcessor.processComment(comment);
    }
}
