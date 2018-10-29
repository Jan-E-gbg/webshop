package org.webshop.search.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.webshop.search.dao.DisplayScreenSizeDAO;
import org.webshop.search.model.ScreenSize;

public class DisplayScreenSizeDAOImpl extends JdbcDaoSupport implements DisplayScreenSizeDAO  {

	
	@Autowired
	public DisplayScreenSizeDAOImpl(DataSource dataSource){
		this.setDataSource(dataSource);
	}
	
	
	
	@Override
	public List<ScreenSize> getListOfSize() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM modell_sizes";
		List<ScreenSize> listScreenSize = this.getJdbcTemplate().query(sql, new RowMapper<ScreenSize>() {
		
			@Override
			public  ScreenSize mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				ScreenSize screenSize = new ScreenSize();
				screenSize.setScreenSizeId(rs.getString("modell_size_id"));
				screenSize.setScreenSizeName(rs.getString("modell_size_name"));
			
				return screenSize;
			}
			});
			
			
			return listScreenSize;
	}

}

