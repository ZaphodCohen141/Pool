package com.Pool.repository.mapper;

import com.Pool.model.UserCount;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserCountMapper implements RowMapper<UserCount> {

    @Override
    public UserCount mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserCount(
                rs.getInt("question_id"),
                rs.getInt("user_id")
        );
    }
}
