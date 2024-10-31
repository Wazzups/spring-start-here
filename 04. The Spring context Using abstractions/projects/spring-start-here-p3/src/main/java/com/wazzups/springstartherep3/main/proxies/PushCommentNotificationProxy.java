package com.wazzups.springstartherep3.main.proxies;

import com.wazzups.springstartherep3.main.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("PUSH")
public class PushCommentNotificationProxy implements CommentNotificationProxy{
    @Override
    public void sendCommentNotification(Comment comment) {
        System.out.println("Pushing comment notification");
    }
}
