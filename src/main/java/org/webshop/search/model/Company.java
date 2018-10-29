package org.webshop.search.model;

import java.io.Serializable;

public class Company implements Serializable {
 
    private static final long serialVersionUID = -1798070786993154676L;
	
	
	private String companyId;

	private String companyName;
	
	public Company() {
		
	}

	public Company(String companyId, String companyName) {
		// TODO Auto-generated constructor stub
		this.companyId = companyId;
		this.companyName = companyName;
	}


	public String getCompanyId() {
		return companyId;
	}


	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
