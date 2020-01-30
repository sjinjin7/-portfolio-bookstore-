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

}
