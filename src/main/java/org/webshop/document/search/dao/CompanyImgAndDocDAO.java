package org.webshop.document.search.dao;

import java.util.List;

import org.webshop.search.model.CompanyImgAndDoc;

public interface CompanyImgAndDocDAO {
	
	void save(CompanyImgAndDoc companyImgAndDoc);
	
	List <CompanyImgAndDoc>findAllByProductId(int productId );
	
	CompanyImgAndDoc findById(int id);

}
