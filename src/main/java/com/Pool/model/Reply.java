package com.Pool.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Reply {
    @JsonProperty("qId")
    private Integer questionId;
    @JsonProperty("uId")
    private Integer userId;
    @JsonProperty("aId")
    private String answerId;

    public Reply(Integer questionId, Integer userId, String answerId) {
        this.questionId = questionId;
        this.userId = userId;
        this.answerId = answerId;
    }
    public Reply() {
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }
}
