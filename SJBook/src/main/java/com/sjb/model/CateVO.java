package com.sjb.model;

public class CateVO {

	private String CateCode;
	
	private String CateName;

	public String getCateCode() {
		return CateCode;
	}

	public void setCateCode(String cateCode) {
		CateCode = cateCode;
	}

	public String getCateName() {
		return CateName;
	}

	public void setCateName(String cateName) {
		CateName = cateName;
	}

	@Override
	public String toString() {
		return "CateVO [CateCode=" + CateCode + ", CateName=" + CateName + "]";
	}
	
	
	
}
