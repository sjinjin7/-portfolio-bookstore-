<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome! SJBook Store!</title>
<link rel="stylesheet" href="resources/css/detail.css">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script src="resources/js/search.js" type="text/javascript"></script>
</head>
<body>

<%-- <h1>${bd.title}</h1> --%>

<div id="wrap">
	<div id="top_mini">
		<div id="top_mini_1">
			<ul>
				<c:if test="${member != null}">
				<li><strong>${member.memberName}</strong>님 환영합니다</li>
				<li><a id="logout">로그아웃</a></li>
				<script>
						$(document).ready(function(){
							$("#logout").click(function(){
								$.ajax({
									type:"POST",
									url : "member/logout",
									success:function(data){
										alert("로그아웃 되었습니다.");
										document.location.reload();
									}
								});//ajax 끝
							});//function 끝
						});
				</script>
				</c:if>
				<c:if test="${member == null}">
				<li>로그인</li>
				</c:if>
				<li>장바구니</li>
				<li>고객센터</li>
				<li>주문배송</li>
			</ul>
		</div>
	</div>
	<!-- 상단부(로고, 검색창, 로그인창) -->
	<div id="top">
		<div id="top_1">
			<div id="top_1_logo">
				<div id="top_1_logo_1">
					<img src="resources/img/logo.png">
				</div>
			</div>
			<div id="top_1_selection">
				<div id="top_1_selection_1">
					<form action="search" method="get">				
					<div id="top_1_selection_1_search">
						
							<%-- <input type="hidden" name="pageNum" value="${page.cri.getPageNum()}">
            				<input type="hidden" name="amount" value="${page.cri.getAmount()}"> --%>
							<div class="keyword_box">
								<input type="text" name="keyword" class="keyword">
							</div>
						
							<input type="submit" value="검색" class="key_btn">
						
						<div class="clearfix"></div>
					</div>
					</form>
				</div>
			</div>
			<div id="top_1_login">
				<div id="top_1_login_button"><a href="loginMain"><h1>SJB로그인</h1></a></div>
			</div>
		</div>
	</div>
	
	
	
	<div id="sub_top">
		<div id="sub_top_1">
			<div id="sub_top_1_ad">
			광고
			</div>
		</div>
	</div>
	
	
	<div id="detail_middle">
		<div id="detail_middle_container">
			
			<div id="cover">
				<div id="image">
					이미지
				</div>
				확대하기
			</div>
			<div id="title"> 책제목</div>	
			<div id="purchase">구매관련</div>
		</div>
	</div>
	



		
	<div id="detail_main">
		<div id="detail_main_container">
			<table>
				<tr>
					<td>평점</td><td>리뷰</td>
				</tr>
			</table>
			<div id="book_intro">책소개</div>
			<div id="author_intro">작가소개</div>
		</div>
	</div>
	
	<div id="detail_reply">
		<div id="detail_reply_container">
			<table>
				<tr>
					<td>평점</td><td>리뷰</td>
				</tr>
			</table>
			<div id="book_reply">댓글</div>
		</div>
	</div>
	
	
	
	<div id="footer"><h1>footer</h1></div>


	
	<div id="side_left_ad"><h1>side left85 703</h1></div>
	</div>

	<div id="side_right_ad"><h1>side right 63 362</h1></div>
</body>
</html>