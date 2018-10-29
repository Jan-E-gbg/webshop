package org.webshop.springmvcsecurity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.webshop.springmvcsecurity.model.Customber;

public class CustomberRowMapper implements RowMapper<Customber> {


	public Customber mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Customber customber = new Customber();
		customber.setWorktableName(rs.getString("worktable"));
		customber.setCustId(rs.getInt("cust_id"));
		
		return customber;
	}

}
