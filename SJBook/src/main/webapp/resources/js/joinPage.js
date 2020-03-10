
$(document).ready(function(){
	
	// 아이디 중복검사
	$('#memberId').on("propertychange change keyup paste input",function(){
		
		var memberId = $('#memberId').val();
		var data = {memberId : memberId}
		
		$.ajax({
			type : "post",
			url:"/member/memberIdChk",
			data : data,
			success : function(data){
				
				// 중복아이디 없을시 초록색 글자
				if(data == 'success'){
					$('#top_1_id_re').css("display","inline-block");
					$('#top_1_id_re2').css("display","none");
				} else{
				// 중복된 아이디 있을시 빨감색 글자 	
					$('#top_1_id_re').css("display","none");
					$('#top_1_id_re2').css("display","inline-block");
				}
			}//success 종료
	
		});//ajax 종료
		
	});// function 종료	

	
	
	//비밀번호 재확인 유효성검사
	$('#memberPw2').on("propertychange change keyup paste input",function(){
	
			var originPw = $('#memberPw').val();
			var checkPw = $('#memberPw2').val();
			
			if(originPw == checkPw){
				$('#top_2_pwc_re').css("display","inline-block");
				$('#top_2_pwc_re2').css("display","none");
			} else{
				$('#top_2_pwc_re').css("display","none");
				$('#top_2_pwc_re2').css("display","inline-block");
			}
		
		
	});
	
	
	
	
	
	
	// 인증번호받기
	$("#mid_mail_check_button").click(function(){
		
		var email=$("#memberEmail").val();
		var errorMsg = $("#mail_err");
		var mailMsg = $("#mail_msg");
		var checkCode = $("#checkCode");

		if(email == ""){
			errorMsg.html("이메일을 입력해주세요.");
			errorMsg.show();
			return false;
		} else{
			errorMsg.hide();
		}
		if(!mailFormCheck(email)){
			errorMsg.html("올바르지 못한 이메일 형식입니다.");
			errorMsg.show();
			return false;
		}else{
			errorMsg.hide();
			mailMsg.html("이메일을 보냈습니다. 메일을 확인해주세요.")
			mailMsg.show();
		}
			
		$.ajax({
			type:"GET",
			url : "mailCheck?email=" + email,
			success:function(data){
				//console.log(typeof(data));
				//console.log("data : " + data);
				checkCode.attr("disabled",false);
				var box = $("#mid_mail_check")
				box.attr("class", "ps_box");
				
				$("#code").html(data)
			}
		}); // ajax 종료
		return false;
	}); // function 종료
	
	
	//인증번호 비교
	$("#checkCode").blur(function(){
		//alert("연결");
		var mailMsg = $("#mail_msg");
		var incode = $("#checkCode").val();
		var checkcode = $("#code").html();
		//alert(incode);
		//alert(checkcode);
		
		if(incode == checkcode){
			mailMsg.html("인증이 완료되었습니다.");
			mailMsg.attr("class","correct");
			$('#mail_result').val("true");
		} else{
			mailMsg.html("인증번호를 다시 확인해주세요.")
			mailMsg.attr("class","incorrect");
			$('#mail_result').val("false");
		}
		
		
	});
	
	
	
	
	
	//생년월일 한곳으로 합치기
	
	$("#birth3").keyup(function(){
		
		var birth1	= $("#birth1").val();
		var birth2	= $("#birth2").val();
		var birth3	= $("#birth3").val();
		
		$("#memberBith").val(birth1+'-' + birth2 +'-' + birth3);	
	});
	
	
	
	

	//가입하기 최종 유효성검사
	$("button[type='submit']").on("click",function(){
		//e.prevnetDefault();
		
		//유효성과 검사 통과유뮤
		var idcheck = false;
		var pwcheck = false;
		var pwckcheck = false;
		var namecheck = false;
		var birthcheck = false;
		var phonecheck = false;
		var emailcheck = false;
		var addresscheck = false;
		
		//alert("연결");
		var id = $('#memberId').val();
		var pw = $('#memberPw').val();
		var pwck = $('#memberPw2').val();
		var name = $('#memberName').val();
		var birth1 = $('#birth1').val();
		var birth3 = $('#birth3').val();
		var phone = $('#memberPhone').val();
		var email = $('#mail_result').val();
		var memberAddr2 = $('#memberAddr2').val();
		var memberAddr3 = $('#memberAddr3').val();
		
		$("form[id='form1']").css('disabled','false');
		
		//아이디 유효성검사
		if(id == ""){
			$('#final_id_ck').css('display','block');
		} else{
			$('#id_check').css('display','none');
			idcheck = true;
		}
		
		//비번 유효성검사
		if(pw == ""){
			$('#final_pw_ck').css('display','block');
		} else {
			$('#final_pw_ck').css('display','none');
			pwcheck = true;
		}
		
		//비번 재확인 유효성검사
		if(pw == ""){
			$('#final_pwck_ck').css('display','block');
		} else {
			$('#final_pwck_ck').css('display','none');
			pwckcheck = true;
		}
		
		
		//이름 유효성 검사
		if(name == ""){
			$('#final_name_ck').css('display','block');
		} else {
			$('#final_name_ck').css('display','none');
			namecheck = true;
		}
		
		// 생년월일 유효성검사
		if(birth1 != "" && birth3 != ""){
			$('#final_birth_ck').css('display','none');
			birthcheck = true;
		} else {
			$('#final_birth_ck').css('display','block');
		}
		
		// 휴대전화번호
		if(phone == ""){
			$('#final_phone_ck').css('display','block');
		} else {
			$('#final_phone_ck').css('display','none');
			phonecheck = true;
		}
		
		//이메일 인증 유효성검사
		if(email == "true"){
			$('#final_mail_ck').css('display','none');
			emailcheck = true;
		} else {
			$('#final_mail_ck').css('display','block');
		}
		
		
		//주소록 유효성검사
		if(memberAddr2 != "" && memberAddr3 != ""){
			$('#final_addr_ck').css('display','none');
			addresscheck = true;
		} else {
			$('#final_addr_ck').css('display','block');
		}
		
		
		if(idcheck&&pwcheck&&pwckcheck&&namecheck&&birthcheck&&phonecheck&&emailcheck&&addresscheck){
			//유효성 검사 통과 및 실행
			$("form[id='form1']").attr("action","/member/join");
			$("form[id='form1']").submit();		
		}
		 
		$("form[id='form1']").css('disabled','true');
		return false;

	});
	
	
});



function execPostCode() {
    new daum.Postcode({
        oncomplete: function(data) {
           // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

           // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
           // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
           var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
           var extraRoadAddr = ''; // 도로명 조합형 주소 변수

           // 법정동명이 있을 경우 추가한다. (법정리는 제외)
           // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
           if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
               extraRoadAddr += data.bname;
           }
           // 건물명이 있고, 공동주택일 경우 추가한다.
           if(data.buildingName !== '' && data.apartment === 'Y'){
              extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
           }
           // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
           if(extraRoadAddr !== ''){
               extraRoadAddr = ' (' + extraRoadAddr + ')';
           }
           // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
           if(fullRoadAddr !== ''){
               fullRoadAddr += extraRoadAddr;
           }

           // 우편번호와 주소 정보를 해당 필드에 넣는다.
           console.log(data.zonecode);
           console.log(fullRoadAddr);
           
           
           $("[name=memberAddr1]").val(data.zonecode);
           $("[name=memberAddr2]").val(fullRoadAddr);
           
       }
    }).open();
}






//이메일 유효성 검사
	function mailFormCheck(email) {
		var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
		return re.test(email);
	}
	
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	