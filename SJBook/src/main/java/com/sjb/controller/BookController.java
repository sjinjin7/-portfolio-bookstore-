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
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjb.model.BookCoverVO;
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
	
	
	
	
	
	
	
}
