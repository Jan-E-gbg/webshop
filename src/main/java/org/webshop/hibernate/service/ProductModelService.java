package org.webshop.hibernate.service;

import java.util.List;

import org.webshop.search.model.ProductModel;

public interface ProductModelService {
	
	void save(ProductModel productModel);
	
	ProductModel findById(int id);

	List <ProductModel> findAllByCompanyId(int companyId);

}
