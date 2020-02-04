package com.sjb.model;

import java.util.List;

public class CartListVO {

	private int productId;
	
	private String memberId;
	
	private int cartStock;
	
	private String addDate;
	
	private String title;
	
	private int authorID;
	
	private String authorName;
		
	private String publisher;
	
	private String cateCode;
	
	private String cateName;
	
	private String bookCover;
	
	private List<BookCoverVO> bCover;
	
	private String publeYear;
	
	private int likeStar;
	
	private int bookReply;
	
	private int bookPrice;
	
	private int discountRate;
	
	private int sellprice;
	
	private String bookInfo;
	
	private String contents;
	
	private String introImage;
	
	private String regdate;
	
	private String boardRegdate;
	
	private String modDate;
	
	private int bookStock;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getCartStock() {
		return cartStock;
	}

	public void setCartStock(int cartStock) {
		this.cartStock = cartStock;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAuthorID() {
		return authorID;
	}

	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCateCode() {
		return cateCode;
	}

	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getBookCover() {
		return bookCover;
	}

	public void setBookCover(String bookCover) {
		this.bookCover = bookCover;
	}

	public List<BookCoverVO> getbCover() {
		return bCover;
	}

	public void setbCover(List<BookCoverVO> bCover) {
		this.bCover = bCover;
	}

	public String getPubleYear() {
		return publeYear;
	}

	public void setPubleYear(String publeYear) {
		this.publeYear = publeYear;
	}

	public int getLikeStar() {
		return likeStar;
	}

	public void setLikeStar(int likeStar) {
		this.likeStar = likeStar;
	}

	public int getBookReply() {
		return bookReply;
	}

	public void setBookReply(int bookReply) {
		this.bookReply = bookReply;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}

	public int getSellprice() {
		return sellprice;
	}

	public void setSellprice(int sellprice) {
		this.sellprice = sellprice;
	}

	public String getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(String bookInfo) {
		this.bookInfo = bookInfo;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getIntroImage() {
		return introImage;
	}

	public void setIntroImage(String introImage) {
		this.introImage = introImage;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getBoardRegdate() {
		return boardRegdate;
	}

	public void setBoardRegdate(String boardRegdate) {
		this.boardRegdate = boardRegdate;
	}

	public String getModDate() {
		return modDate;
	}

	public void setModDate(String modDate) {
		this.modDate = modDate;
	}

	public int getBookStock() {
		return bookStock;
	}

	public void setBookStock(int bookStock) {
		this.bookStock = bookStock;
	}

	@Override
	public String toString() {
		return "cartListVO [memberId=" + memberId + ", cartStock=" + cartStock + ", addDate=" + addDate + ", productId="
				+ productId + ", title=" + title + ", authorID=" + authorID + ", authorName=" + authorName
				+ ", publisher=" + publisher + ", cateCode=" + cateCode + ", cateName=" + cateName + ", bookCover="
				+ bookCover + ", bCover=" + bCover + ", publeYear=" + publeYear + ", likeStar=" + likeStar
				+ ", bookReply=" + bookReply + ", bookPrice=" + bookPrice + ", discountRate=" + discountRate
				+ ", sellprice=" + sellprice + ", bookInfo=" + bookInfo + ", contents=" + contents + ", introImage="
				+ introImage + ", regdate=" + regdate + ", boardRegdate=" + boardRegdate + ", modDate=" + modDate
				+ ", bookStock=" + bookStock + "]";
	}
	
	
	
	
}
