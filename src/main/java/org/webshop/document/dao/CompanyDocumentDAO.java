package org.webshop.document.dao;

import java.util.List;

import org.webshop.search.model.CompanyDocument;

public interface CompanyDocumentDAO {
	
List<CompanyDocument>findAll();
	
	void save(CompanyDocument document);
	
	CompanyDocument findById(int id);
	

}