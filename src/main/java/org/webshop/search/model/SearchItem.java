package org.webshop.search.model;

public class SearchItem {
	
	private String jspPath;
	private String imgName;
	private int productId;
	private String jspFullPathAndImgName;
	
	
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
	
	
	
	

}
