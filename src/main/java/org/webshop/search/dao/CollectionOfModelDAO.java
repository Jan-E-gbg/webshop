package org.webshop.search.dao;

import java.util.List;

import org.webshop.search.model.CollectionOfModel;


public interface CollectionOfModelDAO {

	List<CollectionOfModel> listOfModels(long companyId);
	CollectionOfModel getProductModel(long productId);
}
