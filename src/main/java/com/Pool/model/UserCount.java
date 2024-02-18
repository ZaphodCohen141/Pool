package com.Pool.model;

public class UserCount {
    private Integer qId;
    private Integer userCount;

    public UserCount(Integer qId, Integer userCount) {
        this.qId = qId;
        this.userCount = userCount;
    }

    public UserCount() {
    }

    public Integer getqId() {
        return qId;
    }

    public void setqId(Integer qId) {
        this.qId = qId;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }
}
