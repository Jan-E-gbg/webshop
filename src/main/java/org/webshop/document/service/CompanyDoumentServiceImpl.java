package org.webshop.document.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webshop.document.dao.CompanyDocumentDAO;
import org.webshop.search.model.CompanyDocument;

@Service("companyDocumentService")
@Transactional 

public class CompanyDoumentServiceImpl implements CompanyDoumentService {

	@Autowired
	CompanyDocumentDAO dao;
	
	
	@Override
	public List<CompanyDocument> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(CompanyDocument document) {
		// TODO Auto-generated method stub
		dao.save(document);
		
	}

}
