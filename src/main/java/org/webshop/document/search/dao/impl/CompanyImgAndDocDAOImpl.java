package org.webshop.document.search.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.webshop.document.dao.AbstractDAO;
import org.webshop.document.search.dao.CompanyImgAndDocDAO;
import org.webshop.search.model.CompanyImgAndDoc;

@Repository("CompanyImgAndDocDAO")
public class CompanyImgAndDocDAOImpl extends AbstractDAO<Integer, CompanyImgAndDoc> implements CompanyImgAndDocDAO  {
	
	
	@Override
	public void save(CompanyImgAndDoc companyImgAndDoc) {
		// TODO Auto-generated method stub
		persist(companyImgAndDoc);
	}

	@SuppressWarnings("unchecked")
	public List<CompanyImgAndDoc> findAllByProductId(int productId) {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
        Criteria userCriteria = crit.createCriteria("model");
        userCriteria.add(Restrictions.eq("id", productId));
		return(List<CompanyImgAndDoc>)crit.list();
	}

}
