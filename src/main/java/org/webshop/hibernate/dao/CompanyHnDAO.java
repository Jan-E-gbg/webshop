package org.webshop.hibernate.dao;

import java.util.List;

import org.webshop.search.model.CompanyHn;

public interface CompanyHnDAO {

	
	void save(CompanyHn company);
	
	List<CompanyHn> list();
}
