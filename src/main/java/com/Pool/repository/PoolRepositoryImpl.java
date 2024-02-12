package com.Pool.repository;

import com.Pool.model.Question;
import com.Pool.model.ReplyRequest;
import com.Pool.model.ReplyResponse;
import com.Pool.model.Util;
import com.Pool.repository.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.ArrayList;

@Repository
public class PoolRepositoryImpl implements PoolRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Integer createQuestion(Question question) {
        String sql = "INSERT INTO " + Util.QUESTION_TABLE + " (question_text, ans_1, ans_2, " +
                "ans_3, ans_4) VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql,question.getQuestionText(),question.getAnswerA(),
                            question.getAnswerB(),question.getAnswerC(),question.getAnswerD());
        sql = "SELECT MAX(question_id) FROM " + Util.QUESTION_TABLE;
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public Question getQuestionById(Integer qId) {
        String sql = "SELECT * FROM " + Util.QUESTION_TABLE + " WHERE question_id = ?";
        Question question = jdbcTemplate.queryForObject(sql,new QuestionMapper(),qId);
        if (question!=null){
            return question;
        }else {
            System.out.println("not such question id");
            return null;
        }
    }

    @Override
    public String updateQuestionById(Integer qId, Question question) {
        String sql = "UPDATE " + Util.QUESTION_TABLE + " SET" + StringUserNotNullVar(question) + "WHERE question_id = ?";
        Integer update = jdbcTemplate.update(sql,qId);
        System.out.println(sql);
        if (update == 1){
            return "question " + qId + " was updated";
        }else {
            return "no such question";
        }
    }

    @Override
    public String deleteQuestionById(Integer qId) {
        String sql = "DELETE FROM " + Util.QUESTION_TABLE + " WHERE question_id = ?";
        Integer delete = jdbcTemplate.update(sql,qId);
        if (delete == 1){
            return "question " + qId +" got deleted";
        }else {
            return "no such question";
        }
    }

    @Override
    public void createReply(ReplyRequest replyRequest) {

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


    // HELPER METHOD to create string for long objects and ignore null values
    public String StringUserNotNullVar(Question question) {
        // Loop through the object and get the values of its variables
        Field[] fields = question.getClass().getDeclaredFields();
        String[] dbNames = {"question_id","question_text", "ans_1", "ans_2", "ans_3", "ans_4"};
        ArrayList<String> values = new ArrayList<>();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(question);
                if (value!=null) {
                    values.add(value.toString());
                }else {
                    values.add("null");
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        String valuesAsArray[] = new String[dbNames.length];
        valuesAsArray = values.toArray(valuesAsArray);
        ArrayList<String> concateDbValues = new ArrayList<>();
        for (int i = 0; i < dbNames.length; i++) {
            if (i == 0) {
                concateDbValues.add("SET " + dbNames[i] + " = '" + valuesAsArray[i] +"'");
            }else {
                concateDbValues.add(dbNames[i] + " = '" + valuesAsArray[i]+"'");
            }
        }
//    remove null values;
        for (int i = 0; i < concateDbValues.size(); i++) {
            if (concateDbValues.get(i).contains("null")){
                concateDbValues.remove(i);
            }
        }
        String fin = " ";
        for (int i = 0; i < concateDbValues.size(); i++) {
            if(i == concateDbValues.size()-1){
                fin = fin + concateDbValues.get(i) + " ";
            }else {
                fin = fin + concateDbValues.get(i) + ", ";
            }
        }
        return fin;
    }

}
