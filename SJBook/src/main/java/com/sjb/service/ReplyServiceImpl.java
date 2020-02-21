package com.sjb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjb.mapper.ReplyMapper;
import com.sjb.model.ReplyCriteria;
import com.sjb.model.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	ReplyMapper mapper;
	
	@Override
	public void replyInsert(ReplyVO reply) throws Exception {
		mapper.replyInsert(reply);
		
	}

	@Override
	public List<ReplyVO> replyListPaging(ReplyCriteria cri) throws Exception {
		
		return mapper.replyListPaging(cri);
	}

}
