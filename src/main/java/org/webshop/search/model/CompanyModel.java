package org.webshop.search.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="companys", uniqueConstraints = {
        @UniqueConstraint(columnNames = "company_id"),
        @UniqueConstraint(columnNames = "company_name")})

public class CompanyModel implements Serializable {
 
    private static final long serialVersionUID = -1798070786993154676L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="company_id")
	private int companyId;
	
	@Column(name="company_name", unique = true, nullable=false, length=90)
	private String companyName;
	

	@OneToMany(mappedBy = "companyModel", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	
	private Set<ProductModel> productModel = new HashSet<ProductModel>();
	 
	public int getCompanyId() {
		return companyId;
	}


	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
