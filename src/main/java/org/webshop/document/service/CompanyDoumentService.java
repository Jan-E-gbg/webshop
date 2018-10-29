package org.webshop.document.service;

import java.util.List;

import org.webshop.search.model.CompanyDocument;

public interface CompanyDoumentService {
	
	List<CompanyDocument> findAll();
	
	void save(CompanyDocument document);

}
