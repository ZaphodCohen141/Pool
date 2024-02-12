package com.Pool.repository;

import com.Pool.model.Question;
import com.Pool.model.ReplyRequest;
import com.Pool.model.ReplyResponse;

public interface PoolRepository {
    public Integer createQuestion(Question question);
    public Question getQuestionById(Integer qId);
    public String updateQuestionById(Integer qId, Question question);
    public String deleteQuestionById(Integer qId);
    void createReply(ReplyRequest replyRequest);

    void deleteReply(ReplyRequest replyRequest);

    Integer getHowManyUserChooseQuestion(Integer qId);
    Integer getHowManyUserAnswer(Integer qid);
    ReplyResponse getAllUserResponse(Integer uId);
    ReplyResponse getAllUserQuestion(Integer uId);
}
