package com.sjb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sjb.mapper.PurchaseMapper;
import com.sjb.model.OrderVO;
@Service
public class PurchaseServiceImpl implements PurchaseService{

	@Autowired
	PurchaseMapper buymapper;
	
	@Transactional
	@Override
	public void bookBuy(OrderVO order) throws Exception {
		System.out.println("서비스진입");
		// 주문 등록
		buymapper.bookPurchase(order);
		System.out.println("주문등록 완료");
		// 주문상세 등록
		order.getoDetail().forEach(attach ->{
			attach.setOrderId(order.getOrderId());
			buymapper.bookPurchaseDetail(attach);
		});
		System.out.println("주문상세 등록 완료");
		System.out.println("cartId  :   "+ order.getCartId().get(0));
		/* System.out.println("cartId  :   "+ order.getCartId().get(1)); */
		System.out.println("memberId  :   "+ order.getmemberId());
		// 장바구니 삭제
		order.getCartId().forEach(cartId ->{
			buymapper.cartDelete(cartId); 
			System.out.println("forEach" + cartId);
		});
		// 주문제품 구입비용 차감
		System.out.println("구입 비용" + order.getTotalPrice());
		buymapper.deductionMoney(order);
		System.out.println("비용 차감 완료");
		// 주문제품 제고 차감
		System.out.println("주문제품 차감 시작");

		order.getoDetail().forEach(attach ->{
			buymapper.deductionStock(attach);
			System.out.println(attach);
		});
		System.out.println("제품 삭제 완료");
		System.out.println("서비스 종료");
		
	}

}
