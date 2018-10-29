package org.webshop.search.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.webshop.search.dao.EquipmentTypeDAO;
import org.webshop.search.model.ProductName;
import org.webshop.search.model.ScreenSize;

public class EquipmentTypeDAOImpl extends JdbcDaoSupport implements EquipmentTypeDAO{

	@Autowired
	public EquipmentTypeDAOImpl(DataSource dataSource){
		this.setDataSource(dataSource);	}
	
	
	@Override
	public List<ProductName> getListOfType() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM modell_types";
		List <ProductName> equipmentType = this.getJdbcTemplate().query(sql, new RowMapper<ProductName>() {
			
			@Override
			public ProductName mapRow(ResultSet rs, int rowNum) throws SQLException {
			
				ProductName equipmentTypeList = new ProductName(); 
				equipmentTypeList.setTypeId(rs.getString("modell_type_id"));
				equipmentTypeList.setTypeName(rs.getString("modell_type_name"));
				return equipmentTypeList;
			}
			
			});
			return equipmentType;
	
	}
}
