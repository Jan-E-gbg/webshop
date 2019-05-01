package org.webshop.search.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="companys_img_doc")

public class CompanyImgAndDoc {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="product_id")
	private int productId;
	
	@Column(name="isVisible")
	private int isVisible = 0;
	
	@Column(name="priority")
	private int priority;
	
	@Column(name="text", length=200)
	private String text;
	
	@Column(name="name", length=100, nullable=false)
	private String name;
	 
	@Column(name="description", length=255)
	private String description;
	 
	@Column(name="type", length=100)
	private String type;
	
	@Column(name="jsp_path", length=255)
	private String jspPath;
	
	private int colSpan = 0;
	
	
	
	public int getColSpan() {
		return colSpan;
	}

	public void setColSpan(int colSpan) {
		this.colSpan = colSpan;
	}

	public String getJspPath() {
		return jspPath;
	}
	
	public void setJspPath(String jspPath) {
		this.jspPath = jspPath;
	}

	
	@Lob @Basic(fetch = FetchType.LAZY)
	@Column(name="content", nullable=false)
	private byte[] content;
	
	@ManyToOne()
	@JoinColumn(name="product_id", 
	insertable=false, updatable=false, 
	nullable=false)
    private ProductModel model;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getIsVisible(){
		return isVisible;
	}

	public void setIsVisible(int isVisible) {
		this.isVisible = isVisible;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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
	
	
	
}
