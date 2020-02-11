package com.sjb.service;

import java.util.List;

import com.sjb.model.OrderVO;

public interface PurchaseService {

	// 주문 등록
	public void bookBuy(OrderVO order) throws Exception;

	
	
}
