package com.sjb.mapper;

import com.sjb.model.MemberVO;

public interface MemberMapper {

	// 회원가입
	public void memberEnroll(MemberVO member);
	
	//로그인
	public MemberVO memberLogin(MemberVO member);
	
	// 회원정보 가져오기
	public MemberVO importInfo(String memberId);
	
	// 구매완료시 session 리셋
	public MemberVO reSession(String memberId);
	
	
	
}
