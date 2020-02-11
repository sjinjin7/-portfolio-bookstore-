package com.sjb.model;

public class OrderVO {

	//주문번호
	private int orderId;
	
	//멤버id
	private String memberId;
	
	//수신자
	private String orderRec;
	
	//우편번호
	private String memberAddr1;
	
	//주소
	private String memberAddr2;
	
	//상세주소
	private String memberAddr3;
	
	//휴대폰번호
	private String orderPhone;
	
	//주문날짜
	private String orderDate;
	
	//배송비
	private int shipPrice;
	
	//총가격
	private int totalPrice;
	
	//주문 상태
	private int orderState;
	
	//배송날자
	private String shipDate;
	
	//배송완료 날짜
	private String clearDate;
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getmemberId() {
		return memberId;
	}

	public void setmemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getOrderRec() {
		return orderRec;
	}

	public void setOrderRec(String orderRec) {
		this.orderRec = orderRec;
	}

	public String getMemberAddr1() {
		return memberAddr1;
	}

	public void setMemberAddr1(String memberAddr1) {
		this.memberAddr1 = memberAddr1;
	}

	public String getMemberAddr2() {
		return memberAddr2;
	}

	public void setMemberAddr2(String memberAddr2) {
		this.memberAddr2 = memberAddr2;
	}

	public String getMemberAddr3() {
		return memberAddr3;
	}

	public void setMemberAddr3(String memberAddr3) {
		this.memberAddr3 = memberAddr3;
	}

	public String getOrderPhone() {
		return orderPhone;
	}

	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getShipPrice() {
		return shipPrice;
	}

	public void setShipPrice(int shipPrice) {
		this.shipPrice = shipPrice;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getOrderState() {
		return orderState;
	}

	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}

	public String getShipDate() {
		return shipDate;
	}

	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}

	public String getClearDate() {
		return clearDate;
	}

	public void setClearDate(String clearDate) {
		this.clearDate = clearDate;
	}

	@Override
	public String toString() {
		return "OrderVO [orderId=" + orderId + ", memberId=" + memberId + ", orderRec=" + orderRec + ", memberAddr1="
				+ memberAddr1 + ", memberAddr2=" + memberAddr2 + ", memberAddr3=" + memberAddr3 + ", orderPhone="
				+ orderPhone + ", orderDate=" + orderDate + ", shipPrice=" + shipPrice + ", totalPrice=" + totalPrice
				+ ", orderState=" + orderState + ", shipDate=" + shipDate + ", clearDate=" + clearDate + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
