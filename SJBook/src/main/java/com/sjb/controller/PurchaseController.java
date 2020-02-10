package com.sjb.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sjb.model.CartListVO;
import com.sjb.model.MemberVO;
import com.sjb.service.CartService;
import com.sjb.service.MemberService;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

	@Autowired
	private CartService cartservice;
	
	@Autowired
	private MemberService memberservice;
	
	
	private static final Logger logger = LoggerFactory.getLogger(PurchaseController.class);
	
	@RequestMapping(value="/preBuy", method=RequestMethod.POST)

	public void preBuy(String[] cartId, Model model, HttpSession session) throws Exception{

		System.out.println("preBuy 실행");
		
		MemberVO member = (MemberVO) session.getAttribute("member");
		String memberId = member.getMemberId();
		member = memberservice.importInfo(memberId);
		model.addAttribute("memberinfo",member);
		
		
		List<CartListVO> list = new ArrayList<CartListVO>(); 
		
		
		// 장바구니 목록중 선택한것 가져오기
		for(int i = 0; i<cartId.length ; i++) {
			int id = 0;
			CartListVO cartlist = new CartListVO();
			id = Integer.parseInt(cartId[i]);
			cartlist = cartservice.buyList(id);
			
			list.add(cartlist);
			
		}
		
		if( !list.isEmpty() ) {
		model.addAttribute("buylist",list);
		System.out.println("list성공?>?" + list);
		
		System.out.println(list.get(2));
		}
		
		/*
		System.out.println("for문 건니뜀");
		model.addAttribute("buylist",list);
		System.out.println("list성공?>?" + list);
		System.out.println(list.get(2));
		*/



	}
	
	
	
	
}
