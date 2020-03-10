package com.sjb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjb.mapper.MyRoomMapper;
import com.sjb.model.Criteria;
import com.sjb.model.MemberVO;
import com.sjb.model.OrderDetailVO;
import com.sjb.model.OrderVO;

@Service
public class MyRoomServiceImpl implements MyRoomService {

	@Autowired
	private MyRoomMapper mapper;

	//주문 목록 호출
	@Override
	public List<OrderVO> orderList(String memberId) throws Exception {
		return mapper.orderList(memberId);
	}

	// 주문 목록 리스트 페이징 호출
	@Override
	public List<OrderVO> orderListPaging(Criteria cri) throws Exception {
		
		return mapper.orderListPaging(cri);
	}
	
	@Override
	public List<OrderDetailVO> selectDetail(int orderId) throws Exception {
		
		return mapper.selectDetail(orderId);
	}

	@Override
	public int orderCount(String memberId) throws Exception {
		 
		return mapper.orderCount(memberId);
	}

	@Override
	public void shipClear(String orderId) throws Exception {
		mapper.shipClear(orderId);
		
	}

	
	//비밀번호 수정
	@Override
	public void modifyPw(MemberVO member) throws Exception {
		
		mapper.modifyPw(member);
		
	}

	@Override
	public void deleteID(String memberId) throws Exception {
		
		mapper.deleteID(memberId);
		
	}

	
	
	
	
	
	
	
}
