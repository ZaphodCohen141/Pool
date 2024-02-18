package com.Pool.service;

import com.Pool.model.Question;
import com.Pool.model.Reply;
import com.Pool.model.UserCount;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.List;

public interface PoolService {
    public Integer createQuestion(Question question);
    public Question getQuestionById(Integer qId);
    public String updateQuestionById(Integer qId, Question question);
    public String deleteQuestionById(Integer qId);
    String createReply(Reply reply) throws JsonProcessingException;

    void deleteReply(Integer uId);

    ArrayList<String> getHowManyUserChooseEachAnswer(Integer qId);
    Integer getHowManyUserAnswerToQuestion(Integer qid);
    List<String> getAllUserResponse(Integer uId);
    Integer getTotalNumberOfQuestionsForUser(Integer uId);
    List<UserCount> getAllQuestionWithUserCount();
}
