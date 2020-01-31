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
	
	
/*	
 	//로그아웃 ajax 기능 구현
	$("#logout").click(function(){
		//alert("버튼연결");
		$.ajax({
			type:"POST",
			url : "member/logout",
			success:function(data){
				
				alert("로그아웃 되었습니다.");
				document.location.reload();
				//document 또는 self 를 사용하면됨
				//self.location.reload();
				
			}
		});//ajax 끝
	});//function 끝
	*/
	
	//slcik 사용
	$('#main1').slick({
        infinite: true , /* 맨끝이미지에서 끝나지 않고 다시 맨앞으로 이동 */         slidesToShow: 1, /* 화면에 보여질 이미지 갯수*/        slidesToScroll: 1,  /* 스크롤시 이동할 이미지 갯수 */         autoplay: true, /* 자동으로 다음이미지 보여주기 */         arrows: true, /* 화살표 */         dots:true, /* 아래점 */         autoplaySpeed:10000,/* 다음이미지로 넘어갈 시간 */         speed:1000 , /* 다음이미지로 넘겨질때 걸리는 시간 */         pauseOnHover:true, /* 마우스 호버시 슬라이드 이동 멈춤 */        //vertical:true,/* 세로방향으로 슬라이드를 원하면 추가하기// 기본값 가로방향 슬라이드*/        responsive: [ { /* 반응형웹*/ breakpoint: 960, /* 기준화면사이즈 */ settings: {slidesToShow:2 } /* 사이즈에 적용될 설정 */ }, { /* 반응형웹*/ breakpoint: 768, /* 기준화면사이즈 */ settings: {slidesToShow:1 } /* 사이즈에 적용될 설정 */ } ]

     
		});
	
	
});


