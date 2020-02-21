package com.sjb.service;

import java.util.List;

import com.sjb.model.ReplyCriteria;
import com.sjb.model.ReplyVO;

public interface ReplyService {
	
	//댓글 등록
	public void replyInsert(ReplyVO reply) throws Exception;
	
	//댓글 리스트 페이징
	public List<ReplyVO> replyListPaging(ReplyCriteria cri) throws Exception;

}
