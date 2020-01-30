<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script src="../resources/js/uploadAjax.js" type="text/javascript"></script>
<style>

.uploadResult {
	width:100%;
	background-color : gray;
}

.uploadResult ul{
	display:fles;
	fles-flow:row;
	justify-content:center;
	align-items:center;
}
.uploadResult ul li{
	list-style:none;
	padding: 10px;
	align-content: center;
	text-align: center;
}
.uploadResult ul li img{
	width : 200px;
}

.uploadResult ul li span{
	color:white;
}
.bigPictureWrapper{
	position: absolute;
	display: none;
	justify-content: center;
	align-items:center;
	top:0%;
	width:100%;
	height:100%;
	background-color: gray;
	z-index: 100;
	background:rgba(255,255,255,0.5);
}
.bigPicture{
	position: relative;
	display:flex;
	justify-content: center;
	align-items: center;
}
.bigPicture imf{
	width:600px;
}


</style>

</head>
<body>
<h1>uploadAjax</h1>
<div class = 'uploadDiv'>
	<input type = 'file' name = 'uploadFile' multiple>
</div>

<button id = 'uploadBtn'>Upload</button>
<div class='uploadResult'>
	<ul>
	
	</ul>
</div>


<div class = 'bigPictureWrapper'>
	<div class='bigPicture'>
	</div>
</div>



  

</body>
</html>