package com.wazzups.springstartherep3.main.services;

import com.wazzups.springstartherep3.main.Comment;
import com.wazzups.springstartherep3.main.proxies.CommentNotificationProxy;
import com.wazzups.springstartherep3.main.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    public CommentService(CommentRepository commentRepository, @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendCommentNotification(comment);
    }
}