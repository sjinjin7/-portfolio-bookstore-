
	
	//이름필수
		function nameky(){
		var name= document.getElementById("name").value;
		var len = name.length;
		if(len>=1){
			document.getElementById("name2").innerHTML="";
		} else{
			document.getElementById("name2").innerHTML="이름을 입력하셔야합니다."
		}
	};
	//id길이 유효성검사체크
	function idky(){
		var id= document.getElementById("id").value;
		var len = id.length;
		if(len>=8 && len<=12){
			document.getElementById("id2").innerHTML="사용가능한 아이디입니다.";
		} else{
			document.getElementById("id2").innerHTML=" id는 8자 이상 12자 이하로 입력하셔야 합니다."
		}
	};
	
	//ps길이 유효성검사체크
	function psky(){
		var ps= document.getElementById("ps").value;
		var len = ps.length;
		if(len>=8 && len<=12){
			document.getElementById("ps2").innerHTML="사용가능한 비밀번호입니다.";
		} else{
			document.getElementById("ps2").innerHTML="비밀번호는 8자 이상 12자 이하로 입력하셔야 합니다."
		}
	};
	
	//비밀번호 일치 확인
	function pscheck(){
		var ps= document.getElementById("ps").value;
		var psch= document.getElementById("pscheck").value;
		if(ps==psch){
			document.getElementById("pscheck2").innerHTML="비밀번호가 일치합니다.";
		} else{
			document.getElementById("pscheck2").innerHTML="비밀번호가일치하지않습니다.";
		}
		
	}
	
	//인증번호발송
	function callsubmit1(){
			var random = Math.floor(Math.random()*10)+1;
			document.getElementById("callsubmitnumber").value = random;
	}
	
	
	//콤보상자 입력

$(document).ready(function(){
	
	$('#emailselect').change(function(){
		$("#emailselect option:selected").each(function () {

			if($(this).val()== '1'){ //직접입력일 경우
				$("#email2").val(''); //값 초기화 
				$("#email2").attr("disabled",false); //활성화 
			}else{ //직접입력이 아닐경우

				$("#email2").val($(this).text()); //선택값 입력 
				$("#email2").attr("disabled",true); //비활성화 
			} 
		}); 
	});
	
})	
	
	

	



