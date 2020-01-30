package com.sjb.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sjb.mapper.MemberMapper;
import com.sjb.model.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberMapperTest {

	@Autowired
	private MemberMapper membermapper;
	
	
	@Test
	public void memberEnroll() throws Exception{
		MemberVO member = new MemberVO();
		member.setMemberId("test1");
		member.setMemberPw("test1");
		member.setMemberEmail("ssss@sss");
		membermapper.memberEnroll(member);
		
		
		
	}
	
}
