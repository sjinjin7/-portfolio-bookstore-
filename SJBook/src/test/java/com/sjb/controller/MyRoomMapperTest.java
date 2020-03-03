package com.sjb.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sjb.mapper.MyRoomMapper;
import com.sjb.model.Criteria;
import com.sjb.model.OrderVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MyRoomMapperTest {
	
	
	@Autowired
		private MyRoomMapper mapper;
	/*
	@Test
	public void orderListTest() throws Exception{
		String memberId = "test5";
		List<OrderVO> list = mapper.orderList(memberId);
		
	}
*/
	
	/* 주문목록 상세 */
	/*
	@Test
	public void selectDetailTest() throws Exception{
		int orderId = 3;
		List<OrderDetailVO> list = mapper.selectDetail(orderId);
		
		
		
	}
	*/
	
	/* 주문 갯수 */
	/*
	@Test
	public void orderCountTest() throws Exception{
		
		String memberId = "test5";
		mapper.orderCount(memberId);
		
		
	}
	*/
	
	@Test
	public void orderListPagingTest() throws Exception{
		
		Criteria cri = new Criteria();
		cri.setMemberId("test5");
		//String memberId = "test5";
		
		List<OrderVO> list = mapper.orderListPaging(cri);
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
