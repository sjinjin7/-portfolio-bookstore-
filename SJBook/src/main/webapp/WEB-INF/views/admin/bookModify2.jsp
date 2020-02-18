<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>modify</h1>
<form action="modify?num=${bd.productID}" method="post">

<table border="1" width=1000px>
	<tr>
		<td>책이름</td>
		<td><input type="text" name="title" value="${bd.title}"></td>
	</tr>
	<tr>
		<td>출판사</td>
		<td><input type="text" name="publisher" value="${bd.publisher}"></td>
	</tr>
	<tr>
		<td>작가</td>
		<td><input type="text" name="authorID" value="${bd.authorID}"></td>
	</tr>	
	<tr>
		<td>카테고리(이미지)</td>
		<td><input type="text" name="cateCode" value="${bd.cateCode}"></td>
	</tr>
	<tr>
		<td>책커버(이미지)</td>
		<td><input type="text" name="bookCover" value="${bd.bookCover}"></td>
	</tr>
	<tr>
		<td>출판년도</td>
		<td><input type="text" name="publeYear" value="${bd.publeYear}"></td>
	</tr>
	<tr>
		<td>책가격</td>
		<td><input type="text" name="bookPrice" value="${bd.bookPrice}"></td>
	</tr>
	<tr>
		<td>할인율</td>
		<td><input type="text" name="discountRate" value="${bd.discountRate}"></td>
	</tr>
	<tr>
		<td>책정보</td>
		<td><input type="text" name="bookInfo" value="${bd.bookInfo}"></td>
	</tr>
	<tr>
		<td>책컨텐츠</td>
		<td><input type="text" name="contents" value="${bd.contents}"></td>
	</tr>
	<tr>
		<td>책소개이미지</td>
		<td><input type="text" name="introImage" value="${bd.introImage}"></td>
	</tr>
	<tr>
		<td>재고</td>
		<td><input type="text" name="bookStock" value="${bd.bookStock}"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="수정완료"></td>
	</tr>

</table>
</form>
</body>
</html>