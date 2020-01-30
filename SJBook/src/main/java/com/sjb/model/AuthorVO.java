package com.sjb.model;

public class AuthorVO {

	private int AuthorID;
	
	private String AuthorName;
	
	private int AuthorProduc;
	
	private String AuthorIntro;

	public int getAuthorID() {
		return AuthorID;
	}

	public void setAuthorID(int authorID) {
		AuthorID = authorID;
	}

	public String getAuthorName() {
		return AuthorName;
	}

	public void setAuthorName(String authorName) {
		AuthorName = authorName;
	}

	public int getAuthorProduc() {
		return AuthorProduc;
	}

	public void setAuthorProduc(int authorProduc) {
		AuthorProduc = authorProduc;
	}

	public String getAuthorIntro() {
		return AuthorIntro;
	}

	public void setAuthorIntro(String authorIntro) {
		AuthorIntro = authorIntro;
	}

	@Override
	public String toString() {
		return "AuthorVO [AuthorID=" + AuthorID + ", AuthorName=" + AuthorName + ", AuthorProduc=" + AuthorProduc
				+ ", AuthorIntro=" + AuthorIntro + "]";
	}
	
	
	
	
}
