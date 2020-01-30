//alert("연결");

/*
function join_click(result){
	if(result == 'join'){
			alert("클릭");
			form1.action="/member/join";
			form1.submit();
	}
	
	
}
*/



$(document).ready(function(){
	// 인증번호받기
	
	$("#mid_mail_check_button").click(function(){
		
		//alert("버튼 연결")
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
			alert("ajax시작")
		$.ajax({
			type:"GET",
			url : "mailCheck?email=" + email,
			success:function(data){
				console.log(typeof(data));
				console.log("data : " + data);
				checkCode.attr("disabled",false);
				var box = $("#mid_mail_check")
				box.attr("class", "ps_box");
				//var num = data;
				//var num = data.checkNum;
				//console.log(num)
				
				//받은 난수 저장아직 안함
				$("#code").html(data)
			}
		});
		return false;
	});
	
	//인증번호 비교
	$("#checkCode").blur(function(){
		//alert("연결");
		var mailMsg = $("#mail_msg");
		var incode = $("#checkCode").val();
		var checkcode = $("#code").html();
		//alert(incode);
		alert(checkcode);
		
		if(incode == checkcode){
			mailMsg.html("인증이 완료되었습니다.");
			mailMsg.attr("class","correct");
		} else{
			mailMsg.html("인증번호를 다시 확인해주세요.")
			mailMsg.attr("class","incorrect");
		}
		
		
	});
	
	
	
	//가입하기 버튼
		//alert("연결");
	$("button[type='submit']").click(function(){
		//alert("클릭");
		$("form[id='form1']").attr("action","/member/join");
		$("form[id='form1']").submit();
	});
	
	//생년월일 한곳으로 합치기
	
	$("#birth3").keyup(function(){
		
		var birth1	= $("#birth1").val();
		var birth2	= $("#birth2").val();
		var birth3	= $("#birth3").val();
		
		$("#memberBith").val(birth1+'-' + birth2 +'-' + birth3);	
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	