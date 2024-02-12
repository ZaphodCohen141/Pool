package com.Pool.repository.mapper;

import com.Pool.model.Question;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionMapper implements RowMapper<Question> {
    @Override
    public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Question(
                rs.getInt("question_id"),
                rs.getString("question_text"),
                rs.getString("ans_1"),
                rs.getString("ans_2"),
                rs.getString("ans_3"),
                rs.getString("ans_4")
        );
    }
}
