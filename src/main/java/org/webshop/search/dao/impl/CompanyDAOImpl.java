package org.webshop.search.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.webshop.search.dao.CompanyDAO;
import org.webshop.search.model.Company;


public class CompanyDAOImpl extends JdbcDaoSupport implements CompanyDAO {
	
	@Autowired
	public CompanyDAOImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	
	public List<Company> list() {
		
		String sql = "SELECT * FROM companys";
		List<Company> listCompanys = this.getJdbcTemplate().query(sql, new RowMapper<Company>() {
			
			@Override
			public  Company mapRow(ResultSet rs, int rowNum) throws SQLException {
				Company aCompany = new Company();
				
				aCompany.setCompanyId(rs.getString("company_id"));
				aCompany.setCompanyName(rs.getString("company_name"));
				
				return aCompany;
				}
			
			});
			return listCompanys;
	}
	

}
