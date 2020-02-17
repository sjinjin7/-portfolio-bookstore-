<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/admin/authorSearch.css">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script src="../resources/js/admin/authorSearch.js" type="text/javascript"></script>
<script src="../resources/ckeditor/ckeditor.js"></script>
</head>
<body>
<div id="wrap">
	<div id="subject">
		작가 검색
	</div>
	<div id="explan">
		해당 작가 이름을 클릭해주세요.
	</div>
	<table>
		<thead>
			<tr>
				<td>작가Id </td>
				<td>작가 번호</td>
			</tr>
		</thead>
		<tbody>
		<c:set var="i" value="0"/>
		<c:forEach items="${list}" var="list">
			<tr>
				<td>${list.authorID }<input type="hidden" id="authorId${i}" value="${list.authorID }"></td>
				<td><a id="name${i}">${list.authorName }<input type="hidden" id="authorName${i}" value="${list.authorName }"></a></td>
			</tr>
			<script>
				$(document).ready(function(){
					
					$('#name${i}').on("click", function(){
						var id = $('#authorId${i}').val();
						var name = $('#authorName${i}').val();
						$(opener.document).find("#authorId").val(id);
						$(opener.document).find("#authorName").val(name);
						
						window.close();
						
					});
				});
			</script>
		<c:set var="i" value="${i+1}"/>
		</c:forEach>
			<tr>
				<td colspan="2"> 
					<c:if test="${page.prev}">
		                <a href="/admin/authorSearch?pageNum=${page.startPage-1}&amount=${page.cri.amount}&keyword=${page.cri.keyword}">이전</a>
		            </c:if>
		            <c:forEach var="num" begin="${page.startPage}" end="${page.endPage}" >
		                  			<a href="/admin/authorSearch?pageNum=${num}&amount=${page.cri.amount}&keyword=${page.cri.keyword}">${num}</a>
		            </c:forEach>
		            <c:if test="${page.next}">
		               <a href="/admin/authorSearch?pageNum=${page.endPage+1}&amount=${page.cri.amount}&keyword=${page.cri.keyword}">다음</a>
		            </c:if>
				</td>
			</tr>		
		</tbody>
	</table>
	<div id="searchBox">
				<form action="/admin/authorSearch" method="get">				
					
					<div class="keyword_box">
						<input type="text" name="keyword" class="keyword">
						<input type="submit" value="검색" class="key_btn">
					</div>
				
					
				
				
					
				</form>
	
	</div>


</div>



</body>
</html>