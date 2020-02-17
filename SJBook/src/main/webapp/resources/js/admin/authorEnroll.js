$(document).ready(function(){
	//alert("연결");
	
	
	//로그인 버튼 누르면 로그인 페이지로 이동
	$(".top_1_login_button").on("click", function(e){
		alert("연결");
		$(location).attr('href', 'login');
	});
	



	
	
});




function enroll_btn(){
	//alert("클릭");
	//if($('#hidden_cartId').val() != null){
		$("#authorEnroll_form").attr("action","/admin/authorEnroll");
		$("#authorEnroll_form").submit();
	/*	
	} else{
		alert("구매할 책을 선택해주세요.")
	}
	*/
}