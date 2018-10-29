package org.webshop.search.hibernate.dao;

import java.util.List;

import org.webshop.search.model.ProductModel;

public interface ProductModelDAO {
	
	void save(ProductModel procuctModel);
	
	ProductModel findById(int id);

	List <ProductModel> findAllByCompanyId(int companyId);
}
