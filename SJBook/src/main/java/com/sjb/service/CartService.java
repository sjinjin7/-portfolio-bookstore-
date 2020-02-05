package com.sjb.service;

import java.util.List;

import com.sjb.model.CartListVO;
import com.sjb.model.CartVO;

public interface CartService {

	// 장바구니 등록
	public void cartenroll(CartVO cart) throws Exception;
	
	// 장바구니 리스트
	public List<CartListVO> cartList(String memberId) throws Exception;
}
