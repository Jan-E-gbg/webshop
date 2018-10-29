package org.webshop.search.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.webshop.document.dao.AbstractDAO;
import org.webshop.search.hibernate.dao.ProductModelDAO;
import org.webshop.search.model.ProductModel;

@Repository("ProductModelDAO")
public class ProductModelDAOImpl extends AbstractDAO<Integer, ProductModel> implements ProductModelDAO {

	@Override
	public void save(ProductModel procuctModel) {
		// TODO Auto-generated method stub
			persist(procuctModel);
		
	}

	@Override
	public ProductModel findById(int id) {
		// TODO Auto-generated method stub
		ProductModel procuctModel  = getByKey(id);
		return procuctModel;
	}
	
	@SuppressWarnings("unchecked")
	public List <ProductModel> findAllByCompanyId(int companyId){
		Criteria crit = createEntityCriteria();
        Criteria userCriteria = crit.createCriteria("companyModel");
        userCriteria.add(Restrictions.eq("companyId", companyId));
		return(List<ProductModel>)crit.list();

		
	}

	

}
