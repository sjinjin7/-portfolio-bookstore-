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
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<!-- <script src="../resources/js/detail.js" type="text/javascript"></script> -->
</head>
<body>
<%-- <h1>${memberinfo.memberId}</h1> --%>
<div id="wrap">
	<div id="top_mini">
		<div id="top_mini_1">
			<jsp:include page="../include/top_mini.jsp">
				<jsp:param name="member" value="${member}" />
			</jsp:include>
		</div>
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
				<jsp:include page="../include/top_login.jsp">
					<jsp:param name="member" value="${member}" />
				</jsp:include>
			</div>
		</div>
	</div>
	
	
	
	<div id="sub_top">
		<div id="sub_top_1">
			<img src="../resources/img/top_buy.PNG">
			<p>주문/결제</p>
		</div>
	</div>
	
	<div id="main_wrap">
		<form method="post" action="/purchase/buy">
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
								<a class="addr_button1" id="addr_button_save">저장 주소</a>
							</li>
							<li>
								<a class="addr_button2" id="addr_button_insert">직접입력</a>
							</li>
						</ul>				
					</div>
					<div id="main_buy_addr_info1" class="main_buy_addr_info1">
						<div id="main_buy_addr_info1_1">
							받는 사람 : ${memberinfo.memberName} 
							<input type="hidden" name="orderRec" value="${member.memberName }">
						</div>
						<div id="main_buy_addr_info1_2" >
							주소 : (${memberinfo.memberAddr1}) ${memberinfo.memberAddr2} ${memberinfo.memberAddr3}
							<input type="hidden" name="memberAddr1" value="${memberinfo.memberAddr1 }">
							<input type="hidden" name="memberAddr2" value="${memberinfo.memberAddr2 }">
							<input type="hidden" name="memberAddr3" value="${memberinfo.memberAddr3 }"> 
						</div>
						<div id="main_buy_addr_info1_3">
							휴대전화  : ${memberinfo.memberPhone }
							<input type="hidden" name="orderPhone" value="${memberinfo.memberPhone}">
						</div>
						
					</div>
					<div id="main_buy_addr_info2" class="">

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
							<c:set var="i" value="0"/> 
							<!-- 가격 총합 -->
							<c:set var="finalTotalPrice" value="0"/>
							<!-- 받을 예정인 포인트 총합 -->
							<c:set var="finalTotalPoint" value="0"/>
							<c:forEach items="${buylist}" var="list"> 
							<tr>
								<td class="main_list_col1" >
									이미지
								</td>
								<td class="main_list_col2">
									
									${list.title}
									제목						
								</td>
								<td class="main_list_col3">
									<!-- 각 제품의 할인된가격 총합 -->
									<c:set var="discountPrice" value="0"/>
									<!-- 할인된가격 * 수량 -->
									<c:set var="discountPriceStock" value="0"/>
									<!-- 받을 포인트 -->
									<c:set var="point" value="0"/>
									
									<c:set var="discountPrice" value="${list.bookPrice*((100-list.discountRate)/100) } "/>
									<c:set var="discountPriceStock" value="${discountPrice * list.cartStock }"/>
									
									<c:set var="point" value="${list.bookPrice * 0.05 }"/>
									 
									<strong>${discountPriceStock }</strong>원 <span> | </span> 수량 ${list.cartStock}개
									<div>${discountPrice}</div> 
									<div>[ ${list.discountRate} %↓ + ${point}원<span>P</span>]</div>			
									<c:set var="finalTotalPrice" value="${finalTotalPrice + discountPriceStock}"/>
							
									<c:set var="finalTotalPoint" value="${finalTotalPoint + point}"/>				
								</td>
							</tr>
								<input type="hidden" name="oDetail[${i }].productId" value="${list.productId }">
								<input type="hidden" name="oDetail[${i }].amount" value="${list.cartStock }">
								<input type="hidden" name="cartId" value="${list.cartId }">
							<c:set var="i" value="${i+1}"/> 
							</c:forEach>
						</tbody>
					
					</table>
				</div>
				<div id="main_buy_point">
					<h1>할인적립</h1>
					<table>
						<tr>
							<th>사용가능 포인트</th>
							<td>
								<span>${member.point }</span>원
								<input type="hidden" id="ownPoint" value="${member.point }">
								<input id="point_input" type="text" value="0">원
								<a id="point_btn1">모두사용</a>
								<a id="point_btn2">사용취소</a>
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
						<li class="totalPrice">
							<span id="label">상품금액</span> <span id="label_result">${finalTotalPrice}원</span>
							<input type="hidden" id="titalPriceInput"value="${finalTotalPrice }">
							<div class="clearfix"></div> 
						</li>
						<li class="shipPrice">
							<c:if test="${finalTotalPrice >= 10000}">
								<c:set var="shipPrice" value="0"/> 
								<input type="hidden" id="shipPriceInput" value="0">
							</c:if>
							<c:if test="${finalTotalPrice < 10000}">
								<c:set var="shipPrice" value="2000"/>
								<input type="hidden" id="shipPriceInput" value="2000"> 
							</c:if>
						
							<span id="label">배송비</span>  <span id="label_result">${shipPrice}원</span>
							<input type="hidden" name="shipPrice" value="${shipPrice }">
							<div class="clearfix"></div> 
						</li>
						<li class="sale_price">
							<span id="label">할인금액</span>  <span id="label_result"><span id="number"></span>원</span>
							<input type="hidden" id="sale_priceInput" name="usePoint">
							<div class="clearfix"></div> 
						</li>
						<li class="total_li">
							<c:set var="finalTotalPrice" value="${finalTotalPrice+shipPrice }"/>
							<strong id="label">최종 결제금액</strong> <strong id="label_result"><span id="number">${finalTotalPrice}</span>원</strong>
							<fmt:parseNumber value="${finalTotalPrice}" integerOnly="true" var="finalTotalPrice" />
							<input type="hidden" id="totalPrice" name="totalPrice" value="${finalTotalPrice }">
							<div class="clearfix"></div> 
						</li>
					
					</ul>
				</div>
				<div id="final_buy_point">
					<span id="label">적립 예정 포인트</span> :  <span id="label_result"><fmt:formatNumber value="${finalTotalPoint}" pattern="#,###" /></span>
	
				</div>
				<div id="final_buy_check">
					<input type="checkbox">주문내역 확인 동의
				</div>
				<div id="final_buy_button">
					<input type="hidden" name="memberId" value="${member.memberId }">
					<input type="hidden" name="" value="">
					<input type="hidden" name="" value="">
					<input type="hidden" name="" value="">
					<input type="hidden" name="" value="">
					<input type="hidden" name="" value="">
					<input type="hidden" name="" value="">	
					<button>결제하기</button>
				</div>
			</div>
			<div class="clearfix"></div>
			
			
			
		</form>
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

	<div id="save">
		<div id="save1">
						<div id="main_buy_addr_info1_1">
							받는 사람 : ${memberinfo.memberName} 
							<input type="hidden" name="orderRec" value="${member.memberName }">
						</div>
						<div id="main_buy_addr_info1_2">
							주소 : (${memberinfo.memberAddr1}) ${memberinfo.memberAddr2} ${memberinfo.memberAddr3}
							<input type="hidden" name="memberAddr1" value="${memberinfo.memberAddr1 }">
							<input type="hidden" name="memberAddr2" value="${memberinfo.memberAddr2 }">
							<input type="hidden" name="memberAddr3" value="${memberinfo.memberAddr3 }"> 
						</div>
						<div id="main_buy_addr_info1_3">
							휴대전화  : ${memberinfo.memberPhone }
							<input type="hidden" name="orderPhone" value="${memberinfo.memberPhone}">
						</div>		
		</div>
		<div id="save2">
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
									<input type="text" name="orderRec" >
								</td>
							</tr>
							<tr class="receiver_row_phone">
								<th>
									휴대전화
								</th>
								<td>
									<input type="text" name="orderPhone"><!-- -<input type="text">-<input type="text"> -->
								</td>
							</tr>
							<tr class="receiver_row_addr">
								<th>
									주소록
								</th>
								<td>
									<input id="receiver_row_addr_input1" type="text" readonly="readonly" name="memberAddr1"> <a onclick="execPostCode()">주소록</a>
									<br>
									<input id="receiver_row_addr_input2" type="text" readonly="readonly" name="memberAddr2">
									<br>
									<input id="receiver_row_addr_input3" type="text" name="memberAddr3">
								</td>
							</tr>
						</table>		
		</div>
	</div>
</body>
</html>