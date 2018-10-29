package org.webshop.springmvcsecurity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.webshop.springmvcsecurity.model.UserInfo;

public class UserInfoMapper implements RowMapper<UserInfo> {

	@Override
    public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
 
        String userName = rs.getString("username");
        String password = rs.getString("password");
 
        return new UserInfo(userName, password);
    }
}
