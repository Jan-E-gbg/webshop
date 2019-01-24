package org.webshop.search.service;

import java.util.List;

import org.webshop.search.model.CategoriesModel;
import org.webshop.search.model.CollectionOfModel;
import org.webshop.search.model.Company;
import org.webshop.search.model.ProductName;
import org.webshop.search.model.ScreenSize;
import org.webshop.search.model.SearchItem;


public interface SearchService {
	
	List <Company> getListOfCompanys();
	
	List<CollectionOfModel> getAllModels(long companyId);
	
	CollectionOfModel getProductModel(long productId);
	
	List <ScreenSize> getListOfSizes();
	
	List<ProductName> getListOfProductNames();
	
	List<CategoriesModel> getAllCategoriesByCompanyId(long companyId);
	
	List<CollectionOfModel> getAllPruductByCompanyAndCategories(long companyId,long categoriesId);

	List<SearchItem> getAllSearchItems(int viseble);
}
