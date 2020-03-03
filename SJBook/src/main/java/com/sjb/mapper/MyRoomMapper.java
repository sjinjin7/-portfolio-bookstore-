package com.sjb.mapper;

import java.util.List;

import com.sjb.model.Criteria;
import com.sjb.model.OrderDetailVO;
import com.sjb.model.OrderVO;

public interface MyRoomMapper {

	// 주문 목록 리스트
	public List<OrderVO> orderList(String memberId);
	
	//주문 목록 리스트 페이징
	public List<OrderVO> orderListPaging(Criteria cri);

	// 주문 목록 상세
	public List<OrderDetailVO> selectDetail(int orderId);
	
	// 주문 목록 갯수
	public int orderCount(String memberId);
	
}
