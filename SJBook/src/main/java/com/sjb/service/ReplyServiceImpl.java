package com.sjb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	public String replyUserCheck(ReplyVO reply) throws Exception {
		
		return mapper.replyUserCheck(reply);
	}

	@Override
	public void replyDelete(ReplyVO reply) throws Exception {
		mapper.replyDelete(reply);
		
	}
	@Transactional
	@Override
	public void replyUpdate(ReplyVO reply) throws Exception {
		float avg = mapper.replyAvg(reply);
		System.out.println("평균 완료");
		reply.setLikeRating(avg);
		System.out.println("평균reply집어넣기 완료");
		mapper.replyUpdate(reply);
		System.out.println("업데이트 완료");
	}

	@Override
	public void replyModify(ReplyVO reply) throws Exception {
		
		mapper.replyModify(reply);
		
	}

}
