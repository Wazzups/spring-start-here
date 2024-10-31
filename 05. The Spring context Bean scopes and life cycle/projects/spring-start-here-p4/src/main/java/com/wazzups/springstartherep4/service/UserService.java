package com.wazzups.springstartherep4.service;

import com.wazzups.springstartherep4.Comment;
import com.wazzups.springstartherep4.repositories.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public final CommentRepository commentRepository;

    public UserService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    public CommentRepository getCommentRepository() {
        return commentRepository;
    }
}
