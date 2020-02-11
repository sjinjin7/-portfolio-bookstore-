package com.sjb.mapper;

import com.sjb.model.OrderDetailVO;
import com.sjb.model.OrderVO;

public interface PurchaseMapper {

	//최초 주문 등록
	public void bookPurchase(OrderVO order);
	
	//주문 상세 등록
	public void bookPurchaseDetail(OrderDetailVO order);
	
	//주문한 카트 id 삭제
	public void cartDelete(int cartId);
}
