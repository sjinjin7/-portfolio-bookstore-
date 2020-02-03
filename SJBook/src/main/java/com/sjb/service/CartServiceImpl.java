package com.sjb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjb.mapper.CartMapper;
import com.sjb.model.CartVO;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartMapper cartmapper;
	
	@Override
	public void cartenroll(CartVO cart) throws Exception {
		
		cartmapper.cartEnroll(cart);
	}

}
