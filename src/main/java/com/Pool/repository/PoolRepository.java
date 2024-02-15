package com.Pool.repository;

import com.Pool.model.Question;
import com.Pool.model.Reply;
import com.Pool.model.ReplyResponse;

import java.util.ArrayList;

public interface PoolRepository {
    public Integer createQuestion(Question question);
    public Question getQuestionById(Integer qId);
    public String updateQuestionById(Integer qId, Question question);
    public String deleteQuestionById(Integer qId);
    void createReply(Reply reply);

    void deleteReply(Integer uId);

    ArrayList<String> getHowManyUserChooseQuestion(Integer qId);
    Integer getHowManyUserAnswer(Integer qid);
    ArrayList<String> getAllUserResponse(Integer uId);
    ReplyResponse getAllUserQuestion(Integer uId);
}
