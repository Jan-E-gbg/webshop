
package org.webshop.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.webshop.document.dao.AbstractDAO;
import org.webshop.hibernate.dao.CompanyHnDAO;
import org.webshop.search.model.CompanyHn;

public class CompanyHnDAOImpl extends AbstractDAO<Integer,CompanyHn> implements CompanyHnDAO  {

	@Override
	public void save(CompanyHn company) {
		// TODO Auto-generated method stub
		persist(company);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CompanyHn> list() {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		return (List<CompanyHn>)crit.list();
	}

}
