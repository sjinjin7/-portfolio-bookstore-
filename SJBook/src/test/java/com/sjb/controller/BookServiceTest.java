package com.sjb.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sjb.service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BookServiceTest {

	@Autowired
	private BookService service;
	
	//트랜잭션 테스트
	@Test
	public void bookDelTest() throws Exception{
		int test = 152;
		service.bookDel(test);
		
	}
	
}
