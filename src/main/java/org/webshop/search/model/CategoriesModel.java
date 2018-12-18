package org.webshop.search.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="modell_types", uniqueConstraints = {
        @UniqueConstraint(columnNames = "modell_type_id"),
        @UniqueConstraint(columnNames = "modell_type_name")})

public class CategoriesModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="modell_type_id", updatable=false, nullable=false)
	private int categoriesId;
	
	
	@Column(name="modell_type_name")
	private String categoriesName;
	
	
	public int getCategoriesId() {
		return categoriesId;
	}

	
	public void setCategoriesId(int categoriesId) {
		this.categoriesId = categoriesId;
	}

	public String getCategoriesName() {
		return categoriesName;
	}

	public void setCategoriesName(String categoriesName) {
		this.categoriesName = categoriesName;
	}


		
	
	

}
