package org.webshop.search.dao;

import java.util.List;

import org.webshop.search.model.CategoriesModel;
import org.webshop.search.model.ProductName;

public interface EquipmentTypeDAO {
	
	List <ProductName> getListOfType();
	
	List <CategoriesModel> getCategoriesByCompanyId(long companyId);

}
