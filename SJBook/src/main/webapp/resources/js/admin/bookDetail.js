$(document).ready(function(){
	//alert("연결");
	
	
	//로그인 버튼 누르면 로그인 페이지로 이동
	$(".top_1_login_button").on("click", function(e){
		alert("연결");
		$(location).attr('href', 'login');
	});
	
	
	//책가격 입력시 실시간 감지후 할인율/적립포인트 값 넣기
	$("#discountRate").on('propertychange change keyup paste input', function(){
	
		if($('#bookPrice').val() != 0){
		//책가격
		var bPrice = $('#bookPrice').val();
		bPrice = parseFloat(bPrice);
		//할인율
		var dRate = $('#discountRate').val();
		dRate = parseFloat(dRate);
		//할인된 가격
		var dPrice;
		//적립포인트
		var dPoint;
		
		dPrice = bPrice * ((100-dRate)/100);
		dPoint = dPrice * 0.05;
		dPoint = Math.round(dPoint/10) * 10;
		$('#sellprice').val(dPrice);
		$('#bookPoint').val(dPoint);
		}
	});
	//할인율 입력시 실시간 감지후 할인율/적립포인트 값 넣기
	$("#bookPrice").on('propertychange change keyup paste input', function(){
		if($('#discountRate').val() != 0){
		//책가격
		var bPrice = $('#bookPrice').val();
		bPrice = parseFloat(bPrice);
		//할인율
		var dRate = $('#discountRate').val();
		dRate = parseFloat(dRate);
		//할인된 가격
		var dPrice;
		//적립포인트
		var dPoint;
		
		
		
		dPrice = bPrice * ((100-dRate)/100);
		dPoint = dPrice * 0.05;
		dPoint = Math.round(dPoint/10) * 10;
		$('#sellprice').val(dPrice);
		$('#bookPoint').val(dPoint);
		}
	});
	
	
	
	
	
	
	
	
	//업로드
	
	$("input[type='file']").change(function(e){
		
		var formData = new FormData();
		
		var inputFile = $("input[name='uploadFile']");
		
		var files = inputFile[0].files;
		
		console.log(files);
		
		//add filedate to formdata
		for(var i = 0; i < files.length; i++){
			if(!checkExtension(files[i].name, files[i].size)){
				return false;
			}
			formData.append("uploadFile", files[i]);
		}	
		//alert("ajax전");
	
		$.ajax({
			url: 'uploadAjaxAction',
			processData: false,
			contentType: false,
			data: formData,
			type: 'POST',
			dataType:'json',
			success: function(result){
				console.log(result);
				
				showUploadedFile(result);
				
				//$(".uploadDiv").html(cloneObj.html())
			}
		});//$.ajax
		//alert("ajax끝")
	});
	
	///////////////////////////
	
	function showUploadedFile(uploadResultArr){
		 
		if(!uploadResultArr || uploadResultArr.length == 0){return;}
		
		var uploadResult = $(".uploadResult ul");
		
		var str = "";
		 
		 $(uploadResultArr).each(function(i, obj){
			 //image type
			 if(obj.image){
				 
				 var fileCallPath = encodeURIComponent(obj.uploadPath + "/s_"+obj.uuid + "_"+obj.fileName);
				 
				 str += "<li data-path='"+obj.uploadPath+"'";
				 str += " data uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='" + obj.image+"' data-type='"+obj.image+"'"; 
				 str += "><div>";
				 str += "<span> " + obj.fileName + "</span>";
				 str += "<button type='button' data-file=\'"+fileCallPath+"\' data-type = 'image' class='btn btn-warning btn-circle'  ><i class='fa fa-times'>x</i></button><br>";
				 str += "<img src = 'display?fileName=" + fileCallPath + "'>";
				 str += "</div>";
				 str += "</li>";
				 
				 	
				 console.dir(obj);
				 
				 str += "<input type='hidden' name='bCover[" + i + "].fileName' value='" +obj.fileName +"'>";
				 str += "<input type='hidden' name='bCover[" + i + "].uuid' value='" + obj.uuid +"'>";
				 str += "<input type='hidden' name='bCover[" + i + "].uploadPath' value='" +obj.uploadPath+"'>";
				 str += "<input type='hidden' name='bCover[" + i + "].image' value='" +obj.image+"'>";
				 
			 }else{
				 
				 var fileCallPath = encodeURIComponent( obj.uploadPath + "/" + obj.uuid + "_" + obj.fileName);
				 
				 var fileLink = fileCallPath.replace(new RegExp(/\\/g),"/");
				 
				 str += "<li" ;
				 str += "data-path='"+obj.uploadPath + "' data-uuid='"+obj.uuid + "' data-filename='"+obj.fileName+"' data-type='"+obj.image+"'";
				 str +=	"><div>";
				 str += "<span>" + obj.fileName + "</span>";
				 str += "<button type = 'button' data-file=\'"+fileCallPath+"\' data-type = 'file' class ='btn btn-warning btn-circle'><i class='fa fa-times'>x</i></button><br>";
				 str += "<img src='../resources/img/attach.png'></a>";
				 str += "</div>";
				 str += "</li>";
				 
				 
				
				 console.dir(obj);
				 
				 str += "<input type='hidden' name='bCover[" + i + "].fileName' value='" +obj.fileName +"'>";
				 str += "<input type='hidden' name='bCover[" + i + "].uuid' value='" + obj.uuid +"'>";
				 str += "<input type='hidden' name='bCover[" + i + "].uploadPath' value='" +obj.uploadPath+"'>";
				 str += "<input type='hidden' name='bCover[" + i + "].image' value='" +obj.image+"'>";
				 
				 
				 
				 
				 
			 }
			 
		 });
		
		 uploadResult.append(str);
		 
	}//function showUploadedFile끝	
	
	
	
	
	
	
	
	
	
	  //업로드 파일 삭제 메서드
	  $(".uploadResult").on("click", "button", function(e){
		 console.log("delete file"); 
		 
			var targetFile = $(this).data("file");
			var type = $(this).data("type");
			
			var targetLi = $(this).closest("li");
			
			$.ajax({
				url : 'deleteFile',
				data : {fileName: targetFile, type:type},
				dataType:'text',
				type:'POST',
					success: function(result){
						alert(result);
						targetLi.remove();
					}
				
				
				
			});//$.ajax
		 
		 
	  });	
	
	

	  
	  
	  //이미지 보이기
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



//파일 형식 검사
 var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
 var maxSize = 5242880;

function checkExtension(fileName, fileSize){
  
  if(fileSize >= maxSize){
	  alert("파일 사이즈 초과");
	  return false;
  }
  
  if(regex.test(fileName)){
	  alert("해당 종류의 파일은 업로드할 수 없습니다.");
	  return false;
  }
  return true;
}// checkExtension 끝






/*제품 등록 버튼*/
function enroll_btn(){
	//alert("클릭");
	//if($('#hidden_cartId').val() != null){
		$("#bookDetail_form").attr("action","/admin/enroll");
		$("#bookDetail_form").submit();
	/*	
	} else{
		alert("구매할 책을 선택해주세요.")
	}
	*/
}



/*작가 검색 팝업창 띄우기*/
function authorr_search(){
	
	var popUrl = "authorSearch";
	var popOption = "width =650px, height=550px, resizable=no, location= no, top=300px, ;eft=300px"
		window.open(popUrl, "작가 검색", popOption);
	
}








