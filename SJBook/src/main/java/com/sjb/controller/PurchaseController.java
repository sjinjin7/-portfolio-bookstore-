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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sjb.model.CartListVO;
import com.sjb.model.CartVO;
import com.sjb.model.MemberVO;
import com.sjb.model.OrderVO;
import com.sjb.service.CartService;
import com.sjb.service.MemberService;
import com.sjb.service.PurchaseService;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

	@Autowired
	private CartService cartservice;
	
	@Autowired
	private MemberService memberservice;
	
	@Autowired
	private PurchaseService buyservice;
	
	
	private static final Logger logger = LoggerFactory.getLogger(PurchaseController.class);
	// 장바구니 담은후 구매페이지
	@RequestMapping(value="/preBuy", method=RequestMethod.POST)

	public void preBuy(String[] cartId, Model model, HttpSession session) throws Exception{

		System.out.println("preBuy 실행");
		
		MemberVO member = (MemberVO) session.getAttribute("member");
		String memberId = member.getMemberId();
		member = memberservice.importInfo(memberId);
		model.addAttribute("memberinfo",member);
		System.out.println("member : "+member);
		
		
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
		
		}


	}
	
	//상품 한개  바로 구매페이지
	@RequestMapping(value="/preOneBuy", method=RequestMethod.POST)
	public String preOneBuy(CartVO cart, Model model, HttpSession session, RedirectAttributes rttr) throws Exception{
		
	
		
		//회원정보 가져오기
		MemberVO member = (MemberVO)session.getAttribute("member");
		System.out.println(cart);
		
		//회원정보 없을시 반환
		if(member == null) {
			//model.addAttribute("buyFail", "fail");
			rttr.addFlashAttribute("buyFail", "1");
			return "redirect:/detail?num="+cart.getProductId();
		}
		
		
		System.out.println(member);
		String memberId = member.getMemberId();
		member = memberservice.importInfo(memberId);
		model.addAttribute("memberinfo",member);
		
		//카트 담기
		if(member != null) { 
			cart.setMemberId(member.getMemberId());
			cartservice.cartenroll(cart); 
		}
		System.out.println(cart);
		
		List<CartListVO> list = new ArrayList<CartListVO>(); 
		
		int[] cartId = new int[1];
		cartId[0] = cart.getcartId();
		System.out.println(cartId[0]);
		
		//카트 리스트 정보 가져오기
		for(int i = 0; i<cartId.length ; i++) {
			int id = 0;
			CartListVO cartlist = new CartListVO();
			id = cartId[i];
			cartlist = cartservice.buyList(id);
			
			list.add(cartlist);
			
		}
		
		if( !list.isEmpty() ) {
		model.addAttribute("buylist",list);
		System.out.println("list성공?>?" + list);
		
		}
		
		System.out.println("삭제전");
		cartservice.cartDelete(cart);
		System.out.println("삭제후");
		
		
		
		
		return "/purchase/preBuy";
		
	}
	
	
	
	
	@RequestMapping(value="/buy", method=RequestMethod.POST)
	public void bookBuy(OrderVO order,Model model) throws Exception{
		System.out.println("데이터진입");
		System.out.println(order);
		//System.out.println(order.getoDetail().get(0));
		String memberId;
		
		if(order.getoDetail() != null) {
			order.getoDetail().forEach(attach -> logger.info(""+attach));
			order.getCartId().forEach(cart -> logger.info(""+ cart));
			//logger.info("book.getbCover()"+book.getbCover());
			//System.out.println("book.getbCover()"+book.getbCover());
			buyservice.bookBuy(order);
			memberId = order.getmemberId();
			model.addAttribute("memberId", memberId);
		}
		
		/* return "redirect:/main"; */
	}
	
	
	
	
}
