package org.webshop.search.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.webshop.search.dao.CollectionOfModelDAO;
import org.webshop.search.model.CategoriesModel;
import org.webshop.search.model.CollectionOfModel;


public class CollectionOfModelDAOImpl extends JdbcDaoSupport implements CollectionOfModelDAO {
	
	@Autowired 
	public CollectionOfModelDAOImpl(DataSource dataSource){
		this.setDataSource(dataSource);
	}
	
	
	@Override
	public List<CollectionOfModel> listOfModels(long companyId) {
		// TODO Auto-generated method stub
		
		String sql = "select m.ID, m.COMPANY_ID, m.MODELL_NAME, m.MODELL_INFO, m.MODELL_PRIS, m.IS_VISEBLE, t.MODELL_TYPE_NAME, z.modell_size_name, t.modell_type_id, z.modell_size_id, t.modell_type_name " 
				+ "from modells m , modell_types t , modell_sizes z   where t.modell_type_id = m.MODELL_TYPE_ID and z.modell_size_id = m.modell_size_id  and   m.COMPANY_ID = ";
		
		sql += String.valueOf(companyId);
		
		
		
		List<CollectionOfModel> listOfModels = this.getJdbcTemplate().query(sql, new RowMapper<CollectionOfModel>() {
		
			@Override
			public CollectionOfModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				CollectionOfModel model = new CollectionOfModel();
				model.setProductId(rs.getString("ID"));
				model.setCompany_id(rs.getString("COMPANY_ID"));
				model.setInfoOfModell(rs.getString("MODELL_INFO"));
				model.setModellPris(rs.getString("MODELL_PRIS"));
				model.setModell_type_name(rs.getString("MODELL_TYPE_NAME"));
				model.setModell_type_id(rs.getString("modell_type_id"));
				model.setModell_size_name(rs.getString("modell_size_name"));
				model.setModell_size_id(rs.getString("modell_size_id"));
				model.setModellName(rs.getString("modell_name"));
				model.setModell_type_name(rs.getString("modell_type_name"));
				model.setIsVisible(rs.getString("IS_VISEBLE"));
				
				return model;
			}
		});
		return listOfModels;
	}


	
		@SuppressWarnings("unchecked")
		@Override
		public CollectionOfModel getProductModel(long productId) {
			// TODO Auto-generated method stub
			String sql = "select m.ID, m.COMPANY_ID, m.MODELL_NAME, m.MODELL_INFO, m.MODELL_PRIS, m.IS_VISEBLE,  t.MODELL_TYPE_NAME, z.modell_size_name, t.modell_type_id, z.modell_size_id " 
					+ "from modells m , modell_types t , modell_sizes z   where t.modell_type_id = m.MODELL_TYPE_ID and z.modell_size_id = m.modell_size_id and m.ID = ? ";
			CollectionOfModel collectionOfModel =(CollectionOfModel)this.getJdbcTemplate().queryForObject(sql, new Object[] { productId }, new CollectionOfModelMapper());
			return collectionOfModel;
		}


		@Override
		public List<CollectionOfModel> getAllPruductByCompanyAndCategories(long companyId, long categoriesId) {
			// TODO Auto-generated method stub
			
			String sql = "SELECT m.ID, m.COMPANY_ID, m.MODELL_NAME, m.MODELL_INFO, m.MODELL_PRIS, m.IS_VISEBLE, m.modell_type_id, m.modell_size_id, t.modell_type_name, z.modell_size_name\r\n" + 
					"FROM lexicon.modells m, lexicon.modell_types t, lexicon.modell_sizes z where m.COMPANY_ID = '" + companyId + "'  and m.MODELL_TYPE_ID = '" + categoriesId + "' and m.MODELL_TYPE_ID = t.modell_type_id and m.modell_size_id = z.modell_size_id";
			List<CollectionOfModel> listOfModels = this.getJdbcTemplate().query(sql, new ResultSetExtractor<List<CollectionOfModel>>(){
				
				@SuppressWarnings({ "unchecked", "rawtypes" })
				List<CollectionOfModel> models = new ArrayList();
				
				@Override
				public List<CollectionOfModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
					// TODO Auto-generated method stub
					while(rs.next()) {
						CollectionOfModel model = new CollectionOfModel();
						model.setProductId(rs.getString("ID"));
						model.setCompany_id(rs.getString("COMPANY_ID"));
						model.setInfoOfModell(rs.getString("MODELL_INFO"));
						model.setModellPris(rs.getString("MODELL_PRIS"));
						model.setModell_type_name(rs.getString("MODELL_TYPE_NAME"));
						model.setModell_type_id(rs.getString("modell_type_id"));
						model.setModell_size_name(rs.getString("modell_size_name"));
						model.setModell_size_id(rs.getString("modell_size_id"));
						model.setModellName(rs.getString("modell_name"));
						model.setModell_type_name(rs.getString("modell_type_name"));
						model.setIsVisible(rs.getString("IS_VISEBLE"));
						models.add(model);
					}
					return models;
				}
		});
			
			return listOfModels;
			
	}
	
}

