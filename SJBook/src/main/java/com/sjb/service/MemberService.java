package com.sjb.service;

import com.sjb.model.MemberVO;

public interface MemberService {

	//회원가입
	public void enrollMember(MemberVO member) throws Exception;
	//로그인
	public MemberVO memberLogin(MemberVO member) throws Exception;
	//회원정보 가져오기
	public MemberVO importInfo(String memberId) throws Exception;
	// 구매 완료시 session 리셋
	public MemberVO reSession(String memberId) throws Exception;
	
	//아이디 중복체크
	public int idCheck(String memberId) throws Exception;
	
	
	
}
