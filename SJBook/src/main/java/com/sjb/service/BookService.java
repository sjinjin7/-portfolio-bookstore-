package com.sjb.service;

import java.util.List;

import com.sjb.model.AuthorVO;
import com.sjb.model.BookCoverVO;
import com.sjb.model.BookVO;
import com.sjb.model.Criteria;
import com.sjb.model.OrderVO;

public interface BookService {

	
	public List<BookVO> bookList() throws Exception;
	
	// 책제목 키워드 검색 리스트 페이징
	public List<BookVO> bookListPaging(Criteria cri) throws Exception;
	
	// 카테고리별 검색 리스트 페이징
	public List<BookVO> cateListPaging(Criteria cri) throws Exception;
	
	//작가 키워드 리스트 페이징
	public List<BookVO> authorKeyListPaging(Criteria cri) throws Exception;
	
	// 제품(책) 상세 페이지
	public BookVO bookDetail(int productID) throws Exception;
	
	// 제품(책)등록 
	public void bookEnroll(BookVO book) throws Exception;
	
	// 제품(책) 정보 수정
	public void bookModify(BookVO book) throws Exception;
	
	// 제품(책) 삭제
	public void bookDel(int productID) throws Exception;
	
	//(키워드 검색)제품 갯수
	public int bookCount(Criteria cri) throws Exception;
	
	//카테고리별 제품 갯수
	public int cateBookCount(Criteria cri) throws Exception;
	
	// 작가 키워드 검색 제품 갯수
	public int authorBookCount(Criteria cri) throws Exception;
	
	// 키워드 검색 && 카테고리 필터 갯수
	public int bookCateCount(Criteria cri) throws Exception;
	
	//첨부파일 productID알아내기
	public List<BookCoverVO> getBCover(int productID);
	
	//작가등록
	public void authrEnroll(AuthorVO author) throws Exception;

	//작가수
	public int authorCount(Criteria cri) throws Exception;
	
	//작가 리스트 페이징
	public List<AuthorVO> authorListPaging(Criteria cri) throws Exception;
	
	//수정페이지에서 업로드물 삭제
	public void modifyDeleteFile(String uuid);
	
	//작가 상세
	public AuthorVO authorDetail(int authorID) throws Exception;
	
	//작가 수정
	public void authorModify(AuthorVO author) throws Exception;
	
	//작가 삭재ㅔ
	public void authorDel(int authorID) throws Exception;
	
	//출간일 순 select
	public List<BookVO> dateSelect() throws Exception;
	
	//평점 순 select
	public List<BookVO> likeSelect() throws Exception;
	
	// 주문 목록 리스트
	public List<OrderVO> orderList(Criteria cri) throws Exception;
	
	// 주문 목록 갯수
	public int orderCount(Criteria cri) throws Exception;
	
	// 배송 출발 버튼
	public void shipStart(String orderId) throws Exception;

	// 배송 ehckr 버튼
	public void shipArrive(String orderId) throws Exception;
}
