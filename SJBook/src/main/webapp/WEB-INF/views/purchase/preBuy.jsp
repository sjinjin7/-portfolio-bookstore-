<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome! SJBook Store!</title>
<link rel="stylesheet" href="../resources/css/preBuy.css">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script src="../resources/js/preBuy.js" type="text/javascript"></script>

<!-- <script src="../resources/js/detail.js" type="text/javascript"></script> -->
</head>
<body>
<%-- <h1>${memberinfo.memberId}</h1> --%>
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
					<a href="main"><img src="../resources/img/logo.png"></a>
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
				<div id="top_1_login_button"><a href="/loginMain"><h1>SJB로그인</h1></a></div>
			</div>
		</div>
	</div>
	
	
	
	<div id="sub_top">
		<div id="sub_top_1">
			<img src="../resources/img/top_buy.PNG">
		</div>
	</div>
	
	<div id="main_wrap">
		<div id="main_left">
			<div id="mian_buy_info">
				<h1>구매자 정보</h1>
				<table>
					<colgroup>
						<col width = "30%">
						<col width = "*">	
					</colgroup>
					<tr>
						<th id="col1">
							주문자 
						</th>
						<td id="col2">
							${memberinfo.memberName} <span>|</span> ${memberinfo.memberPhone } <span>|</span> ${memberinfo.memberEmail }
						</td>
					</tr>
					
				</table>
			</div>
			<div id="main_buy_addr">
				<h1>배송정보</h1>
				<div id="main_buy_addr_button">
					<ul>
						<li>
							<a class="addr_button1">저장 주소</a>
						</li>
						<li>
							<a class="addr_button2">직접입력</a>
						</li>
					</ul>				
				</div>
				<div id="main_buy_addr_info1">
					<div id="main_buy_addr_info1_1">
						받는 사람 : ${memberinfo.memberName} 
					</div>
					<div id="main_buy_addr_info1_2">
						주소 : (${memberinfo.memberAddr1}) ${memberinfo.memberAddr2} ${memberinfo.memberAddr3} 
					</div>
					<div id="main_buy_addr_info1_3">
						휴대전화  : ${memberinfo.memberPhone }
					</div>
					
				</div>
				<div id="main_buy_addr_info2">
					<table>
						<colgroup>
							<col width="30%">
							<col width="*">
						</colgroup>
						<tr class="receiver_row_name">
							<th>
								받는이
							</th>
							<td>
								<input type="text">
							</td>
						</tr>
						<tr class="receiver_row_phone">
							<th>
								휴대전화
							</th>
							<td>
								<input type="text">-<input type="text">-<input type="text">
							</td>
						</tr>
						<tr class="receiver_row_addr">
							<th>
								주소록
							</th>
							<td>
								<input type="text"> <button>주소록</button>
								<br>
								<input type="text">
								<br>
								<input type="text">
							</td>
						</tr>
					</table>
				</div>
			</div>
			<div id="main_list">
				<h1>주문상품</h1>
				<table>
					<thead>
						<tr id="firstrow">
							<td class="main_list_head_col1" colspan="2">
								상품정보
							</td>
							<td class="main_list_head_col2">
								판매가
							</td>
						</tr>
					</thead>
					<tbody>
						<%-- <c:set var="i" value="0"/> 
						<c:forEach items="${buylist}" var="list"> --%> 
						<tr>
							<td class="main_list_col1" >
								이미지
							</td>
							<td class="main_list_col2">
								<%-- ${list.title} --%>
								제목						
							</td>
							<td class="main_list_col3">
								<strong>18,000</strong>원 <span> | </span> 수량 1개
								<div>18,000원</div>
								<div>[10%↓ +1,000원<span>P</span>]</div>							
							</td>
						</tr>
						<%-- <c:set var="i" value="${i+1}"/> 
						</c:forEach> --%>
					</tbody>
				
				</table>
			</div>
			<div id="main_buy_point">
				<h1>할인적립</h1>
				<table>
					<tr>
						<th>사용가능 포인트</th>
						<td>
							<span>2,170</span>원
							<input type="text">원
							<button>모두사용</button>
							
						</td>
					</tr>
				</table>
			</div>
			<div id="main_buy">
				<h1>결제정보</h1>
			</div>
		
		
		
		</div>
		<div id="main_right">
			<div id="final_buy_info">
				<ul>
					<li>
						상품금액
					</li>
					<li>
						배송비
					</li>
					<li>
						선물포장
					</li>
					<li>
						할인금액
					</li>
					<li>
						최종 결제금액
					</li>
				
				</ul>
			</div>
			<div id="final_buy_point">
				<input type="checkbox">주문내역 확인 동의
			</div>
			<div id="final_buy_button">	
				<button>결제하기</button>
			</div>
		</div>
		<div class="clearfix"></div>
	
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
	
	<!-- <div id="side_left_ad"><h1>side left85 703</h1></div> -->
	</div>

	<!-- <div id="side_right_ad"><h1>side right 63 362</h1></div> -->
</body>
</html>