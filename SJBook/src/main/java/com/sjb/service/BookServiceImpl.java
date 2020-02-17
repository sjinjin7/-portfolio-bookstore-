package com.sjb.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sjb.controller.AdminController;
import com.sjb.mapper.BookMapper;
import com.sjb.mapper.CoverMapper;
import com.sjb.model.AuthorVO;
import com.sjb.model.BookCoverVO;
import com.sjb.model.BookVO;
import com.sjb.model.Criteria;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookMapper bookmapper;
	
	@Autowired
	CoverMapper covermapper;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Override
	public List<BookVO> bookList() throws Exception{
		
		return bookmapper.bookList();
	}

	@Override
	public List<BookVO> bookListPaging(Criteria cri) throws Exception {
		System.out.println("BookServiceImpl bookListPaging");
		
		return bookmapper.bookListPaging(cri);
	}	
	
	
	@Override
	public BookVO bookDetail(int productID) throws Exception {
		return bookmapper.bookDetail(productID);
	}

	@Transactional
	@Override
	public void bookEnroll(BookVO book) throws Exception {
		bookmapper.bookEnroll(book);
		if(book.getbCover() == null || book.getbCover().size() <=0) {
			return;
		}
		logger.info("등록(service단계)"+book);
		logger.info("등록(service단계)"+book.getProductID());
		book.getbCover().forEach(attach ->{
			attach.setProductID(book.getProductID());
			covermapper.coverEnroll(attach);
		});
		
		
	}

	@Override
	public void bookModify(BookVO book) throws Exception {
		
		bookmapper.bookModify(book);
		
	}
	@Transactional
	@Override
	public void bookDel(int productID) throws Exception {
		bookmapper.bookDel(productID); 
		covermapper.deleteAll(productID);
		
		
	}

	@Override
	public int bookCount(Criteria cri) throws Exception {
		
		return bookmapper.bookCount(cri);
	}

	@Override
	public List<BookCoverVO> getBCover(int productID) {
		logger.info("get BCover list by productID : " + productID);
		return covermapper.findByProductID(productID);
	}

	@Override
	public void authrEnroll(AuthorVO author) throws Exception {
		
		bookmapper.authorEnroll(author);
		
	}



}
