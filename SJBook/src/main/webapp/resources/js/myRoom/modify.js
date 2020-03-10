$(document).ready(function(){
	//alert("연결")
	
	
	
	$('#modify_btn').on("click",function(e){
		e.preventDefault();
		
		var memberPw1 = $('#memberPw').val();
		var memberPw2 = $('#memberPw2').val();
		// 비밀번호 입력 확인
		var check = false;
		// 비밀번호 재입력 입력 확인
		var check2 = false;

		$('#modify_btn').css("disabled", "false");
		
		if(memberPw1 == ""){
			$('#final_pw_ck').css("display","block");
			
		} else {
			$('#final_pw_ck').css("display","none");
			check = true;
			
		}
		
		if(memberPw2 != ""){
			check2 = true;
			$('#final_pwck_ck').css("display","none");
		} else{
			$('#final_pwck_ck').css("display","block");
		}
		
		//alert(check);
		//alert(check2);
		if(check && check2){
			
			alert("비밀번호 변경에 성공하였습니다. 다시 로그인 해주십시오");
			
			$('#modify_btn').css("disabled", "true");
			$('#modify_form').submit();
			
		}
		
		
	});
	
	
	
	$('#memberPw2').on("propertychange change keyup paste input",function(){
		var memberPw1 = $('#memberPw').val();
		var memberPw2 = $('#memberPw2').val();
		
		if(memberPw1 == memberPw2 && memberPw != ""&& memberPw2 != ""){
			$('#top_2_pwc_re2').css("display","none");
			$('#top_2_pwc_re').css("display","block");
			
		}else{
			$('#top_2_pwc_re2').css("display","block");
			$('#top_2_pwc_re').css("display","none");
		}
		
	});	
	
	
});