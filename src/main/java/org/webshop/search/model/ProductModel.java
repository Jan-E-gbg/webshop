package org.webshop.search.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;

@Entity
@Table(name="modells")
public class ProductModel {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;

	
	@Column(name="MODELL_SIZE_ID")
	private Integer screenSizeId;
	
	@Column(name="MODELL_TYPE_ID")
	private Integer modellTypeId;
	
	@Column(name="COMPANY_ID")
	private Integer companyId;
	
	@Column(name="MODELL_NAME")
	private String procuctName; 
	
	@Column(name="MODELL_INFO")
	private String procuctInfo;
	
	@Column(name="MODELL_PRIS")
	private int productPris;
	
	@Column(name="IS_VISEBLE")
	private int isViseble;
	
	private String companyName;

	
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@OneToMany(mappedBy = "model", cascade = CascadeType.MERGE)

	private Set<CompanyImgAndDoc> companyImgAndDoc = new HashSet<CompanyImgAndDoc>();
	
	@ManyToOne()
	@JoinColumn(name="COMPANY_ID", 
	insertable=false, updatable=false, 
	nullable=false)
	public CompanyModel companyModel;

	public CompanyModel getCompanyModel() {
		return companyModel;
	}

	public void setCompanyModel(CompanyModel companyModel) {
		this.companyModel = companyModel;
	}

	public Integer getScreenSizeId() {
		return screenSizeId;
	}

	public void setScreenSizeId(Integer screenSizeId) {
		this.screenSizeId = screenSizeId;
	}

	public Integer getModellTypeId() {
		return modellTypeId;
	}

	public void setModellTypeId(Integer modellTypeId) {
		this.modellTypeId = modellTypeId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getProcuctName() {
		return procuctName;
	}

	public void setProcuctName(String procuctName) {
		this.procuctName = procuctName;
	}

	public String getProcuctInfo() {
		return procuctInfo;
	}

	public void setProcuctInfo(String procuctInfo) {
		this.procuctInfo = procuctInfo;
	}

	public int getProductPris() {
		return productPris;
	}

	public void setProductPris(int productPris) {
		this.productPris = productPris;
	}

	public int getIsViseble() {
		return isViseble;
	}

	public void setIsViseble(int isViseble) {
		this.isViseble = isViseble;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
