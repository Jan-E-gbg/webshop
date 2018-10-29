package org.webshop.document.search.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webshop.document.search.dao.CompanyImgAndDocDAO;
import org.webshop.search.hibernate.dao.ProductModelDAO;
import org.webshop.search.model.CollectionOfModel;
import org.webshop.search.model.Company;
import org.webshop.search.model.CompanyImgAndDoc;
import org.webshop.search.model.ProductModel;

@Service("companyImgDocService")
@org.springframework.transaction.annotation.Transactional
public class CompanyImgDocServiceImpl implements CompanyImgDocService  {

	@Autowired
	CompanyImgAndDocDAO companyImgAndDocDAO;
	
	@Autowired
	ProductModelDAO procuctModelDAO;
	
	@Override
	public void save(CompanyImgAndDoc companyImgDoc) {
		// TODO Auto-generated method stub
		companyImgAndDocDAO.save(companyImgDoc);
		
	}
	
	public void save(ProductModel procuctModel) {
		
		procuctModelDAO.save(procuctModel);
	}
	
	
	public List<CompanyImgAndDoc>findAllByProductId(int productId) {
		// TODO Auto-generated method stub
		return companyImgAndDocDAO.findAllByProductId(productId);
	}

	
	/*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
	
	@Override
	public void updateProcuctModel(CollectionOfModel collectionOfModel) {
		// TODO Auto-generated method stub
		
		ProductModel entity = procuctModelDAO.findById(Integer.parseInt(collectionOfModel.getProductId()));
		
		if(entity != null) {
			entity.setCompanyId(Integer.parseInt(collectionOfModel.getCompany_id()));
			entity.setScreenSizeId(Integer.parseInt(collectionOfModel.getModell_size_id()));
			entity.setProcuctInfo(collectionOfModel.getModell_info());
			entity.setModellTypeId(Integer.parseInt(collectionOfModel.getModell_type_id()));
			entity.setProcuctName(collectionOfModel.getModellName());
			entity.setProductPris(Integer.parseInt(collectionOfModel.getModellPris()));
			entity.setIsViseble(Integer.parseInt(collectionOfModel.getIsVisible()));
			
		}
	}

	@Override
	public void save(Company company) {
		// TODO Auto-generated method stub
		
	}


}
