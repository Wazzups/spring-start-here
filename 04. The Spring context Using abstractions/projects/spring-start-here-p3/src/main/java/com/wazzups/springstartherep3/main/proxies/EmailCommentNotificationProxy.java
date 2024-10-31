package com.wazzups.springstartherep3.main.proxies;

import com.wazzups.springstartherep3.main.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("EMAIL")
public class EmailCommentNotificationProxy implements CommentNotificationProxy{
    @Override
    public void sendCommentNotification(Comment comment) {
        System.out.println("Sending comment notification: " + comment.getText());
    }
}
