$(document).ready(function(){
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
	



/*
		function valueUp(i){
			//$("#qty"+i).val();
			var value = parseInt($("#qty"+i).val())+1;
			alert($("#qty"+i).val());
		}

*/