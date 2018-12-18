package org.webshop.search.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.webshop.search.model.CategoriesModel;

public class CategoriesMapper implements RowMapper<CategoriesModel> {
	
	public CategoriesModel mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		CategoriesModel categories = new CategoriesModel();
		categories.setCategoriesId(rs.getInt("modell_type_id"));
		categories.setCategoriesName(rs.getString("modell_type_name"));
		
		return categories;
	}
	

}
