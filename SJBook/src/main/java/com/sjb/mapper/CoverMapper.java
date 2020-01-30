package com.sjb.mapper;

import java.util.List;

import com.sjb.model.BookCoverVO;

public interface CoverMapper {

	public void coverEnroll(BookCoverVO cover);
	
	public void coverDelete(String uuid);
	
	public List<BookCoverVO> findByProductID(int productID);
	
	public void deleteAll(int productID);
}
