<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script src="../resources/js/enroll.js" type="text/javascript"></script>
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
<h1>Enroll</h1>

<form action="enroll" method="post">
	<table>
		<tr>
			<td colspan="2">제품등록</td>
		</tr>
		<tr>
			<td>책제목</td>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<td>출판사</td>
			<td><input type="text" name="publisher"></td>
		</tr>
		<tr>
			<td>작가</td>
			<td><input type="text" name="authorID"></td>
		</tr>
		<tr>
			<td>카테고리</td>
			<td><input type="text" name="cateCode"></td>
		</tr>
		<tr>
			<td>책커버(이미지)</td>
			<td><input type="text" name="bookCover"></td>
		</tr>
		<tr>
			<td>출판일</td>
			<td><input type="text" name="publeYear"></td>
		</tr>
		<tr>
			<td>책가격</td>
			<td><input type="text" name="bookPrice"></td>
		</tr>
		<tr>
			<td>할인율</td>
			<td><input type="text" name="discountRate"></td>
		</tr>
		<tr>
			<td>책정보</td>
			<td><input type="text" name="bookInfo"></td>
		</tr>
		<tr>
			<td>책내용</td>
			<td><input type="text" name="contents"></td>
		</tr>
		<tr>
			<td>책소개 이미지</td>
			<td><input type="text" name="introImage"></td>
		</tr>
		<tr>
			<td>책 재고</td>
			<td><input type="text" name="bookStock"></td>
		</tr>
		<tr>
			<td colspan = "2">책커버(이미지)</td>
		</tr>
		<tr>
			<td colspan = "2">
				<div class="row">
					<div class="col-lg-12">
						<div class="ppanel panel-default">
							<div class="panel-heading"> File Attach</div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<input type="file" name='uploadFile' multiple>
							</div>
							<div class='uploadResult'>
								<ul>
								
								</ul>
								<div class="clearfix"></div>
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
			<td colspan="2"><input type="submit" value="등록"></td>
		</tr>
	
	
	</table>
</form>	
</body>
</html>