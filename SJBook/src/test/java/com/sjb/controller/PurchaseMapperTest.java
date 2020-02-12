package com.sjb.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sjb.mapper.PurchaseMapper;
import com.sjb.model.OrderDetailVO;
import com.sjb.model.OrderVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class PurchaseMapperTest {

	@Autowired
	private PurchaseMapper pmapper;
	
	/*
	@Test
	public void bookpurchase() throws Exception{
		OrderVO order = new OrderVO();
		
		order.setmemberId("test5");
		order.setOrderRec("김서진");
		order.setMemberAddr1("111-111");
		order.setMemberAddr2("울산광역시");
		order.setMemberAddr3("삼산로 그린컴퓨터 아카데미");
		order.setOrderPhone("010-000-000");
		order.setShipPrice(2000);
		order.setTotalPrice(30000);
		
		pmapper.bookPurchase(order);
		
	}
	*/
	
	/*
	@Test
	public void orderDetail() throws Exception{
		OrderDetailVO detail = new OrderDetailVO();
		detail.setOrderId(3);
		detail.setProductId(8);
		detail.setAmount(1);
		
		pmapper.bookPurchaseDetail(detail);
		
	}
	*/
	/*
	@Test
	public void cartDelete() throws Exception{
		int cartId = 29;
		//String memberId = "test5";
		pmapper.cartDelete(cartId);
	}
	*/
	
	
	
	@Test
	public void deduction() throws Exception{
		OrderVO order = new OrderVO();
		order.setTotalPrice(10000);
		order.setGetPoint(200);
		order.setUsePoint(500);
		order.setmemberId("test5");
		pmapper.deductionMoney(order);
	}
	
	/*
	@Test
	public void dedcutionStock() throws Exception{
		OrderDetailVO detail = new OrderDetailVO();
		detail.setProductId(154);
		detail.setAmount(25);
		pmapper.deductionStock(detail);
		
	}
	*/	
	
	
	
	
}
