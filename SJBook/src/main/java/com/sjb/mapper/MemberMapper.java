package com.sjb.mapper;

import com.sjb.model.MemberVO;

public interface MemberMapper {

	// 회원가입
	public void memberEnroll(MemberVO member);
	
	//로그인
	public MemberVO memberLogin(MemberVO member);
	
	
	
}
