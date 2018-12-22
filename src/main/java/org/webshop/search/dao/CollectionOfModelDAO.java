package org.webshop.search.dao;

import java.util.List;

import org.webshop.search.model.CategoriesModel;
import org.webshop.search.model.CollectionOfModel;


public interface CollectionOfModelDAO {

	List<CollectionOfModel> listOfModels(long companyId);
	
	CollectionOfModel getProductModel(long productId);
	
	List<CollectionOfModel> getAllPruductByCompanyAndCategories(long companyId,long categoriesId);
}
