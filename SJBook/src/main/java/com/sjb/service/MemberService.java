package com.sjb.service;

import com.sjb.model.MemberVO;

public interface MemberService {

	//회원가입
	public void enrollMember(MemberVO member) throws Exception;
	
	public MemberVO memberLogin(MemberVO member) throws Exception;
	
	
	
}
