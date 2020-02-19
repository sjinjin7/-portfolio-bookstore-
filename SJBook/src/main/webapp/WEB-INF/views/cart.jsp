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
					<a href="/main"><img src="resources/img/logo.png"></a>
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
	
	
	
	<div id="sub_top">
		<div id="sub_top_1">
			<img src="../resources/img/top_cart.PNG">
			<p>장바구니</p>
		</div>
	</div>
	
	
	<div id="nav_main">
		<div id="nav_main_1">
			<div id="nav_main_1_cart">
				<div id="nav_main_1_cart_check" class="allCheck">
					<input type="checkbox" name="allCheck" id="allCheck">전체선택 
					<script>
					//모두체크
					$("#allCheck").click(function(){
						var check = $('#allCheck').prop("checked");
						if(check){
							//alert($('.chkBox').length);
							$(".chkBox").prop("checked", true);
						} else{
							//alert($('.chkBox').length);
							$(".chkBox").prop("checked", false);
						}
					});
					
					
					</script>
				</div>
				<div id="del_btn">
					<button type="button" class="selectDelete_btn">전체삭제</button>
					<script>
						$(".selectDelete_btn").click(function(){
							var confirm_val = confirm("전체 삭제하시겠습니까?");
							
							if(confirm_val){
								var checkArr = new Array();
								$("input[class='chkBox']:checked").each(function(){
									checkArr.push($(this).attr("data-cartId"));
								});//종료 input선택자
								
								$.ajax({
									url : "deleteCart",
									type : "post",
									data : {chkbox : checkArr},
									success : function(result){
										if(result == 1){
											location.href = "cart";	
										} else{
											alert(result);
											alert("삭제 실패")
										}
									}
								});
								
							}//종료 if
						});//종료 click 
					</script>
				</div>
				
				<div id="nav_main_1_cart_info">	
					<table>
						<%-- <c:set var="i" value="0"/>
						<c:forEach items="${clist}" var="cart">
						</c:forEach> --%>
						<thead>
						<tr id="firstrow">
							<td id="c_product_info"colspan="3">상품정보</td>
							<td id="c_price">판매가</td>
							<td id="c_amount">수량</td>
							<td id="c_sum">합계</td>
							<td id="c_selection">선택</td>
						</tr>
						</thead>
						<tbody>
							<c:set var="i" value="0"/>
							<c:set var="priceTotal"  value="0"/>
							<c:set var="bookKinds" value="0"/>
							<c:set var="bookAmount" value="0"/>
							<c:forEach items="${clist}" var="clist">
								<tr>
										<td id="r_cproduct_check">
										<input type="checkbox" id="chkBox${i}" name="chkBox" class="chkBox" data-cartId="${clist.cartId}">
										<input type="hidden" id="cartId${i}" value="${clist.cartId}">
										<input type="hidden" id="point${i}" value="${clist.bookPoint}.">
										체크
										<script>
											$(".chkBox").click(function(){
												$("#allCheck").prop("checked", false);
											});
										</script>
									</td>
									<td id="r_cproduct_image">이미지</td>
									<td id="r_cproduct_info">
										<div class="title">
											<a>
												<span class="category">[${clist.cateName}]</span>
												<strong> ${clist.title} </strong>
											</a>
										</div>
										<div class="author">
											<a>${clist.authorName}</a> 지음 
											<span class="line">|</span>
											<a> ${clist.publisher}</a>
											<span class="line">|</span>
											${clist.publeYear}
										
										</div>
										<div class="likeStar">평점 : ${clist.cateName}</div>
									</td>
									<td id="r_cprice">
										정상가 :  <fmt:formatNumber value="${clist.bookPrice}" pattern="#,###"/> 원  
										<br>
										판매가 :	<fmt:formatNumber value="${clist.discountPrice}" pattern="#,###"/> 원    
										<br>
										포인트 :  <fmt:formatNumber value="${clist.bookPoint}" pattern="#,###"/> 원
									</td>
									<td id="r_camount">수량 : 
										<input type="hidden"value="${clist.cartStock}" maxlength="3" id="origin_qty${i}">
										<div class="qty_change">
											<input type="text" name="qty" value="${clist.cartStock}" maxlength="3" id="qty${i}" class="input_style02" name="cartStock" readonly="readonly">
											<a class="btn_plus" id="btn_plus${i}">수량 더하기</a>
											<a class="btn_minus" id="btn_minus${i}">수량 빼기</a>
										</div>
										<br>
										<div class="change_btn_wrap">
										<button class="change_btn">수량변경</button>
										</div>
										<script>
											$(document).ready(function(){
												//수량변경 버튼
													$('.change_btn').click(function(){
														var cartStock = $("#qty${i}").val();
														var origin = $("origin_#qty${i}").val();
														var cartId = ${clist.cartId};
														if(cartStock != origin){
														
															$.ajax({
																url : "stockChange",
																type : "post",
																data : {cartStock : cartStock, cartId:cartId},
																success : function(result){
																	if(result == 1){
																		location.href = "cart";	
																	} else{
																		alert(result);
																		alert("변경 실패")
																	}
																}
															});
															
															
														}
														
														
														
													});
												
												
												//수량 증가
												$("#btn_plus${i}").on('click', function(e){
													var value = parseInt($('#qty${i}').val());
													value = value + 1;
													$('#qty${i}').val(value);
					
					
												});
												//수량 감소
												$("#btn_minus${i}").on('click', function(e){
													var value = parseInt($('#qty${i}').val());
													value = value - 1;
													if(value <= 0){
														return;
													}
													
													$('#qty${i}').val(value);
					
					
												});	
											});
										
										</script>
									</td>
									<c:set var="clist_sum_price" value="${clist.sellprice * clist.cartStock}" />
									<td id="r_csum">합계 : <fmt:formatNumber value="${clist_sum_price}" pattern="#,###"/></td>
									<td id="r_cselection" class="delete">
										<button type="button" id="delete_btn" class="delete_${i}_btn" data-cartId="${clist.cartId}">선택삭제</button>
										<script>
											$(".delete_${i}_btn").click(function(){
												var confirm_val = confirm("삭제하시겠습니까?");
												
												if(confirm_val){
													var checkArr = new Array();
													
														checkArr.push($(this).attr("data-cartId"));
													
													
													$.ajax({
														url : "deleteCart",
														type : "post",
														data : {chkbox : checkArr},
														success : function(result){
															if(result == 1){
																location.href = "cart";	
															} else{
																alert(result);
																alert("삭제 실패")
															}
														}
													});
												}
												
												
											});
										
										</script>
										
										
									</td>
								</tr>
							<input type="hidden" id="priceTotal${i}" value="${clist_sum_price}">
							<input type="hidden" id="bookAmount${i}" value="${clist.cartStock}">
							
							<c:set var="i" value="${i+1}"></c:set>
							<c:set var="priceTotal"  value="${priceTotal + clist_sum_price}"/>
							<c:set var="bookKinds" value="${bookKinds+1}"/>
							<c:set var="bookAmount" value="${bookAmount + clist.cartStock}"/>
							</c:forEach>
						</tbody>
						
					</table>
				</div>	
			</div>
			<div id="nav_main_1_result">
				<!-- <div id="nav_main_1_result_head">
					<input type="checkbox"><h1>전체선택</h1>
				</div> -->
				<form id="buy_form" method="post">
				<div id="nav_main_1_result_info">
					
					<div id="nav_main_1_result_info_hidden"></div>
					<table>
						<thead>
							<tr>
								<td>상품금액/<span id="bookKinds"></span>종(<span id="bookAmount"></span>개)</td>
								<td>배송비</td>
								<td>결제 예정금액</td>
								<td>적립예정</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td id="result_info_price">
									<h1><span id="priceTotal"></span></h1><h3>원</h3>
								</td>
								<td id="result_info_ship">
									<div id="result_info_ship_wrap">
										
										<div id="result_info_plus">+</div>
										<h1><span id="ship_price"></span></h1>
										<div id="result_info_equal">=</div><h3>원</h3>
									</div>
								</td> <!-- 가격따른 차등 --> 
								<td id="result_info_total">	
									<h1><span id="final_total"></span></h1><h3>원</h3>
								</td>
								<td id="result_info_point">
									
									<h1><span id="expectancy_price"></span></h1><h3>포인트</h3>
								</td>
							</tr>
						</tbody>
						
					</table>
					
				</div>
				</form>
				<div id="nav_main_1_result_btn">
					<a href="javascript:buy_btn();"><strong>결제하기</strong></a>
				</div>
				
			</div>
			<div id="side_right_ad">
				<jsp:include page="include/rightSideAd.jsp"></jsp:include>
			</div>
			<div id="side_left_ad">
				<jsp:include page="include/leftSideAd.jsp"></jsp:include>
			</div>
			
			<script>
								
									//체크 변경시 체크한 것만 종합하기
									
									$("input[type='checkbox']").change(function(){
										//체크박수 갯수
										var totalCount = $('.chkBox').length;
										//가격총합
										var priceTotal = 0;
										//책 종류 수
										var bookKinds = 0;
										//책 총 갯수
										var bookAmount = 0;	
										//배송비
										var shipprice = 0;
										//총가격(제품 + 배송비)
										var total = 0;
										//적립포인트
										var pointTotal = 0;
										//cartlist번호 값을 가진 input생성
										var str = "";
										for(var i = 0; i < totalCount; i++){
											if($("#chkBox"+i).is(":checked")){
												//alert("aaaaaa="+$("#priceTotal"+i).val());
												var cartId = $('#cartId'+i).val();
												var point = 0;
												priceTotal = parseInt(priceTotal) + parseInt($("#priceTotal"+i).val());
												bookKinds = bookKinds + 1;
												bookAmount = parseInt(bookAmount) + parseInt($("#bookAmount"+i).val());
												point = parseInt($("#point"+i).val()) * parseInt($("#bookAmount"+i).val());
												pointTotal = pointTotal + point;
												str += "<input type='hidden' id='hidden_cartId' name='cartId' value='"+cartId+"'>";
											}
										}
										
										//alert("bbbb="+priceTotal);	
 										//alert(bookKinds);
										//alert(bookAmount);
										
										$("#priceTotal").html(priceTotal);
										$("#bookKinds").html(bookKinds);
										$("#bookAmount").html(bookAmount);
										if(priceTotal>=10000){
											shipprice = 0;
											$("#ship_price").html(0);
										} else if(priceTotal == null || priceTotal == 0){
											shipprice = 0;
											$("#ship_price").html(0);
										} else{
											shipprice = 2000;
											$("#ship_price").html(2000);	
										}
										 total = priceTotal + shipprice;
										 $("#final_total").html(total);
										 /* point = priceTotal * 0.05; */
										 $("#expectancy_price").html(pointTotal);
										$("#nav_main_1_result_info_hidden").html(str);
										
									});		
								
								
							
							</script>	
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