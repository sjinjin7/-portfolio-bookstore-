package com.sjb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjb.model.Criteria;
import com.sjb.model.MemberVO;
import com.sjb.model.OrderDetailVO;
import com.sjb.model.OrderVO;
import com.sjb.model.PageVO;
import com.sjb.model.RepOrderDTO;
import com.sjb.service.MyRoomService;

@Controller
@RequestMapping("/myRoom")
public class MyRoomController {
	
	
	@Autowired
	private MyRoomService service;
	

	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String mainGET(HttpServletRequest request, Model model) throws Exception{
		System.out.println("마이룸 진입");
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		String memberId = member.getMemberId();
		List<OrderVO> list = service.orderList(memberId);
		model.addAttribute("list", list);
		System.out.println(list.get(0));
		
		
		
		return "/myRoom/main";
	}
	
	@RequestMapping(value="/mainPaging", method=RequestMethod.GET)
	public String mainListGET(Criteria cri,HttpServletRequest request, Model model) throws Exception{
		System.out.println("마이룸 진입");
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		String memberId = member.getMemberId();
		cri.setMemberId(memberId);
		
		int total = service.orderCount(memberId);
		System.out.println(total);
		PageVO pv = new PageVO(cri, total);
		
	
		model.addAttribute("list", service.orderListPaging(cri));
		model.addAttribute("page", pv);
		model.addAttribute("memberId", memberId);
		
		
		
		
		return "/myRoom/main";
	}

	@RequestMapping(value="/repOrder", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<RepOrderDTO> repOrderGET(String orderId) throws Exception{
		System.out.println("orderId = " + orderId);
		int oId = Integer.parseInt(orderId);
		
		List<OrderDetailVO> list = service.selectDetail(oId);
		System.out.println(list);
		
		String productName = list.get(0).getProductName();
		int amount = 0;
		int cnt = list.size();
		
		for(int i = 0; i < list.size();i++) {
			amount += list.get(i).getAmount();
			System.out.println("for amount : " + list.get(i).getAmount());
		}
		System.out.println("amount : " + amount);
		
		
		
		
		RepOrderDTO rep = new RepOrderDTO();
		rep.setProductName(productName);
		rep.setCnt(cnt);
		rep.setAmount(amount);
		
		
		return new ResponseEntity<>(rep, HttpStatus.OK);
		
	}
	
	
	// 구매확정 버튼
	@RequestMapping(value="/shipClear", method=RequestMethod.POST)
	@ResponseBody
	public String shipClearPOST(String orderId) throws Exception{
		String result = "false";
		System.out.println("orderId : " + orderId);
		if(orderId != null) {
			
			service.shipClear(orderId);
			
			
			result = "true";
		}
		
		
		
		return result;
	}
	
	
	
	// 비밀번호 수정 페이지
	@RequestMapping(value="/modify", method = RequestMethod.GET)
	public void modifyGET() throws Exception{
		System.out.println("modifyGET실행");
	}
	
	
	
	// 비밀번호 수정
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public String modifyPOST(String password, HttpServletRequest request) throws Exception{
		
		System.out.println("modifyPOST실행");
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		String memberId = member.getMemberId();
		
		if(memberId != null) {
			
			member.setMemberPw(password);
			
			service.modifyPw(member);
			
		}
		
		return "redirect:/member/logoutMain";
		
	}
	
	
	// 회원 탈퇴 페이지
	@RequestMapping(value="/exit", method = RequestMethod.GET)
	public void exitGET() throws Exception{
		
	}
	
	// 회원 탈퇴 페이지
		@RequestMapping(value="/exit", method = RequestMethod.POST)
		public void exitGET(String memberId) throws Exception{
			
			
			
			
		}
	
	
}
