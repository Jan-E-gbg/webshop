package org.webshop.search.service;

import java.util.List;

import org.webshop.search.model.CollectionOfModel;
import org.webshop.search.model.Company;
import org.webshop.search.model.ProductName;
import org.webshop.search.model.ScreenSize;


public interface SearchService {
	
	List <Company> getListOfCompanys();
	
	List<CollectionOfModel> getAllModels(long companyId);
	
	CollectionOfModel getProductModel(long productId);
	
	List <ScreenSize> getListOfSizes();
	
	List<ProductName> getListOfProductNames();
	
}
