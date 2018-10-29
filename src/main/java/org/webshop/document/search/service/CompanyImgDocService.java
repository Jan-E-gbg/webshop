package org.webshop.document.search.service;

import java.util.List;

import org.webshop.search.model.CollectionOfModel;
import org.webshop.search.model.Company;
import org.webshop.search.model.CompanyImgAndDoc;
import org.webshop.search.model.ProductModel;

public interface CompanyImgDocService {
	
	void save(CompanyImgAndDoc companyImgDoc);
	
	void save(ProductModel procuctModel);
	
	List <CompanyImgAndDoc>findAllByProductId(int productId );

	void updateProcuctModel(CollectionOfModel collectionOfModel);
	
	void save(Company company);

}
