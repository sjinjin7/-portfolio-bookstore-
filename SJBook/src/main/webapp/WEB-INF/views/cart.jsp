<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome! SJBook Store!</title>
<link rel="stylesheet" href="resources/css/cart.css">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script src="resources/js/cart.js" type="text/javascript"></script>
</head>
<body>
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
				<div id="top_1_login_button"><a href="loginMain"><h1>SJB로그인</h1></a></div>
			</div>
		</div>
	</div>
	
	
	
	<div id="sub_top">
		<div id="sub_top_1">
			<img src="../resources/img/top_cart.PNG">
		</div>
	</div>
	
	
	<div id="nav_main">
		<div id="nav_main_1">
			<div id="nav_main_1_cart">
				<div id="nav_main_1_cart_check"><input type="checkbox"><h1>SJBook 배송</h1></div>
				<div id="nav_main_1_cart_info">	
					<table>
						<%-- <c:set var="i" value="0"/>
						<c:forEach items="${clist}" var="cart">
						</c:forEach> --%>
						<thead>
						<tr id="firstrow">
							<td id="c_product_info">상품정보</td>
							<td id="c_price">판매가</td>
							<td id="c_amount">수량</td>
							<td id="c_sum">합계</td>
							<td id="c_selection">선택</td>
						</tr>
						</thead>
						<tbody>
						<tr>
							<td id="r_cproduct_info">상품정보</td>
							<td id="r_cprice">판매가</td>
							<td id="r_camount">수량</td>
							<td id="r_csum">합계</td>
							<td id="r_cselection">선택</td>
						</tr>
						</tbody>
						
					</table>
				</div>	
			</div>
			<div><input type="checkbox"><h1>전체선택</h1></div>
			<div>
				<table>
					<tr>
						<td>상품금액</td>
						<td>배송비</td>
						<td>결제 예정금액</td>
						<td>적립예정</td>
					</tr>
					<tr>
						<td>상품금액</td>
						<td>배송비</td>
						<td>결제 예정금액</td>
						<td>적립예정</td>
					</tr>
				</table>
			</div>
			<div>
				<a>결제하기</a>
			</div>
		
			<div id="side_right_ad"><h1>side right 63 362</h1></div>
			<div id="side_left_ad"><h1>side left85 703</h1></div>
		</div>
	</div>
	



		
	<div id="main">
		<div id="main2">
			
		
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
	
	<!-- <div id="side_left_ad"><h1>side left85 703</h1></div> -->
	</div>

	<!-- <div id="side_right_ad"><h1>side right 63 362</h1></div> -->
</body>
</html>