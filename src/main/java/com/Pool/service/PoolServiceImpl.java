package com.Pool.service;

import com.Pool.UserMicroService.User;
import com.Pool.UserMicroService.UserController;
import com.Pool.model.Question;
import com.Pool.model.Reply;
import com.Pool.model.ReplyRequest;
import com.Pool.model.ReplyResponse;
import com.Pool.repository.PoolRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoolServiceImpl implements PoolService {
    @Autowired
    private PoolRepository poolRepository;
    @Autowired
    UserController userController;
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public Integer createQuestion(Question question) {
        return poolRepository.createQuestion(question);
    }

    @Override
    public Question getQuestionById(Integer qId) {
        return poolRepository.getQuestionById(qId);
    }

    @Override
    public String updateQuestionById(Integer qId, Question question) {
        return poolRepository.updateQuestionById(qId,question);
    }

    @Override
    public String deleteQuestionById(Integer qId) {
        return poolRepository.deleteQuestionById(qId);
    }

    @Override
    public String createReply(Reply reply) throws JsonProcessingException {
//        check if user exists by user id -> get the user from the user microservice and get the userId from
//        the question table in the pool service. if pool.uId == user.uId -> create reply
//        - if not - alert
//        - if exist -> create reply.
        Integer userIdReply = reply.getUserId();
        User user = userController.getUserById(userIdReply);
        if (userIdReply == user.getUserId()){
            poolRepository.createReply(reply);
            System.out.println("ok");
        }else{
            System.out.println("not such user");
        }
        return null;
    }

    @Override
    public void deleteReply(ReplyRequest replyRequest) {

    }

    @Override
    public Integer getHowManyUserChooseQuestion(Integer qId) {
        return null;
    }

    @Override
    public Integer getHowManyUserAnswer(Integer qid) {
        return null;
    }

    @Override
    public ReplyResponse getAllUserResponse(Integer uId) {
        return null;
    }

    @Override
    public ReplyResponse getAllUserQuestion(Integer uId) {
        return null;
    }
}
