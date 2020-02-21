package com.sjb.model;

public class ReplyVO {

	// 리뷰 ID
	private int repNum;
	
	// 제품 ID
	private int productID;
	
	// 회원ID(작성자)
	private String memberID;
	
	// 리뷰 내용
	private String repCon;
	
	// 리뷰 평점
	private float likeRating;
	
	// 리뷰 등록 날짜
	private String repDate;
	
	// 리뷰 수정 날짜
	private String modDate;

	public int getRepNum() {
		return repNum;
	}

	public void setRepNum(int repNum) {
		this.repNum = repNum;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getRepCon() {
		return repCon;
	}

	public void setRepCon(String repCon) {
		this.repCon = repCon;
	}

	public float getLikeRating() {
		return likeRating;
	}

	public void setLikeRating(float likeRating) {
		this.likeRating = likeRating;
	}

	public String getRepDate() {
		return repDate;
	}

	public void setRepDate(String repDate) {
		this.repDate = repDate;
	}

	public String getModDate() {
		return modDate;
	}

	public void setModDate(String modDate) {
		this.modDate = modDate;
	}

	@Override
	public String toString() {
		return "ReplyVO [repNum=" + repNum + ", productID=" + productID + ", memberID=" + memberID + ", repCon="
				+ repCon + ", likeRating=" + likeRating + ", repDate=" + repDate + ", modDate=" + modDate + "]";
	}

	
	
}
