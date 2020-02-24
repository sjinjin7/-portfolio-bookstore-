<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome! SJBook Store!</title>
<link rel="stylesheet" href="resources/css/main.css">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script src="resources/js/main.js" type="text/javascript"></script>

<link rel="stylesheet" type="text/css" href="resources/css/slick.css"/>
<!-- <link rel="stylesheet" type="text/css" href="resources/css/slick-theme.css"/> -->
<script type="text/javascript" src="resources/js/slick.js"></script>


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
		<div id="top_mini_1">
<%-- 			<ul>
				<li><a href="/buyTest">테스트페이지</li>
				<!-- <li><a href="/purchase/preBuy">테스트페이지</li> -->
				<c:if test="${member.memberAdmin == 1}">
				<li><a href="/admin/list">관리자페이지</li>
				</c:if>
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
				<li><a href="cart">장바구니</a></li>
				<li>고객센터</li>
				<li>주문배송</li>
			</ul> --%>
			<jsp:include page="include/top_mini.jsp">
				<jsp:param name="member" value="${member}" />
			</jsp:include>			
		</div>
	</div>
	
	
	<!-- 상단부(로고, 검색창, 로그인창) -->
	<div id="top">
		<div id="top_1">
			<div id="top_1_logo">
				<div id="top_1_logo_1">
					<a href="main"><img src="resources/img/logo.png"></a>
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
				<jsp:include page="include/top_login.jsp">
					<jsp:param name="member" value="${member}" />
				</jsp:include>	
			</div>
		</div>
	</div>
	
	
	<div id="top_nav">
		<div id="top_nav_1">
			<nav>
				<ul class="domestic"><a href="search" >국내도서</a>
					<div>
						<ul class="search_1">
							<li><a href="#">소설</a></li>
							<li><a href="#">시/에세이</a></li>
							<li><a href="#">경제/경영</a></li>
							<li><a href="#">자기계발</a></li>
							<li><a href="#">인문</a></li>
							<li><a href="#">역사/문화</a></li>
							<li><a href="#">종교</a></li>
							<li><a href="#">정치/사회</a></li>
							<li><a href="#">예술/대중문화</a></li>
							<li><a href="#">과학</a></li>
							<li><a href="#">기술/공학</a></li>
							<li><a href="#">컴퓨터/IT</a></li>
						</ul>
						<ul class="search_2">
							<li><a href="#">유아(0~7세)</a></li>
							<li><a href="#">어린이(초등)</a></li>
							<li><a href="#">어린이전집</a></li>
							<li><a href="#">어린이영어</a></li>
							<li><a href="#">청소년</a></li>
							<li><a href="#">초등참고서</a></li>
							<li><a href="#">중/고등참고서</a></li>
							<li><a href="#">대학교재</a></li>
							<li><a href="#">취업/수험서</a></li>
							<li><a href="#">외국어</a></li>
							<li><a href="#">가정/육아</a></li>
							<li><a href="#">건강</a></li>
						</ul>
						<ul class="search_3">
							<li><a href="#">여행</a></li>
							<li><a href="#">요리</a></li>
							<li><a href="#">취미/실용/스포츠</a></li>
							<li><a href="#">잡지</a></li>
							<li><a href="#">만화</a></li>
						</ul>
					</div>
				</ul>
				<ul class="forgien">외국도서
					<div>
						<p>서비스 준비중입니다.</p>
					</div>
				</ul>
				<ul class="used">중고도서
					<div>
						<p>서비스 준비중입니다.</p>
					</div>
				</ul>
					
			</nav>
		</div>
	</div>
	
		
	<div id="main">
		<div id="main_container">
		
			<div id="main1">
				<div><img src="http://image.kyobobook.co.kr/ink/images/prom/2020/banner/200123/bnN_01.jpg"> </div>
				<div><img src="http://image.kyobobook.co.kr/ink/images/prom/2020/banner/200129/bnG_w01.jpg"> </div>
				<div><img src="http://image.kyobobook.co.kr/ink/images/prom/2020/book/200108_ebs/bnD_w01.jpg"> </div>
				<div><img src="http://image.kyobobook.co.kr/ink/images/prom/2020/banner/200123/bnN_03.jpg"> </div>
				<div><img src="http://image.kyobobook.co.kr/ink/images/prom/2020/banner/200123/bnN_02.jpg"> </div>
				
			</div>
			
			
			<!-- 신간순 -->
			<div id="main2">
				<div id="main2_1">
					<div id="example" class="main2_1_box">
						<div class="main2_1_box_img">
							이미지
						</div>
						<div class="main2_1_box_con">
							책정보
						</div>
					</div>
					<div id="example1" class="main2_1_box">b</div>
					<div id="example2" class="main2_1_box">c</div>
					<div id="example3" class="main2_1_box">d</div>
					<div id="example4" class="main2_1_box">e</div>
					<div id="example5" class="main2_1_box">f</div>
					<div id="example6" class="main2_1_box">g</div>
					<div id="example7" class="main2_1_box">h</div>
					<div class="clearfix"></div>
				</div>
				
			</div>
			
			<!-- 평점순 -->
			<div id="main3">
				<div id="main3_1"></div>
			</div>
			
			
			
			<!-- 사이드광고 -->
			<div id="side_right_ad">
				<jsp:include page="include/rightSideAd.jsp"></jsp:include>
			</div>
			<div id="side_left_ad">
				<jsp:include page="include/leftSideAd.jsp"></jsp:include>
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
				<img src="resources/img/mlogo.png">
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