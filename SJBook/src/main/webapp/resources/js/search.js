$(document).ready(function(){
	
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
	
	//alert("연결");
	$('.open').on('click', function(e){
		$('#nav_main_1').css('height','150px');
		$('.opened').css('display','block');
		$('.open').css('display','none');
		
		//alert("??")
	});
	
	$('.opened').on("click", function(e){
		$('#nav_main_1').css('height','50px');
		$('.opened').css('display','none');
		$('.open').css('display','block');
		
	});
/*	
	//수량업
	
		$("#btn_plus${i}").on('click', function(e){
			var value = parseInt($('#qty${i}').val());
			value = value + 1;
			$('#qty${i}').val(value);


		});

	//수량 down
	$(".btn_minus").on('click', function(e){
		var value = $('input_style02').val();
	});
	
	*/
	
	
	
	
	
	
	//퀵메뉴 스크롤
	
	// 기존 css에서 플로팅 배너 위치(top)값을 가져와 저장한다.
	var floatPosition = parseInt($("#side_right_ad").css('top'));
	// 250px 이런식으로 가져오므로 여기서 숫자만 가져온다. parseInt( 값 );

	$(window).scroll(function() {
		// 현재 스크롤 위치를 가져온다.
		var scrollTop = $(window).scrollTop();
		var newPosition = scrollTop + floatPosition + "px";

		/* 애니메이션 없이 바로 따라감
		 $("#floatMenu").css('top', newPosition);
		 */

		$("#side_right_ad").stop().animate({
			"top" : newPosition
		}, 500);

	}).scroll();
	
		
	
});


	function valueUp(i){
		//$("#qty"+i).val();
		var value = parseInt($("#qty"+i).val())+1;
		$("#qty"+i).val(value);
		
	}
	
	
	function valueDown(i){
		//$("#qty"+i).val();
		var value = parseInt($("#qty"+i).val())-1;
		if(value <=0){return;}
		$("#qty"+i).val(value);
		
	}
	
	
	function cartEnroll(i){
		var productId = $("#productId"+i).val()
		//id="table_image${i}"
		var cartStock = $('#qty'+i).val();
		//id="qty${i}"
			//alert(i);
			//alert(pid);
			//alert(cartStock);
		var data = { 
				productId : productId,
				cartStock : cartStock
				}
		$.ajax({
			url : "addEnroll",
			type : "post",
			data : data,
			success : function(result){
				if(result == 'true'){
					alert("카트 담기 성공");
					$('#qty'+i).val(1);	
				} else{
					alert("회원만 사용할 수 있습니다.");
				}
				
			}, error : function(){
				alert("카트 담기 실패");
			}
		}); // End ajax
		
		
	}
	
	
/*스크롤 최상단*/	
function scroll_Top(){
	$('html').scrollTop(0);
}
/*스크롤 최하단*/
function scroll_Bottom(){
	$("html").scrollTop($(document).height());
};


	


/*
		function valueUp(i){
			//$("#qty"+i).val();
			var value = parseInt($("#qty"+i).val())+1;
			alert($("#qty"+i).val());
		}

*/
