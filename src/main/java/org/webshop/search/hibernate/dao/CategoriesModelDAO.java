package org.webshop.search.hibernate.dao;

import java.util.List;

import org.webshop.search.model.CategoriesModel;

public interface CategoriesModelDAO {
	
	
	void save(CategoriesModel categoriesModel);
	
	List <CategoriesModel> list();
	
	List <CategoriesModel>findAllByCompanyId(int companyId);

}
