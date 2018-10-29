package org.webshop.search.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.webshop.search.dao.CollectionSearchDAO;
import org.webshop.search.model.InputSearch;
import org.webshop.search.model.OrderItem;

public class CollectionSearchImpl extends JdbcDaoSupport implements CollectionSearchDAO{

	@Autowired
	public CollectionSearchImpl (DataSource dataSource){
		this.setDataSource(dataSource);
	}
	
	@Override
	public List<OrderItem> getListOfSearch(InputSearch input) {
		// TODO Auto-generated method stub
		
	String sql = "select c.company_name ,m.ID, m.MODELL_NAME, mz.modell_size_name, m.MODELL_PRIS, m.MODELL_INFO, m.IS_VISEBLE "
			+ "from companys c, modells m , modell_sizes mz where c.company_id = m.company_id and m.modell_size_id = mz.modell_size_id";
	
	System.out.println("input.getCompanyId()  " + input.getCompanyId() );
	
	if(!input.getCompanyId().equals("*")){
		
		String companyValue = " and c.company_id = ";
		companyValue +=  input.getCompanyId();
		
		sql += companyValue;
	}
	
	if(!input.getScreenSizeId().equals("*")){
		
		String modell_sizeValue = " and m.modell_size_id = ";
		modell_sizeValue += input.getScreenSizeId();
		sql += modell_sizeValue;
		
	}
	
	
	sql += "  and m.modell_type_id =  ";
	
	sql += input.getTypeId();
	
	
	String groupby = " group by m.MODELL_NAME";
	
	sql += groupby;
	
	List <OrderItem> currentItem = this.getJdbcTemplate().query(sql, new RowMapper<OrderItem>(){
	
	@Override
	public OrderItem  mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		OrderItem orderItem = new OrderItem();
		orderItem.setCompanyName(rs.getString("company_name"));
		orderItem.setModellName(rs.getString("modell_Name"));
		orderItem.setModellSizeName(rs.getString("modell_size_name"));
		orderItem.setPrice(rs.getString("modell_pris"));
		orderItem.setInfoOfModell(rs.getString("modell_info"));
		orderItem.setProductId(rs.getString("id"));
		return orderItem;
	}
	
	});
	return currentItem;
	}
}