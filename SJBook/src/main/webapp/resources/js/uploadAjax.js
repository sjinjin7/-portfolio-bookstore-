			
			// 이미지 클릭시 원본파일 보여주기
			function showImage(fileCallPath){
				
				//alert(fileCallPath);
				
				$(".bigPictureWrapper").css("display","flex").show();
				
				$(".bigPicture").html("<img src='display?fileName="+encodeURI(fileCallPath)+"'>").animate({width:'100%', height: '100%'}, 1000);
				
			}
			
			
			
			
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
			
				// input uploadfile 초기화시키기
				var cloneObj = $(".uploadDiv").clone();
			  
			  
				$(document).ready(function(){
					alert("연결");
					$("#uploadBtn").on("click", function(e){
						
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
								
								$(".uploadDiv").html(cloneObj.html())
							}
						});//$.ajax
						//alert("ajax끝")
					});
					
					
					
					//uploadResult(웹에 이미지 보여주는 부분)
					var uploadResult = $(".uploadResult ul");
					
						function showUploadedFile(uploadResultArr){
							 var str = "";
							 
							 $(uploadResultArr).each(function(i, obj){
								 if(!obj.image){
									 
									 var fileCallPath = encodeURIComponent( obj.uploadPath + "/"+obj.uuid+"_"+obj.fileName);
									 
									 str += "<li><a href='download?fileName="+fileCallPath+"'>"+"<img src= '../resources/img/attach.png'>" + obj.fileName + "</a>"
									 +"<span data-file=\'"+fileCallPath + "\' data-type='file'>x</span>"
									 +"</li>";
									 
									 
								 }else{
									 
									 //str += "<li>" + obj.fileName + "</li>";
									 
									 var fileCallPath = encodeURIComponent( obj.uploadPath + "/s_"+obj.uuid+"_"+obj.fileName);
									 
									 var originPath = obj.uploadPath + "//" +obj.uuid+"_"+obj.fileName;
									 
									 originPath = originPath.replace(new RegExp(/\\/g),"/");
										 
									 
									 str += "<li><a href=\"javascript:showImage(\'"+originPath + "\')\"><img src='display?fileName="+fileCallPath+"'></a>"
									 +"<span data-file=\'"+fileCallPath + "\' data-type='image'>x</span>"
									 +"<li>";
									 
									 
									 
									 
									 
								 }
								 
							 });
							
							 uploadResult.append(str);
							 
						}//function showUploadedFile끝
					
					
					//확대된 이미지 클릭시 다시 닫기
					$(".bigPictureWrapper").on("click",function(e){
						$(".bigPicture").animate({width:'0%', height: '0%'},1000);
						setTimeout(() => {
							$(this).hide();
						}, 1000);
						
						
					});
						
					// x 누르면 삭제처리하도록
					$(".uploadResult").on("click", "span", function(e){
						
						var targetFile = $(this).data("file");
						var type = $(this).data("type");
						console.log(targetFile);
						
						$.ajax({
							url : 'deleteFile',
							data : {fileName: targetFile, type:type},
							dataType:'text',
							type:'POST',
								success: function(result){
									alert(result);
								}
							
							
							
						});//$.ajax
						
						
						
					});
					
					
					
					
					
					
					
					
					
				});
			