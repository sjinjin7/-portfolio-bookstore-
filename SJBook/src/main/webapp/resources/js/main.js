$(document).ready(function(){
	//alert("연결");
	
	
	//로그인 버튼 누르면 로그인 페이지로 이동
	$(".top_1_login_button").on("click", function(e){
		alert("연결");
		$(location).attr('href', 'login');
	});
	
	//네비게이션바
	//국내도서
	$('nav .domestic').hover(function(){
		$('nav .domestic div').css('display','block');
	},
	function(){
		$('nav .domestic div').css('display','none')
	});
	//외국도서
	$('nav .forgien').hover(function(){
		$('nav .forgien div').css('display','block');
	},
	function(){
		$('nav .forgien div').css('display','none')
	});
	//중고도서
	$('nav .used').hover(function(){
		$('nav .used div').css('display','block');
	},
	function(){
		$('nav .used div').css('display','none')
	});
	
	
});


