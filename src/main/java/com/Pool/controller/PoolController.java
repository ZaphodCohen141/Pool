package com.Pool.controller;

import com.Pool.model.Question;
import com.Pool.model.Reply;
import com.Pool.model.UserCount;
import com.Pool.service.PoolService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pool")
public class PoolController {
    @Autowired
    private PoolService poolService;
    @Autowired
    ObjectMapper objectMapper;

    @PostMapping(value = "/create_question")
    public Integer createQuestion(@RequestBody Question question){
        return poolService.createQuestion(question);
    }
    @GetMapping(value = "/get_question")
    public Question getQuestionById(@RequestParam Integer qId){
        System.out.println(qId);
     return poolService.getQuestionById(qId);
    }
    @PostMapping(value = "/update_question")
    public void updateQuestionById(@RequestParam Integer qId,@RequestBody Question question){
        poolService.updateQuestionById(qId,question);
    }

    @DeleteMapping(value = "/delete_question")
    public void deleteQuestionById(@RequestParam Integer qId){
        poolService.deleteQuestionById(qId);
    }

    @PostMapping(value = "/create_reply")
    public String createReply(@RequestBody Reply reply) throws JsonProcessingException {
        return poolService.createReply(reply);
    }

    @DeleteMapping(value = "/delete_reply")
    public void deleteReply(@RequestParam Integer uId){
        poolService.deleteReply(uId);
    }

//    Return how many users choose each of the question options
    @GetMapping(value = "/count_u_to_each_ans_of_q")
    public ArrayList<String> getHowManyUserChooseQuestion(@RequestParam Integer qId){
       return poolService.getHowManyUserChooseEachAnswer(qId);
    }

//    Return how many users answer to this question in total
    @GetMapping(value = "/count_total_u_choose_this_q")
    public Integer getHowManyUserChooseEachAnswer(@RequestParam Integer qId){
        System.out.println("in total, " + poolService.getHowManyUserAnswerToQuestion(qId) +
                "answer this question");
        return poolService.getHowManyUserAnswerToQuestion(qId);
    }

//    Return how many questions this user answered to
    @GetMapping(value = "/user_ans_to_q")
    public List<String> getAllUserResponse(@RequestParam Integer uId){
        return poolService.getAllUserResponse(uId);
    }

    @GetMapping(value = "/total_questions_per_user")
    public Integer getTotalNumberOfQuestionsForUser(@RequestParam Integer uId){
        return poolService.getTotalNumberOfQuestionsForUser(uId);
    }

    @GetMapping(value = "/get_all_q_with_u_count")
    public List<UserCount> getAllQuestionWithUserCount(){
        return poolService.getAllQuestionWithUserCount();
    }
}
