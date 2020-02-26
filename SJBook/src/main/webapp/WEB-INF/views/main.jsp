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
							<li><a >소설</a></li>
							<li><a >시/에세이</a></li>
							<li><a >경제/경영</a></li>
							<li><a >자기계발</a></li>
							<li><a >인문</a></li>
							<li><a >역사/문화</a></li>
							<li><a >종교</a></li>
							<li><a >정치/사회</a></li>
							<li><a >예술/대중문화</a></li>
							<li><a >과학</a></li>
							<li><a >기술/공학</a></li>
							<li><a >컴퓨터/IT</a></li>
						</ul>
						<ul class="search_2">
							<li><a >유아(0~7세)</a></li>
							<li><a >어린이(초등)</a></li>
							<li><a >어린이전집</a></li>
							<li><a >어린이영어</a></li>
							<li><a >청소년</a></li>
							<li><a >초등참고서</a></li>
							<li><a >중/고등참고서</a></li>
							<li><a >대학교재</a></li>
							<li><a >취업/수험서</a></li>
							<li><a >외국어</a></li>
							<li><a >가정/육아</a></li>
							<li><a >건강</a></li>
						</ul>
						<ul class="search_3">
							<li><a >여행</a></li>
							<li><a >요리</a></li>
							<li><a >취미/실용/스포츠</a></li>
							<li><a >잡지</a></li>
							<li><a >만화</a></li>
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
				<div><a href="/detail?num=189"><img src="http://image.kyobobook.co.kr/ink/images/prom/2020/banner/200123/bnN_01.jpg"></a></div>
				<div><a href="/detail?num=190"><img src="http://image.kyobobook.co.kr/ink/images/prom/2020/banner/200221/bnA_a03.jpg"></a></div>
				<div><a href="/detail?num=191"><img src="http://image.kyobobook.co.kr/ink/images/prom/2020/banner/200221/bnA_a06.jpg"></a></div>
				<div><a href="/detail?num=188"><img src="http://image.kyobobook.co.kr/ink/images/prom/2020/banner/200123/bnN_03.jpg"></a> </div>
				<div><a href="/detail?num=192"><img src="http://image.kyobobook.co.kr/ink/images/prom/2020/banner/200221/bnA_a04.jpg"></a></div>
				
			</div>
			
			
			<!-- 신간순 -->
			<div id="main2">
				<div id="main2_1">
					<div id="main2_1_subject">신간</div>
					<c:set value="0" var="i"></c:set>
					<c:forEach items="${ds}" var="list">
					<a href="detail?num=${list.productID}">
					<div id="main2_1_box${i }" class="main2_1_box">
						<div id="main2_1_box_img${i }" class="main2_1_box_img">
						<input type="hidden" id="productID${i }" value="${list.productID}">
			 				<script>
							/* 시간순 이미지 띄우기 */
							(function(){
								var productID = $("#productID${i}").val();
								
								//alert(productID);
								$.getJSON("getBcover",{productID:productID}, function(arr){
									console.log(arr);
									
									var str = "";
									$(arr).each(function(i, attach){
									
										var fileCallPath = encodeURIComponent(attach.uploadPath + "/"+attach.uuid + "_"+attach.fileName);
										
										str += "<img src='/display?fileName="+fileCallPath+"'>";
										
										return false;
									});
									
									$("#main2_1_box_img${i }").html(str);
									
								});// end getJSON
								
							})();// end function							
							
							
							</script>
						</div>
						<div class="main2_1_box_con">
							<span class="main2_1_box_con_cate">${list.cateName}</span>
							<br>
							<span class="main2_1_box_con_title">${list.title }</span>
							<br>
							<span class="main2_1_box_con_year">${list.publeYear}</span>
							
						</div>
					</div>
					</a>
					<c:set var="i" value="${i+1}"></c:set>
					</c:forEach>
					
					<div class="clearfix"></div>
					<div class="ds_left_btn"> < </div>
					<div class="ds_left_btn2"> < </div>
					<div class="ds_right_btn"> > </div>
					<div class="ds_right_btn2"> > </div>
				</div>
				
			</div>
			
			<!-- 평점순 -->
			<div id="main3">
				<div id="main3_1">
				 	<div id="main3_1_subject">평점 추천</div>
					<c:set value="0" var="i"></c:set>
					<c:forEach items="${ls}" var="list">
					<a href="detail?num=${list.productID}">
					<div id="main3_1_box${i }" class="main3_1_box">
						<div id="main3_1_box_img${i }" class="main3_1_box_img">
						<input type="hidden" id="ls_productID${i }" value="${list.productID}">
			 				<script>
							/* 시간순 이미지 띄우기 */
							(function(){
								var productID = $("#ls_productID${i}").val();
								
								//alert(productID);
								$.getJSON("getBcover",{productID:productID}, function(arr){
									console.log(arr);
									
									var str = "";
									$(arr).each(function(i, attach){
									
										var fileCallPath = encodeURIComponent(attach.uploadPath + "/"+attach.uuid + "_"+attach.fileName);
										
										str += "<img src='/display?fileName="+fileCallPath+"'>";
										
										return false;
									});
									
									$("#main3_1_box_img${i }").html(str);
									
								});// end getJSON
								
							})();// end function							
							
							
							</script>
						</div>
						<div class="main3_1_box_con">
							<span class="main3_1_box_con_cate">${list.cateName}</span>
							<br>
							<span class="main3_1_box_con_title">${list.title }</span>
							<br>
							<%-- <span class="main3_1_box_con_like">평점 : <strong>${list.likeStar}</strong></span> --%>
							<div class="likeStar_section" id="likeStar_section${i }">
								<span  class="mark on" id="star0">0.5점</span>
								<span  class="mark2 on" id="star1">1점</span>
								<span  class="mark " id="star2">1.5점</span>
								<span  class="mark2 " id="star3">2점</span>
								<span  class="mark " id="star4">2.5점</span>
								<span  class="mark2 " id="star5">3점</span>
								<span  class="mark " id="star6">3.5</span>
								<span  class="mark2 " id="star7">4점</span>
								<span  class="mark " id="star8">4.5점</span>
								<span  class="mark2 " id="star9">5점</span>
				
								<input type="hidden" id="likeStar${i }" value="${list.likeStar }">	
							</div>

							
						</div>
					</div>
					</a>
					<c:set var="i" value="${i+1}"></c:set>
					</c:forEach>
					
					<div class="clearfix"></div>
					<div class="ls_left_btn"> < </div>
					<div class="ls_left_btn2"> < </div>
					<div class="ls_right_btn"> > </div>
					<div class="ls_right_btn2"> > </div>				 
				 
				</div>
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
<script>
function starView(){
	for(var i =0; i < 12; i++){
		
			var idx = $('#likeStar'+i).val();
			//alert(i+"번재 idx"+ idx);
			idx = parseFloat(idx);
			
			if(idx-0.5<0){
				idx = 0;
			} else{
				idx = (idx-0.5)/0.5;	
			}
			//alert(idx);
			
			$('#likeStar_section' +i).find('#star'+idx).addClass('on').prevAll('span').addClass('on');				
	}
}
starView();
</script>
	
</body>
</html>