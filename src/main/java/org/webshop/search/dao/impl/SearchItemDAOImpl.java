package org.webshop.search.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.webshop.search.dao.SearchItemDAO;
import org.webshop.search.model.SearchItem;

public class SearchItemDAOImpl extends JdbcDaoSupport implements SearchItemDAO {

	
	@Autowired 
	public SearchItemDAOImpl(DataSource dataSource){
		this.setDataSource(dataSource);
	}
	
	@Override
	public List<SearchItem> getAllItem(int viseble) {
		// TODO Auto-generated  stub
		
 
		String sql = "select DISTINCT  \r\n" + 
				" companys_img_doc.jsp_path,companys_img_doc.product_id,companys_img_doc.name, modells.MODELL_NAME, modells.MODELL_INFO, modells.MODELL_PRIS " +
				 " from modells , companys_img_doc where modells.IS_VISEBLE = 1 and companys_img_doc.isVisible = 1 and modells.ID = companys_img_doc.product_id";
		
		List<SearchItem> item = this.getJdbcTemplate().query(sql, new ResultSetExtractor<List<SearchItem>>() {
			RowCountCallbackHandler countCallback = new RowCountCallbackHandler();
			@SuppressWarnings({ })
			
			List<SearchItem> items  = new ArrayList<SearchItem>();
		
			private int rowCount = countCallback.getRowCount();
			
			
			@Override
			public List<SearchItem> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
			
				System.out.println(rowCount);
				
				while(rs.next()) {
					
					

						SearchItem item = new SearchItem();
						 item.setImgName(rs.getString("name"));
						 item.setJspPath(rs.getString("jsp_path"));
						 item.setProductId(rs.getInt("product_id"));
						 item.setProductName(rs.getString("MODELL_NAME"));
						 item.setProductInfo(rs.getString("MODELL_INFO"));
						 item.setPrise(rs.getString("MODELL_PRIS"));
						 item.setColSpan(0);
						items.add(item);
						
					}
				
				return items;
			}
			
		});
		return item;
	}

}
