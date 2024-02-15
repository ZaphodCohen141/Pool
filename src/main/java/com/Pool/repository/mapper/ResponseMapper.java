package com.Pool.repository.mapper;

import com.Pool.model.ReplyResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResponseMapper implements RowMapper<ReplyResponse> {
    @Override
    public ReplyResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ReplyResponse(
                rs.getInt("user_id"),
                rs.getInt("answer_id"),
                rs.getInt("question_id"),
                rs.getString("question_text")
        );
    }
}
