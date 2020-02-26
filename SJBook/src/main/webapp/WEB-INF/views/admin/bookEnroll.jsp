<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome! SJBook Store!</title>
<link rel="stylesheet" href="../resources/css/admin/bookEnroll.css">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script src="../resources/js/admin/bookEnroll.js" type="text/javascript"></script>
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
						<p>상품 등록</p>
					</div>
					<form id="bookEnroll_form" method="post">
						<div id="main_content_1">
							<span id="main_content_1_1">책제목</span> <strong>:</strong>   <input type="text" name="title">
							<br>
							<span id="main_content_1_1">출판사</span> <strong>:</strong>   <input type="text" name="publisher">
							<br>
							<span id="main_content_1_1">작가</span> <strong>:</strong>   
							<input type="text" id="authorName" readonly="readonly">
							<input type="hidden" name="authorID" id="authorId">
							<a id="author_btn" href="javascript:authorr_search()">작가 검색</a>
							<br>
							<span id="main_content_1_1">책 재고</span> <strong>:</strong>   
							<input type="text" name="bookStock"> 개
							<br>
							<span id="main_content_1_1">카테고리</span> <strong>:</strong>   
							<select name="cateCode">
								<option value="001">소설</option>
								<option value="002">시/에세이</option>
								<option value="003">경제/경영</option>
								<option value="004">자기계발</option>
								<option value="005">인문</option>
								<option value="006">역사/문화</option>
								<option value="007">종교</option>
								<option value="008">정치/사회</option>
								<option value="009">예술/대중문화</option>
								<option value="010">과학</option>
								<option value="011">기술/공학</option>
								<option value="012">컴퓨터/IT</option>
								<option value="013">유아(0~7세)</option>
								<option value="014">어린이(초등)</option>
								<option value="015">어린이전집</option>
								<option value="016">어린이영어</option>
								<option value="017">청소년</option>
								<option value="018">초등참고서</option>
								<option value="019">중/고등참고서</option>
								<option value="020">대학교재</option>
								<option value="021">취업/수험서</option>
								<option value="022">외국어</option>
								<option value="023">가정/육아</option>
								<option value="024">건강</option>
								<option value="025">여행</option>
								<option value="026">요리</option>
								<option value="027">취미/실용/스포츠</option>
								<option value="028">잡지</option>
								<option value="029">만화</option>
							</select>
							<br>
							<span id="main_content_1_1">출판일</span> <strong>:</strong>   
							<input type="text" name="publeYear">
							<br>
							<p>! 책가격과 할인율 순서로 입력하여주세요.</p>
							<br>
							<span id="main_content_1_1">책가격</span> <strong>:</strong>   
							<input type="text" name="bookPrice" id="bookPrice" value="0"> 원 
							
							<br>
							<span id="main_content_1_1">할인율</span> <strong>:</strong>   
							<input type="text" name="discountRate" id="discountRate" value="0"> %
							<br>
							<span id="main_content_1_1">할인가격(실제판매가격)</span> <strong>:</strong>   
							<input type="text" name="discountPrice" id="discountPrice" readonly="readonly">
							<br>
							<span id="main_content_1_1">적립 포인트</span> <strong>:</strong>   
							<input type="text" name="bookPoint" id="bookPoint" readonly="readonly">
							<br>
							<span id="main_content_1_1">내용</span> <strong>:</strong>   
							<textarea rows="" cols="" id="contents" name="contents"></textarea>
							<script>
								var ckeditor_config = {
										resize_enaleb : false,
										enterMode : CKEDITOR.ENTER_BR,
										shiftEnterMode : CKEDITOR.ENTER_P,
										height : 450
								}
								
								
								CKEDITOR.replace("contents", ckeditor_config);
							</script>
						</div>
						<div id="main_content_2"> 
							<span id="main_content_1_2">책커버</span> :<br>
							<input type="file" name='uploadFile' multiple id="inputFile">
							<div class='uploadResult'>
								<ul>
								
								</ul>
							</div>
							<div id="button_wrap">
								<a href="javascript:enroll_btn()">제품등록</a>
							</div>
						</div>
					</form>
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