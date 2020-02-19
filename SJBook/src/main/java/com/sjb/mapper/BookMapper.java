package com.sjb.mapper;

import java.util.List;

import com.sjb.model.AuthorVO;
import com.sjb.model.BookVO;
import com.sjb.model.Criteria;

public interface BookMapper {

	// 전체 제품 리스트
	public List<BookVO> bookList();	

	// 전체 제품 리스트(페이징처리)
	public List<BookVO> bookListPaging(Criteria cri) throws Exception;
	
	// 제품 상세
	public BookVO bookDetail(int productID) throws Exception;
	
	// 제품 등록
	public void bookEnroll(BookVO book) throws Exception;
	
	// insert테스트
	public void intest(BookVO book) throws Exception;
	
	// 제품 등록 수정
	public void bookModify(BookVO book) throws Exception;
	
	// 제품 글 삭제
	public void bookDel(int productID) throws Exception;
	
	// 제품 갯수
	public int bookCount(Criteria cri) throws Exception; 
	
	//작가등록
	public void authorEnroll(AuthorVO author) throws Exception;
	
	// 작가 명수
	public int authorCount(Criteria cri) throws Exception;
	
	//작가 리스트(페이징처리)
	public List<AuthorVO> authorListPaging(Criteria cri) throws Exception;
	
	//작가 상세
	public AuthorVO authorDetail(int authorID) throws Exception;
	
	//작가 수정
	public void authorModify(AuthorVO author) throws Exception;
	
	//작가 삭제
	public void authorDel(int authorID) throws Exception;
	
	
}
