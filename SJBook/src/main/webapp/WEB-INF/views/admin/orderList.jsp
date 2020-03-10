<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome! SJBook Store!</title>
<link rel="stylesheet" href="../resources/css/admin/orderList.css">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script src="../resources/js/admin/orderList.js" type="text/javascript"></script>
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
						<li id="main_nav_5"><a href="/admin/orderList">주문 목록</a></li>
					</ul>
				</div>
			</div>
			<!-- 메인  컨텐츠-->
			<div id="main_content_wrap">
				<div id="main_content">
					<div id="main_content_subject">
						<p>주문 목록</p>
					</div>
					
					<div id="main_content_1">
						
						<table>
							<thead>
								<tr>
									<td id="th_orderNum">주문번호</td>
									<td id="th_orderYear">일자</td>
									<td id="th_orderName">고객명</td>
									<td id="th_orderInfo">상품정보</td>
									<td id="th_orderState">상품상태</td>
									<td id="th_orderBtn">비고</td>
								</tr>
							
							</thead>
							<tbody>
								<c:set var="bookAmount" value="0"/>
								<c:forEach items="${list}" var="list">
									<tr>
										<td id="tb_orderNum" class="tb_orderNum">${list.orderId }</td>
										<td id="tb_orderYear" class="tb_orderYear">${list.orderDate }</td>
										<td id="tb_orderName" class="tb_orderName">
											주문자 아이디 : ${list.memberId }
											<br>
											받는 이 : ${list.orderRec }
										</td>
										<td id="tb_orderInfo" class="tb_orderInfo">
											상품명 :<span id="productName${i }"></span>
											(<span id="cnt${i}"></span> 종 /<span id="amount${i}"></span>개)
											<br>
											금액 : <fmt:formatNumber value="${list.totalPrice}" pattern="#,###"/>원
											
											<input type="hidden" id="orderId${i}" value="${list.orderId}">
											<script>
											
											//책 제목, 종류, 갯수
											(function(){
												//alert("연결");
												var orderId = $('#orderId${i}').val();
												//orderId = String(orderId);
												var data = {orderId : orderId}
												$.ajax({
													url : "/myRoom/repOrder",
													type : "post",
													data : data,
													dataType:'json',
													success : function(data){
														console.log(data.productName);
														$('#productName${i}').html(data.productName);
														$('#cnt${i}').html(data.cnt);
														$('#amount${i}').html(data.amount);
														
													}
												});
											})();
											</script>
										</td>
										<td id="tb_orderState" class="tb_orderState">${list.state }</td>
										<td id="tb_orderBtn" class="tb_orderBtn">
											
											
											
											<c:if test="${list.state == '배송완료'}">
												-
											</c:if>
										
											<c:if test="${list.state == '배송준비' }">
												<button id="ship_1${i }" class="ship_1${i }">배송출발</button>	
											</c:if>
											<c:if test="${list.state ==  '배송중' }">
												<button id="ship_2${i }" class="ship_2${i }">배송도착</button>
											</c:if>	
											<input type="hidden" id="orderId${i }" value="${list.orderId}">										
											<script>
											
											//배송출발 버튼
												$('#ship_1${i }').on("click", function(){
													
													var orderId = $('#orderId${i}').val();
													var data = {orderId : orderId}
													$.ajax({
														url : "shipStart",
														type : "post",
														data : data,
														dataType:'json',
														success : function(data){
															location.reload();
														}
													});
												});

												//배송도착 버튼
												$('#ship_2${i }').on("click", function(){
													
													var orderId = $('#orderId${i}').val();
													var data = {orderId : orderId}
													$.ajax({
														url : "shipArrive",
														type : "post",
														data : data,
														dataType:'json',
														success : function(data){
															location.reload();
														}
													});
												});											
											
											</script>
										</td>
									</tr>
								<c:set var="i" value="${i+1 }"/>
								</c:forEach>

							</tbody>
						
						</table>
						
						
					</div>
					<div id="main_content_2">
						<c:if test="${page.prev}">
						    <a href="orderList?pageNum=${page.startPage-1}&amount=${page.cri.amount}">이전</a>
						</c:if>
						<c:forEach var="num" begin="${page.startPage}" end="${page.endPage}" >
						      			<a href="orderList?pageNum=${num}&amount=${page.cri.amount}">${num}</a>
						</c:forEach>
						<c:if test="${page.next}">
						   <a href="orderList?pageNum=${page.endPage+1}&amount=${page.cri.amount}">다음</a>
						</c:if>	
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