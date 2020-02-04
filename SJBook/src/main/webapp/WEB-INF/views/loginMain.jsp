<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/loginMain.css">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script src="resources/js/loginMain.js" type="text/javascript"></script>
</head>
<body>

<!-- <h1>login</h1> -->

<div id="wrap">
	<div id="top_logo">
		<a href="main"><img src="resources/img/logo.png"></a>
	</div>
	<form action="member/login" method="post">
	<div id="main_middle">
		<div id="main_middle_1">
			<div id="main_id"><input type="text" name="memberId"></div>
			<span id="id_check">아이디를 입력해주세요.</span>
			<div id="main_pw"><input type="password" name="memberPw"></div>
			<span id="pw_check">비밀번호를 입력해주세요.</span>
			<!-- <div id="main_button"> -->
				<!-- <a href="member/login"> <h1>로그인</h1> </a> -->
				<input type="submit" value="로그인" id="login_btn">
			<!-- </div> -->
			<c:if test="${result == 0}">
			<div id="loginWarn"><strong>사용자 ID</strong> 또는 <strong>비밀번호</strong>를 잘못 입력하셨습니다.</div>
			</c:if>
			<div id="main_check"><p>로그인상태유지</p> </div>
		</div>
	</div>
	</form>
	<div id="main_bottom">
		<div id="main_link">
			<ul>
				<li><a href="member/joinPage">회원가입</a></li>
				<li>아이디찾기</li>
				<li>비밀번호 찾기</li>
			</ul>
		</div>
		<div id="main_bottom_1">
			광고
		</div>
	</div>
</div>
</body>
</html>