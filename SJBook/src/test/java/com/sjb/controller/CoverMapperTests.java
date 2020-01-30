package com.sjb.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sjb.mapper.CoverMapper;
import com.sjb.model.BookCoverVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class CoverMapperTests {

	
	
	@Autowired
		private CoverMapper covermapper;
	
	
	@Test
	public void coverenroll() throws Exception{
		BookCoverVO cover = new BookCoverVO();
		
		cover.setFileName("fileName");
		cover.setProductID(1);
		cover.setUploadPath("uploadPath");
		cover.setUuid("uuuuuuuuuuid");
		
		covermapper.coverEnroll(cover);
		
	}
}
