
$(document).ready(function(){
	//alert("연결");
	
	/*
	//xptmxm
	var id = $('#main_id>input').val();
	var pw = $('#main_pw>input').val();
	alert(id);
	alert($('#main_id>input').val());
	*/
	
	
	$('#login_btn').click(function(){
		//유효성과 검사 통과유뮤
		var idcheck = false;
		var pwcheck = false;
		
		//alert("연결");
		var id = $('#main_id>input').val();
		var pw = $('#main_pw>input').val();
		
		
		$('#login_btn').css('disabled','false');
		
		//아이디 유효성검사
		if(id == ""){
			$('#id_check').css('display','block');
		} else{
			$('#id_check').css('display','none');
			idcheck = true;
		}
		
		//비번 유효성검사
		if(pw == ""){
			$('#pw_check').css('display','block');
		} else {
			$('#pw_check').css('display','none');
			pwcheck = true;
		}
		
		if(idcheck&&pwcheck){
			//유효성 검사 통과 및 실행
			$('#login_btn').attr('disabled','true');
			$('form').submit();			
		}
		 
		$('#login_btn').css('disabled','true');
		return false;

	});
	
/*	
	$('#login_btn').click(function(){
		//유효성과 검사 통과유뮤
		var idcheck = false;
		var pwcheck = false;
		
		//alert("연결");
		var id = $('#main_id>input').val();
		var pw = $('#main_pw>input').val();
		
		
		$('#login_btn').css('disabled','false');
		
		$('#login_btn').css('disabled','true');
		

	});
	
	*/
	
	
});

/*
//가입하기 버튼
//alert("연결");
$("button[type='submit']").click(function(){
//alert("클릭");
$("form[id='form1']").attr("action","/member/join");
$("form[id='form1']").submit();
});
*/