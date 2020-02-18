package com.sjb.model;

public class BookCoverVO {

	//파일이름
	private String fileName;
	//파일 업로드 겨올
	private String uploadPath;
	//uuid
	private String uuid;
	// 이미지 유무
	private boolean image;
	// 제품번호
	private int productID;
	// 기존저장되어있는 저장물인지 판단 (1 기존 0 새로운)
	private int judgment;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public boolean isImage() {
		return image;
	}
	public void setImage(boolean image) {
		System.out.println("BoardConverVO image="+image);
		this.image = image;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getJudgment() {
		return judgment;
	}
	public void setJudgment(int judgment) {
		this.judgment = judgment;
	}
	@Override
	public String toString() {
		return "BookCoverVO [fileName=" + fileName + ", uploadPath=" + uploadPath + ", uuid=" + uuid + ", image="
				+ image + ", productID=" + productID + ", judgment=" + judgment + "]";
	}
	
	
}
