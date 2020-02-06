package com.sjb.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sjb.mapper.CartMapper;
import com.sjb.model.CartListVO;
import com.sjb.model.CartVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class CartMapperTest {
	
	@Autowired
		private CartMapper cartmapper;
	/*
	@Test
	public void cartenroll() throws Exception{
		CartVO cart = new CartVO();
		
		cart.setCartStock(3);
		cart.setMemberId("test1");
		cart.setProductId(4);
		
		cartmapper.cartEnroll(cart);
		
		
	}
	*/
	
	/*
	@Test
	public void cartList() throws Exception{
		//CartListVO cart = new CartListVO();
		
		cartmapper.cartList("test1");
		
	}
	*/
	
	@Test
	public void cartDelete() throws Exception{
		CartVO cart = new CartVO();
		cart.setMemberId("test1");
		cart.setcartId(3);
		
		cartmapper.cartDelete(cart);
		
	}
	
	

}
