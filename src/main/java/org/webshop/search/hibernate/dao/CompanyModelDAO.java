package org.webshop.search.hibernate.dao;

import org.webshop.search.model.CompanyModel;

public interface CompanyModelDAO {
	
	void save(CompanyModel companyModel);
	
	CompanyModel findById(int id);

}
