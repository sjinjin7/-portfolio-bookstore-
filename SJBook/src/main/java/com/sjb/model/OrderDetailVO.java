package com.sjb.model;

public class OrderDetailVO {

	// 주문 상세id
	private int orderDetailId;
	
	// 주문번호
	private int orderId;
	
	// 제품 번호
	private int productId;
	
	// 수량
	private int amount;

	public int getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "OrderDetailVO [orderDetailId=" + orderDetailId + ", orderId=" + orderId + ", productId=" + productId
				+ ", amount=" + amount + "]";
	}
	
	
}
