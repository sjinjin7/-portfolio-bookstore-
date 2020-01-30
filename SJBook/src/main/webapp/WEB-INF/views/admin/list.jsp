<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
<h1> booklist</h1>
		<form action="list" method="get" >
            <div class="input-group">
            
            	<input type="hidden" name="pageNum" value="${page.cri.getPageNum()}">
            	<input type="hidden" name="amount" value="${page.cri.getAmount()}">
            
            
              <input type="text" name="keyword"  class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
              <div class="input-group-append">
                
              	<input  type = "submit" value="검색" class="btn btn-primary">
                
              </div>
            </div>
          </form>
 <table border="1">
<c:forEach items="${list}" var="book">
	<tr>
		<td>
			이미지
		</td>
		<td>
			<div><a href="detail?num=${book.productID}">책제목 : ${book.title }</a></div>
			<div>작가</div>
		</td>
		<td>
			<div>평점</div>
			<div>가격</div>
			<div>할인가격</div>
		</td>
		<td>
			<input type="button" value = "수량">
			<input type="button" value = "바로구매">
			<input type="button" value = "장바구니담기">
			<a href="detail?num=${book.productID}">수정</a>
			<a href="delete?num=${book.productID}">삭제</a>
		</td>
	</tr>
</c:forEach>
	<tr>
		<td colspan="4"> 
			<c:if test="${page.prev}">
                <a href="list?pageNum=${page.startPage-1}&amount=${page.cri.amount}&keyword=${page.cri.keyword}">이전</a>
            </c:if>
            <c:forEach var="num" begin="${page.startPage}" end="${page.endPage}" >
                  			<a href="list?pageNum=${num}&amount=${page.cri.amount}&keyword=${page.cri.keyword}">${num}</a>
            </c:forEach>
            <c:if test="${page.next}">
               <a href="list?pageNum=${page.endPage+1}&amount=${page.cri.amount}&keyword=${page.cri.keyword}">다음</a>
            </c:if>
		</td>
	</tr>

	<tr>
		<td colspan="3"><a href="enroll">제품등록</a>
		</td>
	</tr>
</table> 

</body>
</html>