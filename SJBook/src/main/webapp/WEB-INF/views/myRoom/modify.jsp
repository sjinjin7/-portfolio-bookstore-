<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome! SJBook Store!</title>
<link rel="stylesheet" href="../resources/css/myRoom/modify.css">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script src="../resources/js/myRoom/modify.js" type="text/javascript"></script>
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
			<p>마이룸</p>
		</div>
			<!-- 메인 네비게이션 -->
			<div id="main_nav_wrap">
				<div id="main_nav">
					<ul>
						<li id="main_nav_1"><a href="/myRoom/main">주문/배송조회</a></li>
						<li id="main_nav_2"><a href="/myRoom/modify">비밀번호 수정</a></li>
						<!-- <li id="main_nav_3"><a href="/myRoom/exit">회원 탈퇴</a></li> -->
					</ul>
				</div>
			</div>
			<!-- 메인  컨텐츠-->
			<div id="main_content_wrap">
				<div id="main_content">
					<div id="main_content_subject">
						<p>비밀번호 변경</p>
					</div>
					<div id="main_content_1">
						<div id="main_content_1_1">
							<form method="post" id="modify_form">
								<h3> 새로운 비밀번호</h3>
								<div id="top_2_pw"><input type="password" name="password" id="memberPw"></div>
								<span id="top_2_pw_re"></span>
								<span id="final_pw_ck">비멀번호를 입력해주세요.</span>
								<h3>비밀번호 재확인</h3>
								<div id="top_2_pwc"><input type="password" id="memberPw2"></div>
								<span id="top_2_pwc_re">비밀번호가 일치합니다.</span>
								<span id="top_2_pwc_re2">비밀번호가 일치하지 않습니다.</span>
								<span id="final_pwck_ck">비멀번호 제확인을 입력해주세요.</span>								
								<button id="modify_btn">비밀번호 수정</button>
							</form>
						</div>
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