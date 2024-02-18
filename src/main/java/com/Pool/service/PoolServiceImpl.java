package com.Pool.service;

import com.Pool.UserMicroService.User;
import com.Pool.UserMicroService.UserController;
import com.Pool.model.Question;
import com.Pool.model.Reply;
import com.Pool.model.UserCount;
import com.Pool.repository.PoolRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public String createReply(Reply reply) {
//        check if user exists by user id -> get the user from the user microservice and get the userId from
//        the question table in the pool service. if pool.uId == user.uId -> create reply
//        - if not - alert
//        - if exist -> create reply.
        if (checkExist(reply.getUserId())){
            poolRepository.createReply(reply);
            return "Reply was submitted";
        }else {
            return "User is not registered";
        }
    }

    @Override
    public void deleteReply(Integer uId) {
//        for user service to run with deleteUser
        if (checkExist(uId)){
            poolRepository.deleteReply(uId);
        }else {
            System.out.println("the is no user with id " + uId);
        }

    }

    @Override
    public ArrayList<String> getHowManyUserChooseEachAnswer(Integer qId) {
        return poolRepository.getHowManyUserChooseQuestion(qId);
    }

    @Override
    public Integer getHowManyUserAnswerToQuestion(Integer qid) {
        return poolRepository.getHowManyUserChooseEachAnswer(qid);
    }

    @Override
    public List<String> getAllUserResponse(Integer uId) {
        if (checkExist(uId)) {
            return poolRepository.getAllUserResponses(uId);
        }else {
            System.out.println("there is no user with id " + uId);
            return null;
        }
    }

    @Override
    public Integer getTotalNumberOfQuestionsForUser(Integer uId) {
        if (checkExist(uId)) {
            return poolRepository.getTotalNumberOfQuestionsForUser(uId);
        }else {
            System.out.println("there is no user with id " + uId);
            return null;
        }
    }

    @Override
    public List<UserCount> getAllQuestionWithUserCount() {
        return poolRepository.getAllQuestionWithUserCount();
    }


    //    HELPER METHOD
//    check if user exist
    public Boolean checkExist(Integer userId){
        try{
            User user = userController.getUserById(userId);
            return true;
        }catch(NullPointerException e){
            return false;
        }
    }
}
