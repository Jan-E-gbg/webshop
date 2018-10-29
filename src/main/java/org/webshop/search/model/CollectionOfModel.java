  package org.webshop.search.model;

import java.util.List;

public class CollectionOfModel {
	
	private String company_id;
	private String companyName;
	
	private String modell_size_id;
	private String modell_size_name;
	
	private String modell_type_id;
	private String modell_type_name;
	
	private String IS_VISEBLE;
	
	
	private String modellPris;
	
	private String modell_info;
	
	private String ID;
	
	
	private String modellName;
	
	private String productId;
	
	private String infoOfModell;
	
	private String amountOf;
	
	private List<CompanyImgAndDoc> listOfImages;
	
	
	
	
	
	
	
	public String getAmountOf() {
		return amountOf;
	}

	public void setAmountOf(String amountOf) {
		this.amountOf = amountOf;
	}

	public String getInfoOfModell() {
		return infoOfModell;
	}

	public void setInfoOfModell(String infoOfModell) {
		this.infoOfModell = infoOfModell;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getID(){
		return ID;
	}
	
	public void setID(String ID){
		this.ID = ID;
	}
	
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	
	
	public String getModell_size_id() {
		return modell_size_id;
	}
	public void setModell_size_id(String modell_size_id) {
		this.modell_size_id = modell_size_id;
	}
	
	public String getModell_type_id() {
		return modell_type_id;
	}
	public void setModell_type_id(String modell_type_id) {
		this.modell_type_id = modell_type_id;
	}
	
	public String getModell_size_name() {
		return modell_size_name;
	}
	public void setModell_size_name(String modell_size_name) {
		this.modell_size_name = modell_size_name;
	}
	
	public String getCompanyName() { 
		return companyName;
	}
	public void setCompanyName(String company_name) {
		this.companyName = company_name;
	
	}
	public String getModell_type_name() {
		return modell_type_name;
	}
	public void setModell_type_name(String modell_type_name) {
		this.modell_type_name = modell_type_name;
	}
	public String getModellName() {
		return modellName;
	}
	public void setModellName(String modell_name) {
		this.modellName = modell_name;
	}
	public String getModellPris() {
		return modellPris;
	}
	public void setModellPris(String modell_pris) {
		this.modellPris = modell_pris;
	}
	public String getModell_info() {
		return modell_info;
	}
	public void setModell_info(String modell_info) {
		this.modell_info = modell_info;
	}
	
	public void setListOfImages(List<CompanyImgAndDoc> list) {
		
		this.listOfImages = list;
	}
	
	public List <CompanyImgAndDoc>getListOfImages(){
		
		return this.listOfImages;
	}

	public String getIsVisible() {
		return IS_VISEBLE;
	}

	public void setIsVisible(String iS_VISEBLE) {
		IS_VISEBLE = iS_VISEBLE;
	}
	
	


}
