package org.webshop.search.workspace.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.webshop.search.model.OrderItem;
import org.webshop.search.workspace.dao.ItemDAO;

public class ItemDAOImpl<T> extends JdbcDaoSupport implements ItemDAO{

	
	@Autowired
	public ItemDAOImpl(DataSource dataSource){
		this.setDataSource(dataSource);
	}
	
	@Override
	public int[][] insertBatch(List<OrderItem> orderItem, String tableName) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO " + tableName +
				"(product_id, company_name, modell_name, modell_pris, ScreenSize, amountOf, sum  ) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		return this.getJdbcTemplate().batchUpdate(sql, orderItem, orderItem.size(),

                new ParameterizedPreparedStatementSetter<OrderItem>() {
				@Override        
				public void setValues(PreparedStatement ps, OrderItem orderItem) throws SQLException {
						ps.setInt(1,Integer.parseInt(orderItem.getProductId()) );
                        ps.setString(2,orderItem.getCompanyName() );
                        ps.setString(3,orderItem.getModellName() );
                        ps.setInt(4,Integer.parseInt(orderItem.getPrice()));
                        ps.setString(5,orderItem.getModellSizeName());
                        ps.setInt(6,orderItem.getAmountOfInt());
                        ps.setInt(7,0);
                    }		
           });
	
	}

	@Override
	public void updateAmountOf(int productId, int amountOf, String tableName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderItem getOrderItem(int productId, String tableName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItem> getAllOrderItemsIsSeleted(String tableName) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void dropTable(String tableName) {
		// TODO Auto-generated method stub
		
		List<SqlParameter> parameters = Arrays.asList(
	            new SqlParameter(Types.CHAR));
		
		Map<String, Object> t = this.getJdbcTemplate().call(new CallableStatementCreator() {

			@Override
			public CallableStatement createCallableStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				CallableStatement callableStatement = con.prepareCall("{call DropTable (?)}");
				callableStatement.setString(1,tableName);
			
				
				return callableStatement;
			} 
			
		}, parameters);
	}	
	

	@Override
	public void createWorkTable(String tableName) {
		// TODO Auto-generated method stub
		List<SqlParameter> parameters = Arrays.asList(
	            new SqlParameter(Types.CHAR));
		
		Map<String, Object> t = this.getJdbcTemplate().call(new CallableStatementCreator() {

			@Override
			public CallableStatement createCallableStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				CallableStatement callableStatement = con.prepareCall("{call createWorkTable (?)}");
				callableStatement.setString(1,tableName);
			
				
				return callableStatement;
			} 
			
		}, parameters);
		
	}

}
