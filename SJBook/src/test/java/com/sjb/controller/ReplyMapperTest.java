package com.sjb.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sjb.mapper.ReplyMapper;
import com.sjb.model.ReplyCriteria;
import com.sjb.model.ReplyVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyMapperTest {

	@Autowired
	private ReplyMapper mapper;
	
	
	/*
	@Test
	public void replyInsertTest() throws Exception{
		ReplyVO vo = new ReplyVO();
		vo.setProductID(158);
		vo.setMemberID("test5");
		vo.setLikeRating(3);
		vo.setRepCon("java에서 테스트");
		
		mapper.replyInsert(vo);
		
	}
	*/
	/*
	@Test
	public void replyListPagingTest() throws Exception{
		ReplyCriteria cri = new ReplyCriteria();
		cri.setProductID(158);
		System.out.println("cri = " + cri);
		
		List<ReplyVO> list = mapper.replyListPaging(cri);
		
	}
	*/
	/*
	@Test
	public void replyavg() throws Exception{
		ReplyVO reply = new ReplyVO();
		
		reply.setProductID(173);
		float a = mapper.replyAvg(reply);
		
	}
	*/
	
	/*
	@Test
	public void replyUpdate() throws Exception{
		ReplyVO reply = new ReplyVO();
		reply.setProductID(173);
		reply.setLikeRating((float) 3.5);
		
		mapper.replyUpdate(reply);
		
	}
	*/
	
	@Test
	public void replyVodify() throws Exception{
		ReplyVO reply = new ReplyVO();
		reply.setMemberID("test5");
		reply.setRepNum(2);
		reply.setRepCon("java에서 수정 테스트");
		reply.setLikeRating(3);
		
		mapper.replyModify(reply);
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
