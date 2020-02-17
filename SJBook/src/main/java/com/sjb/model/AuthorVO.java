package com.sjb.model;

public class AuthorVO {

	private int authorID;
	
	private String authorName;
	
	private String authorIntro;

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

	public String getAuthorIntro() {
		return authorIntro;
	}

	public void setAuthorIntro(String authorIntro) {
		this.authorIntro = authorIntro;
	}

	@Override
	public String toString() {
		return "AuthorVO [authorID=" + authorID + ", authorName=" + authorName + ", authorIntro=" + authorIntro + "]";
	}

	
	
	
	
}
