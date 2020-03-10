package com.sjb.mapper;

import java.util.List;

import com.sjb.model.BookCoverVO;

public interface CoverMapper {

	// 이미지 정보 등록
	public void coverEnroll(BookCoverVO cover);
	
	// 이미지 정보 삭제
	public void coverDelete(String uuid);
	
	// 이미지 조회
	public List<BookCoverVO> findByProductID(int productID);
	
	// 해당 제품 이미지 전체 삭제
	public void deleteAll(int productID);
}
