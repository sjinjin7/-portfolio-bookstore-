package com.sjb.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sjb.mapper.MemberMapper;
import com.sjb.mapper.MyRoomMapper;
import com.sjb.model.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberMapperTest {

	@Autowired
	private MemberMapper membermapper;
	
	private MyRoomMapper roommapper;
	
	/*
	@Test
	public void memberEnroll() throws Exception{
		MemberVO member = new MemberVO();
		member.setMemberId("test1");
		member.setMemberPw("test1");
		member.setMemberEmail("ssss@sss");
		membermapper.memberEnroll(member);
	}
	*/
	
	/*
	@Test
	public void memberLogin() throws Exception{
		MemberVO member = new MemberVO();
		member.setMemberId("admin");
		member.setMemberPw("admin");
		membermapper.memberLogin(member);
		
		
	}
	*/
	
	/*
	@Test
	public void idCheckTest() throws Exception{
		String memberId = "test5";
		membermapper.idCheck(memberId);
		
		
	}
	*/
	
	
	
	
}
