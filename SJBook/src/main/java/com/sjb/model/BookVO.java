package com.sjb.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class BookVO {

	private int productID;
	
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
	
	private MultipartFile filename;

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
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
		//System.out.println("bookPrice1="+bookPrice);
		this.bookPrice = bookPrice;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
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

	public MultipartFile getFilename() {
		return filename;
	}

	public void setFilename(MultipartFile filename) {
		this.filename = filename;
	}

	public int getSellprice() {
		double salePrice = (double)this.bookPrice*(((double)this.discountRate)/100);
		/*System.out.println("aa"+(double)this.bookPrice);
		System.out.println("bb"+((double)this.discountRate)/100);
		System.out.println("세일가격 : " + salePrice);
		System.out.println("bookPrice2===>"+getBookPrice());
		System.out.println(this.bookPrice);
		System.out.println(this.discountRate);*/
		sellprice = this.bookPrice-(int)salePrice;
		return sellprice;
	}

	public void setSellprice(int sellprice) {
		this.sellprice = this.bookPrice;
	}

	@Override
	public String toString() {
		return "BookVO [productID=" + productID + ", title=" + title + ", authorID=" + authorID + ", authorName="
				+ authorName + ", publisher=" + publisher + ", cateCode=" + cateCode + ", cateName=" + cateName
				+ ", bookCover=" + bookCover + ", bCover=" + bCover + ", publeYear=" + publeYear + ", likeStar="
				+ likeStar + ", bookReply=" + bookReply + ", bookPrice=" + bookPrice + ", discountRate=" + discountRate
				+ ", sellprice=" + sellprice + ", bookInfo=" + bookInfo + ", contents=" + contents + ", introImage="
				+ introImage + ", regdate=" + regdate + ", boardRegdate=" + boardRegdate + ", modDate=" + modDate
				+ ", bookStock=" + bookStock + ", filename=" + filename + "]";
	}

	
	
	

	
	

	
}
