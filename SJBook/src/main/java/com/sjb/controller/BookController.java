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
import com.sjb.model.BookVO;
import com.sjb.model.CartListVO;
import com.sjb.model.CartVO;
import com.sjb.model.Criteria;
import com.sjb.model.MemberVO;
import com.sjb.model.PageVO;
import com.sjb.model.ReplyCriteria;
import com.sjb.model.ReplyVO;
import com.sjb.service.BookService;
import com.sjb.service.CartService;
import com.sjb.service.ReplyService;

@Controller
public class BookController {
	
	
	
	@Autowired
	private BookService bookservice;
	
	@Autowired
	private CartService cartservice;

	@Autowired
	private ReplyService replyservice;
	//private static final Logger log = LoggerFactory.getLogger(BookController.class);
	
	@RequestMapping("/main")
	public void mainGET(Model model) throws Exception{
		model.addAttribute("ds", bookservice.dateSelect());
		model.addAttribute("ls",bookservice.likeSelect());
		
		
		
	}
	@RequestMapping("/loginMain")
	public void loginGET() throws Exception{
		System.out.println("loginMain");
	}
	
	@RequestMapping("/search")
	public void searchGET(Criteria cri, Model model) throws Exception{
		if(cri.getAuthorName() != null && cri.getCateCode() == null && cri.getKeyword() == null) {
			System.out.println("작가 키워드검색");
			int total = bookservice.authorBookCount(cri);
			PageVO pv = new PageVO(cri, total);
			System.out.println("keyword="+cri.getAuthorName());
			System.out.println("total = "+total);

			//검색된것이있는지 판단
			List<BookVO> list = bookservice.authorKeyListPaging(cri);
			System.out.println("list사이즈 : " + list.size());
			model.addAttribute("exist", list.size());
			
			// 페이징 타입 id
				int i = 1;
				model.addAttribute("pagingId", i);
			
			model.addAttribute("list",bookservice.authorKeyListPaging(cri));
			model.addAttribute("page", pv);
			
			
		} else if(cri.getKeyword() != null && cri.getCateCode() != null && cri.getAuthorName() == null) {
			System.out.println("기본 키워드 && 카테고리 필터 검색");
			int total = bookservice.bookCateCount(cri);
			PageVO pv = new PageVO(cri, total);
			System.out.println("keyword="+cri.getKeyword());
			System.out.println("total = "+total);
			
			//검색된것이있는지 판단
			List<BookVO> list = bookservice.bookListPaging(cri);
			System.out.println("list사이즈 : " + list.size());
			model.addAttribute("exist", list.size());
			
			// 페이징 타입 id
				int i = 3;
				model.addAttribute("pagingId", i);
			
			
			model.addAttribute("list",bookservice.bookListPaging(cri));
			model.addAttribute("page", pv);
		}
		else if(cri.getCateCode() != null && cri.getKeyword() == null && cri.getAuthorName() == null) {
			System.out.println("카테고리 리스트페이징");
			System.out.println("작가이름 : " + cri.getAuthorName());
			int total = bookservice.cateBookCount(cri);
			PageVO pv = new PageVO(cri, total);
			System.out.println("keyword="+cri.getCateCode());
			System.out.println("total = "+total);
			//검색된것이있는지 판단
			List<BookVO> list = bookservice.cateListPaging(cri);
			System.out.println("list사이즈 : " + list.size());
			model.addAttribute("exist", list.size());
			
			// 페이징 타입 id
					int i = 2;
					model.addAttribute("pagingId", i);
			
			model.addAttribute("list",bookservice.cateListPaging(cri));
			model.addAttribute("page", pv);
		} else if(cri.getKeyword() != null && cri.getCateCode() == null && cri.getAuthorName() == null ) {
			System.out.println("기본 키워드 검색");
			int total = bookservice.bookCount(cri);
			PageVO pv = new PageVO(cri, total);
			System.out.println("keyword="+cri.getKeyword());
			System.out.println("total = "+total);
			
			//검색된것이있는지 판단
			List<BookVO> list = bookservice.bookListPaging(cri);
			System.out.println("list사이즈 : " + list.size());
			model.addAttribute("exist", list.size());
			
			// 페이징 타입 id
			int i = 0;
			model.addAttribute("pagingId", i);
			
			model.addAttribute("list",bookservice.bookListPaging(cri));
			model.addAttribute("page", pv);
		} 
		
		
		
		
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
	//상품 상세 리뷰(댓글 및 평점)
	@RequestMapping(value="detail/replyList", method = RequestMethod.GET)
	@ResponseBody
	public List<ReplyVO> replyListGET(int productID) throws Exception{
		
		ReplyCriteria cri = new ReplyCriteria();
		cri.setProductID(productID);
		
		List<ReplyVO> list = replyservice.replyListPaging(cri);
		
		return list;
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
	
	
	@RequestMapping("/purchase/preBuy")
	public void testpage() throws Exception{
		
	}
	
	@RequestMapping("/buyTest")
	public void testpage2() throws Exception{
		
	}	
	
	
	
	//댓글삭제
	@RequestMapping(value = "/detail/deleteReply", method = RequestMethod.POST)	
	@ResponseBody
	public String deleteReplyPOST(ReplyVO reply, HttpSession session) throws Exception {
		
		String result = "fail";
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		String memberId =replyservice.replyUserCheck(reply);
		
		System.out.println("memberr id = " + memberId);
		System.out.println("member = " + member );
		System.out.println("시작전");
		
			if(member.getMemberId().equals(memberId)) {
				System.out.println("member.getMemberId().equals(memberId) 진입");
				reply.setMemberID(memberId);
				replyservice.replyDelete(reply);
				
				  result = "success";
			}
		System.out.println("return값 = " + result);
		
		return result;
	}

	//댓글 등록
	@RequestMapping(value="/detail/registReply", method = RequestMethod.POST)
	@ResponseBody
	public void registReplyPOST(ReplyVO reply, HttpSession session) throws Exception{
		
		System.out.println("productID = " + reply.getProductID());
		System.out.println("likeRating = " + reply.getLikeRating());
		System.out.println("repCon = " + reply.getRepCon());
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		reply.setMemberID(member.getMemberId());
		//댓글 등록
		replyservice.replyInsert(reply);
		//  제품 평균 평점 업데이트
		replyservice.replyUpdate(reply);
		
	}
	
	
	@RequestMapping(value="/detail/modifyReply", method = RequestMethod.POST)
	@ResponseBody
	public String modifyReplyPOST(ReplyVO reply, HttpSession session) throws Exception{
		System.out.println("productID " + reply.getProductID());
		
		String result = "false";
		MemberVO member = (MemberVO)session.getAttribute("member");
		String memberId =replyservice.replyUserCheck(reply);
		
		System.out.println("memberr id = " + memberId);
		System.out.println("member = " + member );
		System.out.println("시작전");
		
		if(member.getMemberId().equals(memberId)) {
			System.out.println("member.getMemberId().equals(memberId) 진입");
			reply.setMemberID(memberId);
			//댓글 수정
			replyservice.replyModify(reply);
			// 제품 평균 평점 업데이트
			replyservice.replyUpdate(reply);
			
			  result = "success";
		}
	System.out.println("return값 = " + result);
	
		
		
		
		
		return result;
	}
	
	
	
}
