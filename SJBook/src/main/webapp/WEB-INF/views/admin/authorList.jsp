<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome! SJBook Store!</title>
<link rel="stylesheet" href="../resources/css/admin/authorList.css">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script src="../resources/js/admin/authorList.js" type="text/javascript"></script>
<script src="../resources/ckeditor/ckeditor.js"></script>




</head>
<body>
<div id="wrap">
	<div id="top_ad">
		<div class="top_ad_right"></div>
		
		<div id="top_ad_img">
			<img src="http://image.kyobobook.co.kr/dwas/images/prom/banner/2020/02/13/bnC_pc_ink_950x65.jpg">
			<button onclick="jQuery('#top_ad').slideUp();"><img src="resources/img/close_button.gif"></button>
		</div>
		
	 
	</div>
	
	
	<div id="top_mini">

	</div>
	
	
	<!-- 상단부(로고, 검색창, 로그인창) -->
	<div id="top">
		<div id="top_1">
			<div id="top_1_logo">
				<div id="top_1_logo_1">
					<a href="/main"><img src="../resources/img/logo.png"></a>
				</div>
			</div>
			<div id="top_1_selection">
				<div id="top_1_selection_1">
					<jsp:include page="../include/searchBox.jsp"></jsp:include>
				</div>
			</div>
			<div id="top_1_login">
				<jsp:include page="../include/top_login.jsp">
					<jsp:param name="member" value="${member}" />
				</jsp:include>	
			</div>
		</div>
	</div>
	<div id="main">
		<div id="main_wrap">
		<div id="main_subject">
			<p>관리자페이지</p>
		</div>
			<!-- 메인 네비게이션 -->
			<div id="main_nav_wrap">
				<div id="main_nav">
					<ul>
						<li id="main_nav_1"><a href="/admin/main">상품 목록</a></li>
						<li id="main_nav_2"><a href="/admin/bookEnroll">상품 등록</a></li>
						<li id="main_nav_3"><a href="/admin/authorList">작가 목록</a></li>
						<li id="main_nav_4"><a href="/admin/authorEnroll">작가 등록</a></li>
						<li id="main_nav_5"><a href="/admin/authorEnroll">주문 목록</a></li>
					</ul>
				</div>
			</div>
			<!-- 메인  컨텐츠-->
			<div id="main_content_wrap">
				<div id="main_content">
					<div id="main_content_subject">
						<p>작가 목록</p>
					</div>
					<div id="main_content_1">
						<table>
							<colgroup>
								<col width="30%">
								<col width="30%">
								<col width="*%">
							</colgroup>
							<thead>
								<tr>
									<td>이미지</td>
									<td>작가</td>
									<td>작가 소개</td>
								</tr>
							</thead>
							<tbody>
								<c:set value="0" var="i"></c:set>
								<c:forEach items="${list}" var="list">
									<tr id="tr_main">
										<td> 서비스 준비중입니다.</td>
										<td><a href="authorDetail?authorID=${list.authorID}">${list.authorName}</a></td>
										<td>
											<div id="td_authorIntro${i}">${list.authorIntro }</div>
											<script>
											 (function(){
												 var str = $("#td_authorIntro${i}").text().substring(0,80);
													$("#td_authorIntro${i}").html(str+"..."); 
											 })();
											</script>
										</td>
									</tr>
								<c:set value="${i+1}" var="i"></c:set>
								</c:forEach>
								<tr>
									<td colspan="3">
										<c:if test="${page.prev}">
							                <a href="/admin/authorList?pageNum=${page.startPage-1}&amount=${page.cri.amount}&keyword=${page.cri.keyword}">이전</a>
							            </c:if>
							            <c:forEach var="num" begin="${page.startPage}" end="${page.endPage}" >
							                  			<a href="/admin/authorList?pageNum=${num}&amount=${page.cri.amount}&keyword=${page.cri.keyword}">${num}</a>
							            </c:forEach>
							            <c:if test="${page.next}">
							               <a href="/admin/authorList?pageNum=${page.endPage+1}&amount=${page.cri.amount}&keyword=${page.cri.keyword}">다음</a>
							            </c:if>
									</td>
								</tr>
							</tbody>
							
						</table>
					</div>
					<!-- 작가검색 -->
					<div id="author_searchBox">
							<form action="/admin/authorList" method="get">				
								
								<div class="author_keyword_box">
									<input type="text" name="keyword" class="author_keyword">
									<input type="submit" value="검색" class="author_key_btn">
								</div>
							</form>
					</div>
				</div>		
			</div>
			<div class="clearfix">
			</div>
		</div>
	</div>
	
		

	
	
	<div id="footer_nav">
		<div id="footer_nav_container">
			<ul>
				<li>회사소개</li>
				<span class="line">|</span>
				<li>이용약관</li>
				<span class="line">|</span>
				<li>고객센터</li>
				<span class="line">|</span>
				<li>광고문의</li>
				<span class="line">|</span>
				<li>채용정보</li>
				<span class="line">|</span>
			</ul>
		</div>
	</div>
	
	<div id="footer">
		<div id="footer_container">
			
			<div id="footer_left">
				<img src="../resources/img/mlogo.png">
			</div>
			<div id="footer_right">
				(주) SJBook  울산광역시 삼산동 그린아카데미  대표이사 : OOO
				<br>
				사업자등록번호 : ooo-oo-ooooo
				<br>
				<strong>대표전화 : oooo-oooo(발신자 부담전화)</strong>
				<br>
				<br>
				COPYRIGHT(C) <strong>SJBook</strong>	ALL RIGHTS RESERVED.
			</div>
			<div class="clearfix"></div>
		</div>
	</div>


	
	
	</div>

	
</body>
</html>