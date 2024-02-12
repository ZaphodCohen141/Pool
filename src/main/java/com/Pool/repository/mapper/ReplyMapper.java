package com.Pool.repository.mapper;

import com.Pool.model.Reply;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReplyMapper implements RowMapper<Reply> {

    @Override
    public Reply mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Reply(
                rs.getInt("user_id"),
                rs.getInt("question_id"),
                rs.getInt("answer_id")
        );
    }
}
