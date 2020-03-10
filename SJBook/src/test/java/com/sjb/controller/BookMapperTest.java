package com.sjb.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sjb.mapper.BookMapper;
import com.sjb.model.Criteria;
import com.sjb.model.OrderVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BookMapperTest {

	@Autowired
	private BookMapper bookMapper;
	
	//@Autowired BookService bs;
	
	/*
	@Test
	public void bookList() throws Exception{
		
		List<BookVO> list = bookMapper.bookList();
		
		
	}
	*/
	/*
	@Test
	public void detail() throws Exception{
		BookVO book = bookMapper.bookDetail(1);
		System.out.println("book result" + book.toString() );
		//System.out.println(""+bookMapper.bookDetail(1));
		
	}*/
/*
	@Test
	public void enroll() throws Exception{
		BookVO book = new BookVO();
		
		book.setTitle("테스트책");
		book.setPublisher("테스트출판");
		book.setBookCover("테스트커버");
		book.setPubleYear("2020-01-15");
		book.setBookPrice(30000);
		book.setDiscountRate(30);
		book.setBookInfo("테스트책 정보");
		book.setContents("컨텐츠");
		book.setIntroImage("책 홍보 이미지");
		book.setBookStock(300);
		
		bookMapper.bookEnroll(book);
		
	}
*/	
	/*@Test
	public void intest() throws Exception{
		BookVO book = new BookVO();
		book.setTitle("스프링에서 테스트");
		//book.setPublisher("스프링출판");
		bookMapper.intest(book);
		
	}*/
	/*@Test
	public void modify() throws Exception{
		BookVO book = bookMapper.bookDetail(16);
		book.setBookStock(10);
		bookMapper.bookModify(book);
	}*/
	
	/*
	@Test
	public void listPaging() throws Exception{
		
		Criteria cri = new Criteria();
		
		//cri.setPageNum(3);
		//cri.setAmount(10);
		

		List<BookVO> list = bookMapper.bookListPaging(cri);
		
		
		list.forEach(book->Logger.getLogger(""+book));
	}
	
	
	/*
	@Test
	public void countTest() throws Exception{
		Criteria cri = new Criteria();
		int count = bookMapper.bookCount(cri);
		System.out.println("count : " + count);
	}
	*/
	
	
	/* 작가등록 test */
	/*
	@Test
	public void authorEnrollTest() throws Exception{
		AuthorVO vo = new AuthorVO();
		vo.setAuthorName("스테스트");
		vo.setAuthorIntro("자바에서 테스트");
		bookMapper.authorEnroll(vo);
	}
	*/
	/*
	//작겨명수
	@Test
	public void authorCountTest() throws Exception{
		Criteria vo =  new Criteria();
		bookMapper.authorCount(vo);
		
		
		
	}
	*/
	
	/*
	
	//작가 리스트 페이징
	@Test 
	public void authorListPagingTest() throws Exception{
		Criteria vo =  new Criteria();
		vo.setKeyword("테");
		List<AuthorVO> list = bookMapper.authorListPaging(vo);
		System.out.println(" 페이징 처리 = " +list);
	}
	*/
	
	/*
	//출간일 순 select
	@Test
	public void dateSelectTest() throws Exception{
		List<BookVO> list = bookMapper.dateSelect();
		
	}
	*/
	/*
	//평점 순 select
	@Test
	public void likeSelectTest() throws Exception{
		List<BookVO> list = bookMapper.likeSelect();
	}
	*/
	/*
	//카테고리 페이징 처리
	@Test
	public void catebookList() throws Exception{
		Criteria cri = new Criteria();
		cri.setCateCode("012");
		System.out.println("aaaaa"+cri.getCateCode());
		List<BookVO> list = bookMapper.cateListPaging(cri);
		
		
	}
	*/
	
	
	/*
	//작가 키워드 검색 페이징처리
	
	@Test
	public void authorkeybookList() throws Exception{
		Criteria cri = new Criteria();
		cri.setAuthorName("유시민");
		System.out.println("aaaaaa" + cri.getAuthorName());
		
		
		List<BookVO> list = bookMapper.authorKeyListPaging(cri);
		
		
	}
	*/
	//제품 갯수 테스트
	/*
	@Test
	public void countTest() throws Exception{
		Criteria cri = new Criteria();
		//cri.setKeyword("테스트");
		cri.setCateCode("012");
		//cri.setAuthorName("유시민");
		
		//bookMapper.bookCount(cri);
		bookMapper.cateBookCount(cri);
		//bookMapper.authorBookCount(cri);
	}
	*/
	
	
	//키워드 검색 && 카테고리 필터 갯수 테스트
	/*
	@Test
	public void bookCateCountTest() throws Exception{
		Criteria cri = new Criteria();
		
		cri.setCateCode("012");
		cri.setKeyword("테스트");
		bookMapper.bookCateCount(cri);
		
		
	}
	*/
	
	//관리자페이지 주문 목록 리스트
	/*
	@Test
	public void orderList() throws Exception {
		Criteria cri = new Criteria();
		System.out.println("aaa" + cri);
		List<OrderVO> list = bookMapper.orderList(cri);
	}
*/
	
	// 관리자페이지 주문 목록 리스트
	@Test
	public void orderCount() throws Exception{
		
		
		int count = bookMapper.orderCount();
	}
	
	
	
	
	
	
	
}
