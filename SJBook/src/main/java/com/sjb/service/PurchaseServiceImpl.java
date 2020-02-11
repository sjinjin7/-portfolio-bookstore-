package com.sjb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjb.mapper.PurchaseMapper;
import com.sjb.model.OrderVO;
@Service
public class PurchaseServiceImpl implements PurchaseService{

	@Autowired
	PurchaseMapper buymapper;
	
	@Override
	public void bookBuy(OrderVO order) throws Exception {
		System.out.println("서비스진입");
		buymapper.bookPurchase(order);
		System.out.println("주문등록 완료");
		order.getoDetail().forEach(attach ->{
			attach.setOrderId(order.getOrderId());
			buymapper.bookPurchaseDetail(attach);
		});
		System.out.println("주문상세 등록 완료");
		System.out.println("cartId  :   "+ order.getCartId().get(0));
		System.out.println("cartId  :   "+ order.getCartId().get(1));
		System.out.println("memberId  :   "+ order.getmemberId());
		String memberId = order.getmemberId();
		order.getCartId().forEach(cartId ->{
			buymapper.cartDelete(cartId); 
			
			System.out.println("forEach" + cartId);
			System.out.println(memberId);
			System.out.println(order.getmemberId());
		});
		System.out.println("제품 삭제 완료");
		System.out.println("서비스 종료");
		
	}

}
