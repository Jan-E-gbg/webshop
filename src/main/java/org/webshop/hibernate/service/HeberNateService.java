package org.webshop.hibernate.service;

import java.util.List;

import org.webshop.search.model.CompanyHn;

public interface HeberNateService {
	
	void save(CompanyHn companyHn);
	
	List <CompanyHn> list();
	

}
