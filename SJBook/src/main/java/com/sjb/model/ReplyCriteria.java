package com.sjb.model;

public class ReplyCriteria {

	//페이지번호
	private int pageNum;
	
	//페이지 표현 갯수
	private int amount;
	
	//리뷰 대상(제품)
	private int productID;
	
	public ReplyCriteria(){
		this(1,10);
	}
	
	public ReplyCriteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	@Override
	public String toString() {
		return "ReplyCriteria [pageNum=" + pageNum + ", amount=" + amount + ", productID=" + productID + "]";
	}
	
	
	
	
}
