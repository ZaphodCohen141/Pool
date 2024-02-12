package com.Pool.service;

import com.Pool.UserMicroService.User;
import com.Pool.UserMicroService.UserService;
import com.Pool.model.Question;
import com.Pool.model.ReplyRequest;
import com.Pool.model.ReplyResponse;
import com.Pool.repository.PoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoolServiceImpl implements PoolService {
    @Autowired
    private PoolRepository poolRepository;

    @Autowired
    UserService userService;
    @Override
    public Integer createQuestion(Question question) {
        return null;
    }

    @Override
    public Question getQuestionById(Integer qId) {
        return null;
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
    public String createReply(ReplyRequest replyRequest) {
//        check if user exists by user id -> get the user from the user microservice and get the userId from
//        the question table in the pool service. if pool.uId == user.uId -> create reply
//        - if not - alert
//        - if exist -> create reply.
        User userFromReply = replyRequest.getUser();
        Integer userIdFromReply = userFromReply.getUserId();
        User userFromUsers = userService.getUser(userIdFromReply);
        Integer userIdFromUsers = userFromUsers.getUserId();
        if (userIdFromUsers == userIdFromReply){
            System.out.println("it's ok");
            return "the user exists";
        }else {
            System.out.println("we gor problem");
            return "no such users";
        }
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
