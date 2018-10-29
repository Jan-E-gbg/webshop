package org.webshop.document.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.webshop.document.dao.AbstractDAO;
import org.webshop.document.dao.CompanyDocumentDAO;
import org.webshop.search.model.CompanyDocument;

@Repository("CompanyDocumentDAO")
public class CompanyDocumentDAOImpl extends AbstractDAO<Integer,CompanyDocument> implements  CompanyDocumentDAO  {

	@SuppressWarnings("unchecked")
	public List<CompanyDocument> findAll() {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		return (List<CompanyDocument>)crit.list();
	}


	public void save(CompanyDocument document) {
		// TODO Auto-generated method stub
		persist(document);
		
	}


	public CompanyDocument findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
