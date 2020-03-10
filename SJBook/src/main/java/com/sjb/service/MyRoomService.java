package com.sjb.service;

import java.util.List;

import com.sjb.model.Criteria;
import com.sjb.model.MemberVO;
import com.sjb.model.OrderDetailVO;
import com.sjb.model.OrderVO;

public interface MyRoomService {

	// 주문 목록 호출
	public List<OrderVO> orderList(String memberId) throws Exception;
	
	// 주문 목록 호출 페이징
	public List<OrderVO> orderListPaging(Criteria cri) throws Exception;

	// 주문 목록 상세
	public List<OrderDetailVO> selectDetail(int orderId) throws Exception;
	
	// 주문 목록 갯수
	public int orderCount(String memberId) throws Exception;
	
	// 구매 확정 버튼
	public void shipClear(String orderId) throws Exception;
	
	// 비밀번호 수정
	public void modifyPw(MemberVO member) throws Exception;
	
	// 회원 탈퇴
	public void deleteID(String memberId) throws Exception;
	
}
