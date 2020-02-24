
$(document).ready(function(){
//alert("연결");
//var productID ='<c:out value="${bd.productID}"/>';
//var productID = $(".uploadResult input").val();
//alert(productID);

	
	$('#likeStar_section a').bind('click mouseover',function(e){
		e.preventDefault();
		//alert("연결");
		var idx = $(this).parent().find('a').index(this) * 0.5 + 0.5;
		$(this).parent().children('a').removeClass('on');
		$(this).addClass('on').prevAll('a').addClass('on');
		$(this).parent().find('#likeRating').val(idx);
		//alert(idx);
		
	});
	
	
	
	
	
	(function(){
		
		//var productID = $(".uploadResult input").val();
		var productID = $(".uploadResult input").val();
		
		$.getJSON("getBcoverList", {productID: productID}, function(arr){
			console.log(arr)
			
			var str = "";
			
			$(arr).each(function(i, attach){
				
				//image type
				if(attach.fileType=1){
					var fileCallPath = encodeURIComponent(attach.uploadPath + "/s_"+attach.uuid + "_"+attach.fileName);
					
					str += "<li data-path='" + attach.uploadPath+"' data-uuid='"+attach.uuid+"' data-filename='"+attach.fileName+"' data-type='" + attach.image+"'><div>";
					str += "<img src='display?fileName="+fileCallPath+"'>";
					str += "</div>";
					str += "</li>";
					
				} else{
					
					str += "<li data-path='"+attach.uploadPath+"' data-uuid='"+attach.uuid+"'data-filename='"+attach.fileName+"' data-type='"+attach.fileType+"'><div>";
					str += "<span>"+attach.fileName+"</span><br/>";
					str += "<img src='../resources/img/attach.png'>";
					str += "</div>";
					str += "</li>";
					
				}
				
				
				
			});
			
			$(".uploadResult ul").html(str);
			
			
		}); // end getjson
		
		
	})();// end function
	
	
	//이미지 클릭시 확대
	$(".uploadResult").on("click","li",function(e){
		
		console.log("view image");
		
		var liobj=$(this);
		
		//var path=encodeURIComponent(liobj.data("path")+"/"+liobj.data("uuid")+"_"+liobj.data("filename"));
		var path=encodeURIComponent(liobj.data("path")+"//"+liobj.data("uuid")+"_"+liobj.data("filename"));
		
		
		if(liobj.data("type")==1){
			showImage(path.replace(new RegExp(/\\/g),"/"));
		} else{
			//download
			self.location="/download?fileName="+path;
		}
		
	});
	
	//임지 클릭시 닫기
	$(".bigPictureWrapper").on("click", function(e){
		$(".bigPicture").animate({width:'0%',height:'0%'},1000);
		setTimeout(function(){
			$('.bigPictureWrapper').hide();
		});
	});
	
	
	
	
	
	// 이미지 클릭시 원본파일 보여주기
	function showImage(fileCallPath){
		
		//alert(fileCallPath);
		
		$(".bigPictureWrapper").css("display","flex").show();
		
		$(".bigPicture").html("<img src='display?fileName="+fileCallPath+"'>").animate({width:'100%', height: '100%'}, 1000);
		
	}
	
	
	
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
	
	
	//댓글 등록
	$("#reply_btn").click(function(){
		alert("연결");
		
		var form = $("#reply_form");
		var productID = $("#productID").val();
		var likeRating = $("#likeRating").val();
		var repCon = $("#repCon").val();
		
		var data = {
					productID : productID,
					likeRating : likeRating,
					repCon : repCon
				}
		
		$.ajax({
			url : "/detail/registReply",
			type : "post",
			data : data,
			success : function(){
				replyListPaging();
				reply_reset();
			}
			
			
		});
		
		
	});
	
	
	
});




/*스크롤 최상단*/	
function scroll_Top(){
	$('html').scrollTop(0);
}
/*스크롤 최하단*/
function scroll_Bottom(){
	$("html").scrollTop($(document).height());
};


//댓글 등록 버튼



/*
function reply_btn(){
	//alert("클릭");
	if($('#hidden_cartId').val() != null){
		$("#reply_form").attr("action","/detail/registReply");
		$("#reply_form").attr("method","post")
		$("#reply_form").submit();
	} else{
		alert("구매할 책을 선택해주세요.")
	}
	s
}

*/

//댓글 등록 이후 초기화
function reply_reset(){
	var likeRating = $("#likeRating");
	var repCon = $("#repCon");
	
	likeRating.val('');
	repCon.val('');
}










