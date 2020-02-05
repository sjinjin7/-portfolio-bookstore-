package com.sjb.mapper;

import java.util.List;

import com.sjb.model.CartVO;
import com.sjb.model.CartListVO;

public interface CartMapper {

	public void cartEnroll(CartVO cart) throws Exception;
	
	public List<CartListVO> cartList(String memberId) throws Exception;
	
	
}
