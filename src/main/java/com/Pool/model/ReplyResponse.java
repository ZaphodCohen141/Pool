package com.Pool.model;

public class ReplyResponse {
    private Integer uId;
    private Integer ansId;
    private Integer qId;
    private String qText;

    public ReplyResponse(Integer uId, Integer ansId, Integer qId, String qText) {
        this.uId = uId;
        this.ansId = ansId;
        this.qId = qId;
        this.qText = qText;
    }

    public ReplyResponse() {
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getAnsId() {
        return ansId;
    }

    public void setAnsId(Integer ansId) {
        this.ansId = ansId;
    }

    public Integer getqId() {
        return qId;
    }

    public void setqId(Integer qId) {
        this.qId = qId;
    }

    public String getqText() {
        return qText;
    }

    public void setqText(String qText) {
        this.qText = qText;
    }
}