package org.webshop.search.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.webshop.document.dao.AbstractDAO;
import org.webshop.search.hibernate.dao.CategoriesModelDAO;
import org.webshop.search.model.CategoriesModel;

@Repository("CategoriesModelDAO")
public class CategoriesModelDAOImpl extends AbstractDAO<Integer, CategoriesModel > implements CategoriesModelDAO {

	@Override
	public void save(CategoriesModel categoriesModel) {
		// TODO Auto-generated method stub
		persist(categoriesModel);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CategoriesModel> list() {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		return (List<CategoriesModel>)crit.list();
		
	}

}
