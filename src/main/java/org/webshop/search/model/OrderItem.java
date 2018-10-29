package org.webshop.search.model;

public class OrderItem {
	
	private String productId;
	private String amountOf;
	private String price;
	private String companyName;
	private String modellName;
	private String infoOfModell;
	private String modellSizeName;
	private String modellSizeId;
	private String modellScreenSize;
	private boolean idValidate = false;
	private int amountOfInt = 0;
	private String sum;
	
	
	public int getSumOfAmount(){
		
		int somOfAmout = this.getAmountOfInt();
		int tempPrice = Integer.parseInt(this.getPrice());
		
		return somOfAmout * tempPrice;
	}
	
	public String getSumOfAmountStr(){
		return String.valueOf(this.getSumOfAmount());
	}
	
	public void SetNotValidate(){
		this.idValidate = false;
	}
	
	public void setIsValidate(){
		this.idValidate = true;
	}
	
	public boolean getIsValidate(){
		
		return this.idValidate;
	}
	
	public String getModellScreenSize() {
		return modellScreenSize;
	}

	public void setModellScreenSize(String modellScreenSize) {
		this.modellScreenSize = modellScreenSize;
	}

	public String getModellSizeId() {
		return modellSizeId;
	}

	public void setModellSizeId(String modellSizeId) {
		this.modellSizeId = modellSizeId;
	}

	public String getModellSizeName() {
		return modellSizeName;
	}
	
	public void setModellSizeName(String modellSizeName) {
		this.modellSizeName = modellSizeName;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getModellName() {
		return modellName;
	}
	public void setModellName(String modellName) {
		this.modellName = modellName;
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
	public String getAmountOf() {
		return amountOf;
	}
	public void setAmountOf(String amountOf) {
		this.amountOf = amountOf;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	public int getAmountOfInt() {
		return amountOfInt;
	}

	public void setAmountOfInt(int amountOfInt) {
		this.amountOfInt = amountOfInt;
	}
	
	public String getSum(){
		return this.sum;
	}
	
	public void setSum(String sum){
		
		this.sum = sum;
	}

	

}
