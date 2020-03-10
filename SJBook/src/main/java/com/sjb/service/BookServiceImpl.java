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
import com.sjb.model.OrderVO;

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
	
	
	// 제품 정보 수정
	@Transactional
	@Override
	public void bookModify(BookVO book) throws Exception {
		
		bookmapper.bookModify(book);
		
		if(book.getbCover() !=null){
			
			book.getbCover().forEach(attach ->{
				
				// 1일 경우 새로운 파일 따라서 데이터베이스에 등록 실행
				if(attach.getJudgment() == 1) {
					
				attach.setProductID(book.getProductID());
				
				covermapper.coverEnroll(attach);
				
				}
				
			}); // forEach문 종료
			
		} // if 문 종료
		
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

	// 이미지 정보 가져오기
	@Override
	public List<BookCoverVO> getBCover(int productID) {
		
		logger.info("get BCover list by productID : " + productID);
		
		return covermapper.findByProductID(productID);
		
	}

	@Override
	public void authrEnroll(AuthorVO author) throws Exception {
		
		bookmapper.authorEnroll(author);
		
	}

	@Override
	public int authorCount(Criteria cri) throws Exception {
		
		return bookmapper.authorCount(cri);
	}

	// 작가목록 리스트페이징 팝업창
	@Override
	public List<AuthorVO> authorListPaging(Criteria cri) throws Exception {
		
		return bookmapper.authorListPaging(cri);
	}
	
	//수정페이지 업로드물 삭제
	@Override
	public void modifyDeleteFile(String uuid) {
		
		covermapper.coverDelete(uuid);
		
	}

	@Override
	public AuthorVO authorDetail(int authorID) throws Exception {
		
		return bookmapper.authorDetail(authorID);
	}

	
	@Override
	public void authorModify(AuthorVO author) throws Exception{
		bookmapper.authorModify(author);
	}

	@Override
	public void authorDel(int authorID) throws Exception {
		bookmapper.authorDel(authorID);
		
	}

	//출간일순 select
	@Override
	public List<BookVO> dateSelect() throws Exception {
		
		return bookmapper.dateSelect();
	}

	// 평점 순 select
	@Override
	public List<BookVO> likeSelect() throws Exception {
		// TODO Auto-generated method stub
		return bookmapper.likeSelect();
	}

	@Override
	public List<BookVO> cateListPaging(Criteria cri) throws Exception {
		
		return bookmapper.cateListPaging(cri);
	}

	@Override
	public List<BookVO> authorKeyListPaging(Criteria cri) throws Exception {
		
		return bookmapper.authorKeyListPaging(cri);
	}

	@Override
	public int cateBookCount(Criteria cri) throws Exception {
		
		return bookmapper.cateBookCount(cri);
		
	}

	@Override
	public int authorBookCount(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return bookmapper.authorBookCount(cri);
	}

	@Override
	public int bookCateCount(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return bookmapper.bookCateCount(cri);
	}

	@Override
	public List<OrderVO> orderList(Criteria cri) throws Exception {
		
		return bookmapper.orderList(cri);
	}

	@Override
	public int orderCount(Criteria cri) throws Exception {
		 
		return bookmapper.orderCount();
	}

	@Override
	public void shipStart(String orderId) throws Exception {
		
		bookmapper.shipStart(orderId);
		
	}

	@Override
	public void shipArrive(String orderId) throws Exception {
		bookmapper.shipArrive(orderId);
		
	}


}
