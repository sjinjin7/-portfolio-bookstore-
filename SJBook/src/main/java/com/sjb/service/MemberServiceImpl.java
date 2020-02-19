package com.sjb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjb.mapper.MemberMapper;
import com.sjb.model.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper membermapper;
	
	
	@Override
	public void enrollMember(MemberVO member) throws Exception {
			
		membermapper.memberEnroll(member);
		
	}

	@Override
	public MemberVO memberLogin(MemberVO member) throws Exception {
		return membermapper.memberLogin(member);
		
	}

	@Override
	public MemberVO importInfo(String memberId) throws Exception {
		 
		return membermapper.importInfo(memberId);
	}

	@Override
	public MemberVO reSession(String memberId) throws Exception {
		// TODO Auto-generated method stub
		return membermapper.reSession(memberId);
	}

}
