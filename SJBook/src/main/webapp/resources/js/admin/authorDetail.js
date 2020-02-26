$(document).ready(function(){
	//alert("연결");
	
	
	//로그인 버튼 누르면 로그인 페이지로 이동
	$(".top_1_login_button").on("click", function(e){
		alert("연결");
		$(location).attr('href', 'login');
	});
	
	//검색 종류 선택
	$('.keyword_box>select').on("change", function(){
		var val = $(this).val();
		//alert(val);\
		if(val == 0){
			$('.keyword').attr("name","keyword");
		} else{
			$('.keyword').attr("name","authorName");
		}
			
		
	});


	
	
});




function modify_btn(){
	
		$("#authorDetail_form").attr("action","/admin/authorModify");
		$("#authorDetail_form").attr("method","get");
		$("#authorDetail_form").submit();
}

function delete_btn(){
	
	$("#authorDetail_form").attr("action","/admin/authorDelete");
	$("#authorDetail_form").attr("method","post");
	$("#authorDetail_form").submit();
}	