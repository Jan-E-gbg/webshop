package org.webshop.search.model;

public class SearchItem {
	
	private String jspPath;
	private String imgName;
	private int productId;
	private String jspFullPathAndImgName;
	private int colSpan = 0;
	private String productName;
	
	
	
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getJspFullPathAndImgName() {
		return jspFullPathAndImgName = "<script <img ng-src='"+getJspPath()+"'" +"\\img\\"+ getImgName()+"'/>></script>";
	}

	public void setJspFullPathAndImgName(String jspFullPathAndImgName) {
		this.jspFullPathAndImgName = jspFullPathAndImgName;

	}
	
	public String getJspPath() {
		return jspPath;
	}

	public void setJspPath(String jspPath) {
		this.jspPath = jspPath;
	}
	
	public String getImgName() {
		return imgName;
	}
	
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getColSpan() {
		return colSpan;
	}

	public void setColSpan(int colSpan) {
		this.colSpan = colSpan;
	}
	
	
	
	

}
