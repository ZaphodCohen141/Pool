package com.Pool.controller;

import com.Pool.model.Question;
import com.Pool.model.Reply;
import com.Pool.service.PoolService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void createReply(@RequestBody Reply reply) throws JsonProcessingException {
        poolService.createReply(reply);
    }

}
