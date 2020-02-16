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
	
	
	//최종결제 스크롤

	// 기존 css에서 플로팅 배너 위치(top)값을 가져와 저장한다.
	var floatPosition = parseInt($("#main_right").css('top'));
	// 250px 이런식으로 가져오므로 여기서 숫자만 가져온다. parseInt( 값 );

	$(window).scroll(function() {
		// 현재 스크롤 위치를 가져온다.
		var scrollTop = $(window).scrollTop();
		var newPosition = scrollTop + floatPosition + "px";

		/* 애니메이션 없이 바로 따라감
		 $("#floatMenu").css('top', newPosition);
		 */

		$("#main_right").stop().animate({
			"top" : newPosition
		}, 500);

	}).scroll();

	
	
	
	/*
	
	//퀵메뉴 스크롤
	
	// 기존 css에서 플로팅 배너 위치(top)값을 가져와 저장한다.
	var floatPosition = parseInt($("#side_right_ad").css('top'));
	// 250px 이런식으로 가져오므로 여기서 숫자만 가져온다. parseInt( 값 );

	$(window).scroll(function() {
		// 현재 스크롤 위치를 가져온다.
		var scrollTop = $(window).scrollTop();
		var newPosition = scrollTop + floatPosition + "px";

		 //애니메이션 없이 바로 따라감
		 //$("#floatMenu").css('top', newPosition);
		 

		$("#side_right_ad").stop().animate({
			"top" : newPosition
		}, 500);

	}).scroll();
	
	*/
	
	
	
	
	
	// 배송정보 성택
		// 저장주소
		$(".addr_button1").click(function(){
			var save1 = $('#save1').html();
			$("#main_buy_addr_info1").html(save1);
			$("#main_buy_addr_info1").attr("class", "main_buy_addr_info1");
			$("#main_buy_addr_info2").html("");
			$("#main_buy_addr_info2").attr("class", "");
			$("#addr_button_save").attr("class", "addr_button1")
			$("#addr_button_insert").attr("class", "addr_button2")
		});
	
	
		// 직접입력
		$(".addr_button2").click(function(){
			var save2 = $('#save2').html();
			$("#main_buy_addr_info1").html("");
			$("#main_buy_addr_info1").attr("class", "");
			$("#main_buy_addr_info2").html(save2);
			$("#main_buy_addr_info2").attr("class", "main_buy_addr_info2");
			$("#addr_button_save").attr("class", "addr_button2")
			$("#addr_button_insert").attr("class", "addr_button1")
		})
	
	
	
		
		//point input  변화시 결과창 할인금액 값 변동
		$('#point_input').on("propertychange change keyup paste input",function(){
			var inValue = $("#point_input").val();
			 if (/\D/.test(this.value)) {
			        this.value = this.value.replace(/\D/g, '')
			        alert('숫자만 입력가능합니다.');
			    }
			  if (parseInt(this.value) > parseInt($('#ownPoint').val())) {
			      this.value = $('#ownPoint').val();
			      alert($('#ownPoint').val()+'까지만 가능합니다.');
			  }
			
			
			$(".sale_price>#label_result>#number").html(inValue);
			$(".sale_price>input").val(inValue);
			
			var totalPrice = $("#titalPriceInput").val();
			
			var shipPrice = $(".shipPrice input").val();
			var sale_price = $(".sale_price input").val();
			var finalTotalPrice = totalPrice + shipPrice - sale_price;
			var IntegerTotalPrice = parseInt(finalTotalPrice)
			//alert("totalPrice :"+ totalPrice);
			//alert("shipPrice : " + shipPrice);
			//alert("sale_price : "+sale_price);
			//alert("finalTotalPrice : " + finalTotalPrice );
			
			$(".total_li #label_result>#number").html(finalTotalPrice.toLocaleString());
			$("#sale_priceInput").attr("value", sale_price);
			
		});
		
		//모두사용버튼
		$('#point_btn1').on('click',function(){
			var inValue = $("#point_input").val();
			$('#point_btn1').css("display", "none");
			$('#point_btn2').css("display","inline-block");
			$("#point_input").val($('#ownPoint').val());
			$(".sale_price>#label_result>#number").html(inValue);
			$(".sale_price>input").val(inValue);
			
			var totalPrice = $("#titalPriceInput").val();
			
			var shipPrice = $(".shipPrice input").val();
			var sale_price = $(".sale_price input").val();
			var finalTotalPrice = totalPrice + shipPrice - sale_price;
			var IntegerTotalPrice = parseInt(finalTotalPrice)
			//alert("totalPrice :"+ totalPrice);
			//alert("shipPrice : " + shipPrice);
			//alert("sale_price : "+sale_price);
			//alert("finalTotalPrice : " + finalTotalPrice );
			
			$(".total_li #label_result>#number").html(finalTotalPrice.toLocaleString());
			$("#sale_priceInput").attr("value", sale_price);
		});
		// 사용취소 버튼
		$('#point_btn2').on('click',function(){
			var inValue = $("#point_input").val();
			$('#point_btn1').css("display", "inline-block");
			$('#point_btn2').css("display","none");
			$("#point_input").val(0);
			$(".sale_price>#label_result>#number").html(inValue);
			$(".sale_price>input").val(inValue);
			
			var totalPrice = $("#titalPriceInput").val();
			
			var shipPrice = $(".shipPrice input").val();
			var sale_price = $(".sale_price input").val();
			var finalTotalPrice = totalPrice + shipPrice - sale_price;
			var IntegerTotalPrice = parseInt(finalTotalPrice)
			//alert("totalPrice :"+ totalPrice);
			//alert("shipPrice : " + shipPrice);
			//alert("sale_price : "+sale_price);
			//alert("finalTotalPrice : " + finalTotalPrice );
			
			$(".total_li #label_result>#number").html(finalTotalPrice.toLocaleString());
			$("#sale_priceInput").attr("value", sale_price);
		});
		
		
	

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
	

	
	function buy_btn(){
		//alert("클릭");
		$("#buy_form").attr("action","/purchase/preBuy");
		$("#buy_form").submit();
	}
	
	
	
	
	//다음주소록
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
	           
	           
	           $("#receiver_row_addr_input1").val(data.zonecode);
	           $("#receiver_row_addr_input2").val(fullRoadAddr);
	           
	       }
	    }).open();
	}


/*
		function valueUp(i){
			//$("#qty"+i).val();
			var value = parseInt($("#qty"+i).val())+1;
			alert($("#qty"+i).val());
		}

*/
