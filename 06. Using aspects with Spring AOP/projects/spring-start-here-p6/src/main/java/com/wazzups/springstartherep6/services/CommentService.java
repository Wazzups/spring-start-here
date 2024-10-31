package com.wazzups.springstartherep6.services;

import com.wazzups.springstartherep6.Comment;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private Logger log = Logger.getLogger(this.getClass().getName());

    public String publishComment(Comment comment) {
        log.info("Publishing comment " + comment);
        return "SUCCESS";
    }
}
