package com.Pool.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Reply {
    @JsonProperty("u_id")
    private Integer userId;
    @JsonProperty("q_id")
    private Integer questionId;
    @JsonProperty("a_id")
    private Integer answerId;

    public Reply(Integer userId, Integer questionId, Integer answerId) {
        this.userId = userId;
        this.questionId = questionId;
        this.answerId = answerId;
    }

    public Reply() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }
}
