package com.Pool.model;

import com.Pool.UserMicroService.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReplyRequest {
    @JsonProperty("user")
    private User user;
    @JsonProperty("reply")
    private Reply reply;

    public ReplyRequest(User user, Reply question) {
        this.user = user;
        this.reply = question;
    }

    public ReplyRequest() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }
}
