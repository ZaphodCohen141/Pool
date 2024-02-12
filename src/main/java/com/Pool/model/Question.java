package com.Pool.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Question {
    @JsonProperty("question_id")
    private Integer questionId;
    @JsonProperty("question_text")
    private String questionText;
    @JsonProperty("ans_1")
    private String answerA;
    @JsonProperty("ans_2")
    private String answerB;
    @JsonProperty("ans_3")
    private String answerC;
    @JsonProperty("ans_4")
    private String answerD;

    public Question(Integer questionId, String questionText, String answerA, String answerB, String answerC, String answerD) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
    }

    public Question() {
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }
}
