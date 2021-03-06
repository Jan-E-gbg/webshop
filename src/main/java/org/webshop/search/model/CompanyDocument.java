package org.webshop.search.model;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
@Entity
@Table(name="company_document")
public class CompanyDocument {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	 
	@Column(name="name", length=100, nullable=false)
	private String name;
	 
	@Column(name="description", length=255)
	private String description;
	 
	@Column(name="type", length=100, nullable=false)
	private String type;
	 
	@Lob @Basic(fetch = FetchType.LAZY)
	@Column(name="content", nullable=false)
	private byte[] content;
	
	@Column(name = "company_id", length = 6, nullable = false)
    private Integer company_id;
	
	@Column(name = "product_id", length = 6, nullable = false)
    private Integer product_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public Integer getCompany_id() {
		return company_id;
	}

	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	
	
	
	
	
	

	
	

	
}
