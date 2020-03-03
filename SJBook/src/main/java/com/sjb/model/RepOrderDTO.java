package com.sjb.model;

public class RepOrderDTO {

	private String productName;
	
	private int amount;
	
	private int cnt;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "RepOrderDTO [productName=" + productName + ", amount=" + amount + ", cnt=" + cnt + "]";
	}
	
	
	
}
