package com.wazzups.springstartherep3.main.proxies;

import com.wazzups.springstartherep3.main.Comment;

public interface CommentNotificationProxy {
    void sendCommentNotification(Comment comment);
}
