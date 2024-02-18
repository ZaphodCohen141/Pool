package com.Pool.repository;

import com.Pool.model.Question;
import com.Pool.model.Reply;
import com.Pool.model.UserCount;

import java.util.ArrayList;
import java.util.List;

public interface PoolRepository {
    public Integer createQuestion(Question question);
    public Question getQuestionById(Integer qId);
    public String updateQuestionById(Integer qId, Question question);
    public String deleteQuestionById(Integer qId);
    void createReply(Reply reply);

    void deleteReply(Integer uId);

    ArrayList<String> getHowManyUserChooseQuestion(Integer qId);
    Integer getHowManyUserChooseEachAnswer(Integer qid);
    ArrayList<String> getAllUserResponses(Integer uId);
    Integer getTotalNumberOfQuestionsForUser(Integer uId);
    List<UserCount> getAllQuestionWithUserCount();
}
