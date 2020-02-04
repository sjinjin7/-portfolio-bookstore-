package com.sjb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjb.mapper.CartMapper;
import com.sjb.model.CartListVO;
import com.sjb.model.CartVO;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartMapper cartmapper;
	
	@Override
	public void cartenroll(CartVO cart) throws Exception {
		
		cartmapper.cartEnroll(cart);
	}

	@Override
	public List<CartListVO> cartList(int productId) throws Exception {
		
		return cartmapper.cartList(productId);
	}

}
