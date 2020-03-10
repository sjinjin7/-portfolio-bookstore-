<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome! SJBook Store!</title>
<link rel="stylesheet" href="resources/css/search.css">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script src="resources/js/search.js" type="text/javascript"></script>
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
					<a href="main"><img src="resources/img/logo.png"></a>
				</div>
			</div>
			<div id="top_1_selection">
				<div id="top_1_selection_1">
					<jsp:include page="include/searchBox.jsp"></jsp:include>
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
			<div id="sub_top_1_ad">
			광고
			</div>
		</div>
	</div>
	
	
	<div id="nav_main">
		<div id="nav_main_1">
			<!-- <div id="nav_main_1_box"> -->
			<c:if test="${pagingId != 1 }">
				<table>
					<tr>
						<th class="col1">
							카테고리
							<a class="open">▽</a>
							<a class="opened">△</a>
						</th>
						<td class="col2">
							<a href="/search?keyword=${page.cri.keyword}&cateCode=001">소설</a>
							<a href="/search?keyword=${page.cri.keyword}&cateCode=002">시/에세이</a>
							<a href="/search?keyword=${page.cri.keyword}&cateCode=003">경제/경영</a>
							<a href="/search?keyword=${page.cri.keyword}&cateCode=004">자기계발</a>
							<a href="/search?keyword=${page.cri.keyword}&cateCode=005">인문</a>
							<a href="/search?keyword=${page.cri.keyword}&cateCode=006">역사/문화</a>
							<a href="/search?keyword=${page.cri.keyword}&cateCode=007">종교</a>
							<a href="/search?keyword=${page.cri.keyword}&cateCode=008">정치/사회</a>
							<a href="/search?keyword=${page.cri.keyword}&cateCode=009">예술/대중문화</a>
							<a href="/search?keyword=${page.cri.keyword}&cateCode=010">과학</a>
							<a href="/search?keyword=${page.cri.keyword}&cateCode=011">기술/공학</a>
							<a href="/search?keyword=${page.cri.keyword}&cateCode=012">컴퓨터/IT</a>
							<a href="/search?keyword=${page.cri.keyword}&cateCode=013">유아(0~7세))</a>
							<a href="/search?keyword=${page.cri.keyword}&cateCode=014">어린이(초등)</a>
							<a href="/search?keyword=${page.cri.keyword}&cateCode=015">어린이전집</a>
							<a href="/search?keyword=${page.cri.keyword}&cateCode=016">어린이영어</a>
							<a href="/search?keyword=${page.cri.keyword}&cateCode=017">청소년</a>
							<a href="/search?keyword=${page.cri.keyword}&cateCode=018">초등참고서</a>
							<a href="/search?keyword=${page.cri.keyword}&cateCode=019">중/고등참고서</a>
							<a href="/search?keyword=${page.cri.keyword}&cateCode=020">대학교재</a>
							<a href="/search?keyword=${page.cri.keyword}&cateCode=021">취업/수험서</a>
							<a href="/search?keyword=${page.cri.keyword}&cateCode=022">외국어</a>
							<a href="/search?keyword=${page.cri.keyword}&cateCode=023">가정/육아</a>
							<a href="/search?keyword=${page.cri.keyword}&cateCode=024">건강</a>
							<a href="/search?keyword=${page.cri.keyword}&cateCode=025">여행</a>
							<a href="/search?keyword=${page.cri.keyword}&cateCode=026">요리</a>
							<a href="/search?keyword=${page.cri.keyword}&cateCode=027">취미/실용/스포츠</a>
							<a href="/search?keyword=${page.cri.keyword}&cateCode=028">잡지</a>
							<a href="/search?keyword=${page.cri.keyword}&cateCode=029">만화</a>
						</td>
					</tr>
				</table>
				<!-- <div class="col1">
					카테고리
				</div>
				<div class="col2">
				
				</div> -->
			<!-- </div> -->
			</c:if>
		</div>
	</div>
	



		
	<div id="main">
		<div id="main2">
			<div id="main2_1">
			<!-- 테스트 -->
						<c:if test="${exist == 0 }">
				 			<div id="exist">검색된 제품이 없습니다.</div>
				 		</c:if>
				 	
				 <table>
				 		<c:set var="i" value="0"/>
						<c:forEach items="${list}" var="book">
							
							<tr>
								<td id="table_image${i}" class="table_image" >
									<input type="hidden" id="productId${i}" class="productID" value="${book.productID}">
									이미지
								</td>
								
								<td id="table_info">
									<div class="title">
										<a href="detail?num=${book.productID}">
											<span class="category">[${book.cateName}]</span>
											<strong> ${book.title} </strong>
										</a>
									</div>
									<div class="author">
										<a>${book.authorName}</a> 지음 
										<span class="line">|</span>
										<a> ${book.publisher}</a>
										<span class="line">|</span>
										${book.publeYear}
									
									</div>
									<div class="likeStar">평점 : 
									<c:if test="${book.likeStar == 0}">
										<span> 평가 없음</span>
									</c:if>
									<c:if test="${book.likeStar != 0}">
										<span>${book.likeStar}</span>
									</c:if>
									</div>
								</td>
								<td id="table_price">
								
									<div class="org_price">
										<del> <fmt:formatNumber value="${book.bookPrice}" pattern="#,###"/> 원</del>
									</div>
									
									<div class="sell_price"><strong><fmt:formatNumber value="${book.discountPrice}" pattern="#,###"/> 원</strong> [${book.discountRate}% ↓] </div>
									<c:set  var="point" value="${book.bookPoint}"></c:set>
									<div class="point">포인트 : <fmt:formatNumber value="${point}" pattern="#,###"/>
									</div>
									
								</td>
								<td id="table_info3">
									<form id="buy_form${i}" method="post">
										<div class="check">
											<!-- <input type="checkbox" name="indexCnt" value="1" class="checkbox" title="이 상품을 선택"> -->
											<span class="btn_count">
												<label><strong>수량</strong>  
													<input type="text" value="1" maxlength="3" id="qty${i}" class="input_style02" name="cartStock" readonly="readonly">
												</label>
												<a class="btn_plus" id="btn_plus${i}">수량 더하기</a>
												<a class="btn_minus" id="btn_minus${i}">수량 빼기</a>
												
											</span>
										</div>
										
										<div class="button">
											<input type="hidden" id="productId${i}" class="productID" value="${book.productID}">
											<a href="javascript:cartEnroll('${i}');" class="btn_blue">장바구니 담기</a>
										</div>
									</form>
								</td>
							</tr>
							<script>
								$(document).ready(function(){
									//alert("연결");
									// 이미지 불러오기
									(function(){
										var productID = $("#table_image${i} input").val();
										//alert(productID);
										$.getJSON("getBcover",{productID:productID}, function(arr){
											console.log(arr);
											
											var str = "";
											$(arr).each(function(i, attach){
											
												var fileCallPath = encodeURIComponent(attach.uploadPath + "/s_"+attach.uuid + "_"+attach.fileName);
												
												str += "<img src='display?fileName="+fileCallPath+"'>";
												
												return false;
											});
											
											$("#table_image${i}").html(str);
											
										});// end getJSON
										
									})();// end function
								 	
									//문제점 - 아래에 버튼을 눌럿을시 화면이 위로올라감(해결)
									//다른방법 - a링크 자바스크립트로 태움
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
							<c:set var="i" value="${i+1}"></c:set>
						</c:forEach>
							<tr>
								<td colspan="4">
								<c:if test="${pagingId == 0 }">
									<c:if test="${page.prev}">
						                <a href="search?pageNum=${page.startPage-1}&amount=${page.cri.amount}&keyword=${page.cri.keyword}">이전</a>
						            </c:if>
						            <c:forEach var="num" begin="${page.startPage}" end="${page.endPage}" >
						                  			<a href="search?pageNum=${num}&amount=${page.cri.amount}&keyword=${page.cri.keyword}">${num}</a>
						            </c:forEach>
						            <c:if test="${page.next}">
						               <a href="search?pageNum=${page.endPage+1}&amount=${page.cri.amount}&keyword=${page.cri.keyword}">다음</a>
						            </c:if>
						            
						        </c:if>
						        <c:if test="${pagingId == 1 }">
									<c:if test="${page.prev}">
						                <a href="search?pageNum=${page.startPage-1}&amount=${page.cri.amount}&authorName=${page.cri.authorName}">이전</a>
						            </c:if>
						            <c:forEach var="num" begin="${page.startPage}" end="${page.endPage}" >
						                  			<a href="search?pageNum=${num}&amount=${page.cri.amount}&authorName=${page.cri.authorName}">${num}</a>
						            </c:forEach>
						            <c:if test="${page.next}">
						               <a href="search?pageNum=${page.endPage+1}&amount=${page.cri.amount}&authorName=${page.cri.authorName}">다음</a>
						            </c:if>
						            
						        </c:if> 
						        <c:if test="${pagingId == 2 }">
									<c:if test="${page.prev}">
						                <a href="search?pageNum=${page.startPage-1}&amount=${page.cri.amount}&cateCode=${page.cri.cateCode}">이전</a>
						            </c:if>
						            <c:forEach var="num" begin="${page.startPage}" end="${page.endPage}" >
						                  			<a href="search?pageNum=${num}&amount=${page.cri.amount}&cateCode=${page.cri.cateCode}">${num}</a>
						            </c:forEach>
						            <c:if test="${page.next}">
						               <a href="search?pageNum=${page.endPage+1}&amount=${page.cri.amount}&cateCode=${page.cri.cateCode}">다음</a>
						            </c:if>
						            
						        </c:if> 
						        <c:if test="${pagingId == 3 }">
									<c:if test="${page.prev}">
						                <a href="search?pageNum=${page.startPage-1}&amount=${page.cri.amount}&keyword=${page.cri.keyword}&cateCode=${page.cri.cateCode}">이전</a>
						            </c:if>
						            <c:forEach var="num" begin="${page.startPage}" end="${page.endPage}" >
						                  			<a href="search?pageNum=${num}&amount=${page.cri.amount}&keyword=${page.cri.keyword}&cateCode=${page.cri.cateCode}">${num}</a>
						            </c:forEach>
						            <c:if test="${page.next}">
						               <a href="search?pageNum=${page.endPage+1}&amount=${page.cri.amount}&keyword=${page.cri.keyword}&cateCode=${page.cri.cateCode}">다음</a>
						            </c:if>
						            
						        </c:if>     
								</td>
							</tr>
						
							
			</table> 
			
			
				<div id="side_right_ad">
					<jsp:include page="include/rightSideAd.jsp"></jsp:include>
				</div>
				<div id="side_left_ad">
					<jsp:include page="include/leftSideAd.jsp"></jsp:include>
				</div>
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


	
	<!-- <div id="side_left_ad"><h1>side left85 703</h1></div> -->
	</div>

	<!-- <div id="side_right_ad"><h1>side right 63 362</h1></div> -->
</body>
</html>