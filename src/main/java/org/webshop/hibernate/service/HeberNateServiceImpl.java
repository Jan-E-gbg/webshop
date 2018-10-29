package org.webshop.hibernate.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webshop.hibernate.dao.CompanyHnDAO;
import org.webshop.search.model.CompanyHn;



@Service("heberNateService")
@Transactional
public class HeberNateServiceImpl implements HeberNateService {

	@Autowired
	@Qualifier(value="QualiCompanyHnDAO") 
	private CompanyHnDAO dao;
	
	@Override
	public void save(CompanyHn companyHn) {
		// TODO Auto-generated method stub
		dao.save(companyHn);
	}

	@Override
	public List<CompanyHn> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}
	
	
	

}
