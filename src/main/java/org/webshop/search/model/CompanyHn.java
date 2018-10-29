package org.webshop.search.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company_hn")
public class CompanyHn {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer company_Id;
	
	@Column(name = "company_name", length = 50 ,unique = true, nullable=false)
	private String companyName;

	public Integer getCompanyId() {
		return company_Id;
	}

	public void setCompanyId(Integer companyId) {
		this.company_Id = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}
	
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	

}
