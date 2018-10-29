package org.webshop.search.hibernate.dao.impl;

import org.springframework.stereotype.Repository;
import org.webshop.document.dao.AbstractDAO;
import org.webshop.search.hibernate.dao.CompanyModelDAO;
import org.webshop.search.model.CompanyModel;

@Repository("CompanyModelDAO")
public class CompanyModelDAOImpl extends AbstractDAO<Integer, CompanyModel > implements CompanyModelDAO {

	@Override
	public void save(CompanyModel companyModel) {
		// TODO Auto-generated method stub
		persist(companyModel);
		
	}

	@Override
	public CompanyModel findById(int id) {
		// TODO Auto-generated method stub
		return  getByKey(id);
	}

}
