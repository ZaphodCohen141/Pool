package com.Pool.repository;

import com.Pool.model.*;
import com.Pool.repository.mapper.QuestionMapper;
import com.Pool.repository.mapper.ResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

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
    public void createReply(Reply reply) {
        String sql = "INSERT INTO " + Util.REPLY_TABLE + " (question_id, user_id, answer_id) VALUES(?,?,?)";
        jdbcTemplate.update(sql,reply.getQuestionId(),reply.getUserId(),reply.getAnswerId());
    }

    @Override
    public void deleteReply(Integer uId) {
        String sql = "DELETE FROM " + Util.REPLY_TABLE + " WHERE user_id = ?";
        jdbcTemplate.update(sql,uId);
    }

//    Return how many users choose each of the question options (answers)
    @Override
    public ArrayList<String> getHowManyUserChooseQuestion(Integer qId) {
        String sql = "SELECT COUNT(user_id) FROM " + Util.REPLY_TABLE +
                " WHERE question_id = ? AND answer_id = ";
        String tempsql;
        ArrayList<String> countUsersForAnswer = new ArrayList<>();
        for (int i = 1; i < Util.ANSWER_OPTIONS+1; i++) {
            tempsql = sql + i;
            countUsersForAnswer.add(jdbcTemplate.queryForObject(tempsql,Integer.class,qId) + " user choose answer " + i +
                                        " of question " + qId);
        }

        return countUsersForAnswer;
    }
//    Return how many users answer to this question in total
    @Override
    public Integer getHowManyUserAnswer(Integer qid) {
        String sql = "SELECT COUNT(user_id) FROM " + Util.REPLY_TABLE + " WHERE question_id = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class,qid);
    }

//   Return the user answer to each question he submitted
//SELECT Questions.QUESTION_ID, questions.question_text,questions.ans_1,replies.user_id
////    FROM questions
////    INNER JOIN replies on Questions.QUESTION_ID = replies.question_id
////    where user_id=1
    @Override
    public ArrayList<String> getAllUserResponse(Integer uId) {
        String sql = "SELECT " + Util.QUESTION_TABLE +".question_id, " + Util.QUESTION_TABLE + ".question_text, " +
        Util.REPLY_TABLE +".answer_id, " + Util.REPLY_TABLE + ".user_id\n" +
                "    FROM questions\n" +
                "    INNER JOIN replies on " + Util.QUESTION_TABLE + ".question_id = replies.question_id\n " +
                "    WHERE user_id = ? ";
        ArrayList<String> butifyResponse = new ArrayList<>();
        String butify;
        List<ReplyResponse> allReplies = jdbcTemplate.query(sql,new ResponseMapper(), uId);
        for (int i = 0; i < allReplies.size(); i++) {
            sql = "SELECT (ans_" + allReplies.get(i).getAnsId() + ") FROM " +
                    Util.QUESTION_TABLE + " WHERE question_id = " + allReplies.get(i).getqId();
            butify = "user " + uId + " choose answer " + jdbcTemplate.queryForObject(sql,String.class) +
                    ", for question " + allReplies.get(i).getqId() + ": " + allReplies.get(i).getqText();
            butifyResponse.add(i,butify);
        }

        return butifyResponse;
    }

    @Override
    public ReplyResponse getAllUserQuestion(Integer uId) {
        return null;
    }












    // HELPER METHOD
    //  StringUserNotNullVar - create sql string for long objects and ignore null values
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
