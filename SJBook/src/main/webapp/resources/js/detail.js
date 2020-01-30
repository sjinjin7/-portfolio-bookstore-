
$(document).ready(function(){
//alert("연결");
//var productID ='<c:out value="${bd.productID}"/>';
//var productID = $(".uploadResult input").val();
//alert(productID);

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
	
	
});

