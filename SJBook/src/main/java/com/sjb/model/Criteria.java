package com.sjb.model;

public class Criteria {
	// 페이지번호
		private int pageNum;
	
	// 한 페이지당 데이터 처리 갯수(10개)
		private int amount;
		
		//검색 키워드
		private String keyword;
		
		//제품 카테고리
		private String cateCode;
		
		// 제품 작가 이름
		private String authorName;
		
		public String getKeyword() {
			return keyword;
		}

		public void setKeyword(String keyword) {
			this.keyword = keyword;
		}

		public Criteria() {// 기본생성자
			this(1,10);
		}
	
		public Criteria(int pageNum, int amount) {// 매개변수 2개인 생성자
			this.pageNum = pageNum;
			this.amount = amount;
		}

		public int getPageNum() {
			return pageNum;
		}

		public void setPageNum(int pageNum) {
			this.pageNum = pageNum;
		}

		public int getAmount() {
			return amount;
		}

		public void setAmount(int amount) {
			this.amount = amount;
		}

		
		
		
		public String getCateCode() {
			return cateCode;
		}

		public void setCateCode(String cateCode) {
			this.cateCode = cateCode;
		}

		public String getAuthorName() {
			return authorName;
		}

		public void setAuthorName(String authorName) {
			this.authorName = authorName;
		}

		@Override
		public String toString() {
			return "Criteria [pageNum=" + pageNum + ", amount=" + amount + ", keyword=" + keyword + ", cateCode="
					+ cateCode + ", authorName=" + authorName + "]";
		}

		
		
}
