package org.webshop.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.webshop.document.search.service.CompanyImgDocService;
import org.webshop.search.dao.CollectionOfModelDAO;
import org.webshop.search.dao.CompanyDAO;
import org.webshop.search.dao.DisplayScreenSizeDAO;
import org.webshop.search.dao.EquipmentTypeDAO;
import org.webshop.search.model.CollectionOfModel;
import org.webshop.search.model.Company;
import org.webshop.search.model.ProductName;
import org.webshop.search.model.ScreenSize;
@Service("searchService")
public class SearchServiceImpl implements SearchService {
	
	@Autowired
	@Qualifier(value="QualiCompanyDAO")
	private CompanyDAO companyDAO;
	
	@Autowired
	@Qualifier(value="QualiCollectionOfModelDAO")
	private CollectionOfModelDAO collectionOfModelDAO;
	
	@Autowired
	@Qualifier(value="QualiDisplayScreenSizeDAO")
	private DisplayScreenSizeDAO displayScreenSizeDAO;
	
	@Autowired
	@Qualifier(value="QualiEquipmentTypeDAO")
	private EquipmentTypeDAO equipmentTypeDAO;
	
	@Autowired
	private CompanyImgDocService companyImgDocService;


	@Override
	public List<Company> getListOfCompanys() {
		// TODO Auto-generated method stub
		return companyDAO.list();
	}

	
	@Override
	public List<CollectionOfModel> getAllModels(long companyId) {
		// TODO Auto-generated method stub
		
		return collectionOfModelDAO.listOfModels(companyId);
		
	}


	@Override
	public CollectionOfModel getProductModel(long productId) {
		// TODO Auto-generated method stub
		CollectionOfModel theCollectionOfModel;
		theCollectionOfModel = collectionOfModelDAO.getProductModel(productId);
		
		theCollectionOfModel.setListOfImages(companyImgDocService.findAllByProductId((int) productId));
		return theCollectionOfModel;
	}


	@Override
	public List<ScreenSize> getListOfSizes() {
		// TODO Auto-generated method stub
		return displayScreenSizeDAO.getListOfSize();
	}

	@Override
	public List<ProductName> getListOfProductNames() {
		// TODO Auto-generated method stub
		return equipmentTypeDAO.getListOfType();
	}

}
