package org.webshop.search.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.webshop.search.model.CollectionOfModel;


@SuppressWarnings("rawtypes")
public class CollectionOfModelMapper implements Serializable, RowMapper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		CollectionOfModel model = new CollectionOfModel();
		model.setModellName(rs.getString("MODELL_NAME"));
		model.setProductId(rs.getString("ID"));
		model.setCompany_id(rs.getString("COMPANY_ID"));
		model.setModell_info(rs.getString("MODELL_INFO"));
		model.setModellPris(rs.getString("MODELL_PRIS"));
		model.setModell_type_name(rs.getString("MODELL_TYPE_NAME"));
		model.setModell_type_id(rs.getString("modell_type_id"));
		model.setModell_size_name(rs.getString("modell_size_name"));
		model.setModell_size_id(rs.getString("modell_size_id"));
		model.setIsVisible(rs.getString("IS_VISEBLE"));
		return model;
	}

}
