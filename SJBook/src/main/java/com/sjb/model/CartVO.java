package com.sjb.model;

public class CartVO {
	
	//카트 번호(기본키)
	private String cartId; 
	//제품 번호(외부연결)
	private int productId;
	//회원 번호(외부연결)
	private String memberId;
	//희망 수량
	private int cartStock;
	//등록날짜
	private String addDate;
	public String getcartId() {
		return cartId;
	}
	public void setcartId(String cartId) {
		this.cartId = cartId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getCartStock() {
		return cartStock;
	}
	public void setCartStock(int cartStock) {
		this.cartStock = cartStock;
	}
	public String getAddDate() {
		return addDate;
	}
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	@Override
	public String toString() {
		return "CartVO [cartId=" + cartId + ", productId=" + productId + ", memberId=" + memberId + ", cartStock="
				+ cartStock + ", addDate=" + addDate + "]";
	}

	
	
}
