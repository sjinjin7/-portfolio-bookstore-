package com.sjb.service;

import java.util.List;

import com.sjb.model.ReplyCriteria;
import com.sjb.model.ReplyVO;

public interface ReplyService {
	
	//댓글 등록
	public void replyInsert(ReplyVO reply) throws Exception;
	
	//댓글 리스트 페이징
	public List<ReplyVO> replyListPaging(ReplyCriteria cri) throws Exception;
	
	//댓글 삭제 혹은 수정 전 아이디 체크 
	public String replyUserCheck(ReplyVO reply) throws Exception;
	
	//댓글 삭제
	public void replyDelete(ReplyVO reply) throws Exception;
	
	//제품 리뷰 평점 업데이트
	public void replyUpdate(ReplyVO reply) throws Exception;
	
	//댓글 수정
	public void replyModify(ReplyVO reply) throws Exception;

}
