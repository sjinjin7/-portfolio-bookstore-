package com.sjb.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.sjb.model.Criteria;
import com.sjb.service.BookService;
import com.sjb.mapper.BookMapper;
import com.sjb.model.BookVO;

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
	
	
	
	
	
	
	
	
	
	
	
	
	
}
