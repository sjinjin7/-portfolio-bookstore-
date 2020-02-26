
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
	
	///////////// 실패
	
	
	var formObj = $("form[role='form']");
	
	$("button[type='submit']").on("click", function(e){
		e.preventDefault();
		
		console.log("submit clicked");
		
		var str = "";
		
		$(".uploadResult ul li").each(function(i, obj){
	
			 console.dir(obj);
			 
			 str += "<input type='hidden' name='bCover[" + i + "].fileName' value='" +obj.fileName +"'>";
			 str += "<input type='hidden' name='bCover[" + i + "].uuid' value='" + obj.uuid +"'>";
			 str += "<input type='hidden' name='bCover[" + i + "].uploadPath' value='" +obj.uploadPath+"'>";
			 str += "<input type='hidden' name='bCover[" + i + "].fileType' value='" +obj.image+"'>";
			 
			
			
		});// $(".uploadResult ul li").each(function(i, obj)
		
		formObj.append(str).submit();
	}); //  $(".uploadResult").on("click", "button", function(e){
	
});