<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/join.css">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
 <script src="../resources/js/joinPage.js" type="text/javascript"></script>
 <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  
</head>
<body>

<div id="wrap">
	<form id="form1" method="post">
		<div id="top_logo" class="clearfix">
			<a href="/main"><img src="../resources/img/logo.png"></a>
		</div>
		<!-- 아이디/비밀번호/비밀번호 확인 -->
		<div id="top">
			<div id="top_1">
				<h3>아이디</h3>
				<div id="top_1_id"><input type="text" name="memberId"></div>
				<span id="top_1_id_re"></span>
			</div>
				
			<div id="top_2">
				<h3>비밀번호</h3>
				<div id="top_2_pw"><input type="text" name="memberPw"></div>
				<span id="top_2_pw_re"></span>
				<h3>비밀번호 재확인</h3>
				<div id="top_2_pwc"><input type="text"></div>
				<span id="top_2_pwc_re"></span>
			</div>
			
		</div>
		<!-- 이름/생년월일/성별/휴대전화/이메일 -->
		<div id="mid">
			<div id="mid_name">
				<h3>이름</h3>
				<div id="top_1_id"><input type="text" name="memberName"></div>
				<span id="top_1_id_re"></span>
			</div>
			<div id="mid_birth">
				<h3>생년월일</h3>
				<div id="mid_birth_in">
					<div id="mid_birth_in_yy">
						<input type="text" id="birth1" name="birthY" value="">
					</div>
					<div id="mid_birth_in_mm">
						<select id="birth2" name="birthM">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
						</select>
					</div>
					<div id="mid_birth_in_dd">
						<input type="text" id="birth3" name="birthD" value="">
						
					</div>
				</div>
			</div>
			<div id="mid_gender">
				<h3>성별</h3>
				<div id="mid_gender_in"><input type="text" name="memberGender"></div>
			</div>
			<div id="mid_phon">
				<h3>휴대전화번호</h3>
				<div id="mid_phon_in">
					<input type="text" name="memberPhone">
					
				</div>
			</div>
	
	
		</div>
		<div id="mid_mail">
			<h3>email</h3>
			<div id="mid_mail_in">
				<input type="text" id="memberEmail">
			</div>
			<div id="mid_mail_check" class="ps_box_disable">
				<input type="text" id="checkCode" disabled="disabled">
			</div>
			<div id="mid_mail_check_button"><a> <h2>인증번호 받기</h2> </a></div>
			<div id="mid_mail_clear"></div>
			<span id="mail_err" style="display:none;"> </span>
			<span id="mail_msg" style="display:none;"></span>
			<span id="code" style="display:none;"></span>
		</div>
		<!-- 주소 ,api랑 함게하기-->
		<div id="bot">
			<div id="bot_add">
				<h3>주소</h3>
				<div id="bot_add_in1">
					<div id="bot_add_in1_in"> <input type="text" name="memberAddr1" readonly="readonly"> </div>
					<div id="bot_add_in1_button" onclick="execPostCode()"> <h2>우편번호 찾기</h2> </div>
				</div>
				<div id="clearfix"></div>
				<div id="bot_add_in2">
					<input type="text" name="memberAddr2" readonly="readonly">				
				</div>
				<div id="bot_add_in3">
					<input type="text" name="memberAddr3">
				</div>
			</div>
		</div>
		<input type="hidden" id="memberBith" name="memberBith">
	</form>
	<div id="join_button"><button type="submit" ><h1>가입하기</h1></button> </div>
	
</div>
</body>
</html>