package com.sjb.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjb.model.BookCoverVO;
import com.sjb.model.CartListVO;
import com.sjb.model.CartVO;
import com.sjb.model.Criteria;
import com.sjb.model.MemberVO;
import com.sjb.model.PageVO;
import com.sjb.service.BookService;
import com.sjb.service.CartService;

@Controller
public class BookController {
	
	
	
	@Autowired
	private BookService bookservice;
	
	@Autowired
	private CartService cartservice;

	//private static final Logger log = LoggerFactory.getLogger(BookController.class);
	
	@RequestMapping("/main")
	public void mainGET() throws Exception{
		
	}
	@RequestMapping("/loginMain")
	public void loginGET() throws Exception{
		System.out.println("loginMain");
	}
	
	@RequestMapping("/search")
	public void searchGET(Criteria cri, Model model) throws Exception{
		int total = bookservice.bookCount(cri);
		PageVO pv = new PageVO(cri, total);
		System.out.println("keyword="+cri.getKeyword());
		System.out.println("total = "+total);
		System.out.println("bookservice.bookListPaging()" + bookservice.bookListPaging(cri));
		System.out.println("bookservice.bookListPaging()" + bookservice.bookListPaging(cri));
		model.addAttribute("list",bookservice.bookListPaging(cri));
		model.addAttribute("page", pv);
		
	}
	//게시물 첨부파일 조회 컨트롤러
	@RequestMapping(value="/getBcover", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<BookCoverVO>> getBcover(int productID){
		
		System.out.println("getBcover " + productID);
		
		return new ResponseEntity<>(bookservice.getBCover(productID), HttpStatus.OK);
		
		
	}
	
	@RequestMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> getFile(String fileName){
		
		System.out.println("fileName : " + fileName);
		//logger.info("fileName : " + fileName);
		
		File file = new File("C:\\upload\\"+fileName);
		
		System.out.println("file : " + file);
		//logger.info("file : " + file);
		
		ResponseEntity<byte[]> result = null;
		
		try {
			
			HttpHeaders header = new HttpHeaders();
			
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	@RequestMapping("detail")
	public String detailGET(int num, Model model) throws Exception{
		System.out.println("제품 상세(detailGET....) 실행");
		model.addAttribute("bd", bookservice.bookDetail(num));
		return "detail";
	}
	

	@RequestMapping(value = "addEnroll", method = RequestMethod.POST)
	@ResponseBody 
	public String  addCartPOST(CartVO cart, HttpSession session) throws Exception{
		
		System.out.println("addEnroll 진입");
		
		String result = "false";
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		System.out.println(member);
		
		if(member != null) { 
			cart.setMemberId(member.getMemberId());
			cartservice.cartenroll(cart); 
			result = "true"; 
		}
		/*
		 * 
		 * 
		 * MemberVO member = (MemberVO)session.getAttribute("member");
		 * 
		 * 
		 * 
		 */
		System.out.println(result);
		return result;
	}
	
	@RequestMapping(value = "cart", method = RequestMethod.GET)
	public String cartGET(HttpSession session, Model model) throws Exception{
		MemberVO member = (MemberVO) session.getAttribute("member");
		String memberId = member.getMemberId();
		System.out.println("memberId"+ memberId);
		System.out.println("list" + cartservice.cartList(memberId));
		List<CartListVO> list = cartservice.cartList(memberId);
		model.addAttribute("clist",list);
		
		return "cart";
	}
	
	
	@RequestMapping(value="deleteCart", method = RequestMethod.POST)
	@ResponseBody
	public String deleteCart(HttpSession session, @RequestParam(value="chkbox[]") List<String> chkArr, CartVO cart)throws Exception{
		
		System.out.println("delete cart");
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		String memberId = member.getMemberId();
		
		String result = "0";
		int cartId = 0;
		
		if(member != null) {
			cart.setMemberId(memberId);
			
			for(String i : chkArr) {
				cartId = Integer.parseInt(i);
				cart.setcartId(cartId);
				cartservice.cartDelete(cart);
			}
			result = "1";
		}
		
		
		return result;
	}
	
	@RequestMapping(value="stockChange", method=RequestMethod.POST)
	@ResponseBody
	public String stockChange(HttpSession session,CartVO cart) throws Exception{
		
		System.out.println("Stock Change");
		MemberVO member = (MemberVO)session.getAttribute("member");
		String result = "0";
		
		if(member != null) {
			cartservice.stockChange(cart);
			
			result = "1";
		}
		
		
		return result;
	}
	
	
	
	
	
}
