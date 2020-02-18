<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
//<link rel="stylesheet" type="text/css" href="../resources/css/detail.css">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script src="../resources/js/detail.js" type="text/javascript"></script>






<style>

table{
	width : 100%;
}
.uploadResult {
	width:100%;
	background-color : gray;
}

.uploadResult ul{
	display:fles;
	fles-flow:row;
	justify-content:center;
	align-items:center;
}
.uploadResult ul li{
	list-style:none;
	padding: 10px;
	align-content: center;
	text-align: center;
}
.uploadResult ul li img{
	width : 150px;
}

.uploadResult ul li span{
	color:white;
}
.bigPictureWrapper{
	position: absolute;
	display: none;
	justify-content: center;
	align-items:center;
	top:0%;
	width:100%;
	height:100%;
	background-color: gray;
	z-index: 100;
	background:rgba(255,255,255,0.5);
}
.bigPicture{
	position: relative;
	display:flex;
	justify-content: center;
	align-items: center;
}
.bigPicture imf{
	width:600px;
}


</style>

</head>
<body>
<h1>detail <%-- ${bd.productID} --%><c:out value="${bd.productID}"/></h1>
<table border="1" width=1000px>
	<tr>
		<td>책이름</td>
		<td>${bd.title}</td>
	</tr>
	<tr>
		<td>출판사</td>
		<td>${bd.publisher}</td>
	</tr>
	<tr>
		<td>작가</td>
		<td>${bd.authorID}</td>
	</tr>	
	<tr>
		<td>카테고리(이미지)</td>
		<td>${bd.cateCode}</td>
	</tr>
	<tr>
		<td>책커버(이미지)</td>
		<td>${bd.bookCover}</td>
	</tr>
	<tr>
		<td>출판년도</td>
		<td>${bd.publeYear}</td>
	</tr>
	<tr>
		<td>책가격</td>
		<td>${bd.bookPrice}</td>
	</tr>
	<tr>
		<td>할인율</td>
		<td>${bd.discountRate}</td>
	</tr>
	<tr>
		<td>책정보</td>
		<td>${bd.bookInfo}</td>
	</tr>
	<tr>
		<td>책컨텐츠</td>
		<td>${bd.contents}</td>
	</tr>
	<tr>
		<td>책소개이미지</td>
		<td>${bd.introImage}</td>
	</tr>
	<tr>
		<td>재고</td>
		<td>${bd.bookStock}</td>
	</tr>
		<tr>
			<td colspan = "2">
				<div class="row">
					<div class="col-lg-12">
						<div class="ppanel panel-default">
							<div class="panel-heading"> File Attach</div>


							<div class='uploadResult'>
							<input type="hidden" value="${bd.productID}">
								<ul>
								
								</ul>
							</div>
						
						</div>	
						<!-- end panel-body -->
					</div>
					<!-- end panel-body -->
				</div>	
				<!-- end panel -->
			</td>
		</tr>	
	<tr>
		<td colspan="2">
			<a href="modify?num=${bd.productID}">수정</a>
			<a href="delete?num=${bd.productID}">삭제</a>
		</td>
	</tr>

</table>
<div class = 'bigPictureWrapper'>
	<div class='bigPicture'>
	</div>
</div>

</body>
</html>