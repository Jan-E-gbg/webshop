package org.webshop.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webshop.search.hibernate.dao.ProductModelDAO;
import org.webshop.search.model.ProductModel;

@Service("productModelService")
@org.springframework.transaction.annotation.Transactional
public class ProductModelServiceImpl implements ProductModelService  {
	
	
	@Autowired
	ProductModelDAO procuctModelDAO;

	@Override
	public void save(ProductModel productModel) {
		// TODO Auto-generated method stub
		procuctModelDAO.save(productModel);
		
	}

	@Override
	public ProductModel findById(int id) {
		// TODO Auto-generated method stub
		return procuctModelDAO.findById(id);
	}

	@Override
	public List<ProductModel> findAllByCompanyId(int companyId) {
		// TODO Auto-generated method stub
		return procuctModelDAO.findAllByCompanyId(companyId);
	}

}
