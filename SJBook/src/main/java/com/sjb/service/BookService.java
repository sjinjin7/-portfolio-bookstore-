package com.sjb.service;

import java.util.List;

import com.sjb.model.BookCoverVO;
import com.sjb.model.BookVO;
import com.sjb.model.Criteria;

public interface BookService {

	
	public List<BookVO> bookList() throws Exception;
	
	public List<BookVO> bookListPaging(Criteria cri) throws Exception;
	
	
	public BookVO bookDetail(int productID) throws Exception;
	
	
	public void bookEnroll(BookVO book) throws Exception;
	
	public void bookModify(BookVO book) throws Exception;
	
	public void bookDel(int productID) throws Exception;
	
	public int bookCount(Criteria cri) throws Exception;
	
	//첨부파일 productID알아내기
	public List<BookCoverVO> getBCover(int productID);
	
}
