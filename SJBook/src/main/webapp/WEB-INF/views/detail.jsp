<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome! SJBook Store!</title>
<link rel="stylesheet" href="resources/css/detail.css">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script src="resources/js/detail.js" type="text/javascript"></script>
<script>
function replyListPaging(){
	
	//상품 댓글 띄우기
	//var productID = ${bd.productID};
	$.getJSON("/detail/replyList"+"?productID=${bd.productID}", function(data){
		var str="";
		var num = "";
		
		if(data == ""){
			return false;
		}
		
		
		$(data).each(function(i, obj){
			console.log("i="+i)
			console.log(obj);
			num = i;
			
			str += "<li data-productID='" + obj.productID +"'>"
			str	+= "<div class='userInfo'>"
			str	+= "<span class='userID'>" + obj.memberID + "</span>"
			str	+= "<span class='date'>" + obj.repDate + "</span>"
			str	+= "</div>"
			str += "<div class='like'><span class='likeRating'>"+ obj.likeRating+"</span>"
			str += "<div id='likeViewSection"+i+"'>"
			str += "<input type='hidden' id='starVal"+i+"' value='"+ obj.likeRating +"'>"
			str += "<span class='mark on' id='star0'>0.5점</span>"
			str += "<span class='mark2 on' id='star1'>1점</span>"
			str += "<span class='mark ' id='star2'>1.5점</span>"
			str += "<span class='mark2 ' id='star3'>2점</span>"
			str += "<span class='mark ' id='star4'>2.5점</span>"
			str += "<span class='mark2 ' id='star5'>3점</span>"
			str += "<span class='mark ' id='star6'>3.5</span>"
			str += "<span class='mark2 ' id='star7'>4점</span>"
			str += "<span class='mark ' id='star8'>4.5점</span>"
			str += "<span class='mark2 ' id='star9'>5점</span>"
			str += "</div>"
		
			str += "<br>"
			str += "</div>"
				str += "<br>"
			str	+= "<div class='replyContent'>" + obj. repCon + "</div>"
			
			str += "<div class='replyFooter'>"
			str += "<button type='button' class='modify' data-productID='" + obj.productID +"' data-repCon = '"+obj. repCon +"' data-repNum='" + obj.repNum + "'>수정</button>"
			str += "<button type='button' class='delete' data-repNum='" + obj.repNum + "'>삭제</button>"
			str += "</div>"
			str	+= "</li>";
			
			//alert(i);
			
			
			
		});
		
		$('#book_reply>ul').html(str);
		num += 1;
		//alert("num" + num)
		for(var a = 0; a <num; a++){
			//alert("a" + a)
			starView(a)
		}
	});
	
}

//리뷰 별점 보이기
function starView(i){
	//alert(i);
	var idx = $('#starVal'+i).val();
	//alert(idx);
	idx = parseFloat(idx);
	if(idx-0.5<0){
		idx = 0;
	} else{
		idx = (idx-0.5)/0.5;	
	}
	//alert(idx);
	var a = $('#likeViewSection' +i).find('#star'+idx).addClass('on').prevAll('span').addClass('on');
	 //$('.likeViewSection').find('span').index(idx).addClass('on').prevAll('span').addClass('on');
	}


</script>








</head>
<body>

<div id="wrap">
	<div id="top_mini">
		<div id="top_mini_1">
			<jsp:include page="include/top_mini.jsp">
				<jsp:param name="member" value="${member}" />
			</jsp:include>
		</div>
	</div>
	<!-- 상단부(로고, 검색창, 로그인창) -->
	<div id="top">
		<div id="top_1">
			<div id="top_1_logo">
				<div id="top_1_logo_1">
					<a href="/main"><img src="resources/img/logo.png"></a>
				</div>
			</div>
			<div id="top_1_selection">
				<div id="top_1_selection_1">
					<jsp:include page="include/searchBox.jsp"></jsp:include>
				</div>
			</div>
			<div id="top_1_login">
				<jsp:include page="include/top_login.jsp">
					<jsp:param name="member" value="${member}" />
				</jsp:include>
			</div>
		</div>
	</div>
	
	
	
	<div id="sub_top">
		<div id="sub_top_1">
			<div id="sub_top_1_ad">
			광고
			</div>
		</div>
	</div>
	
	
	<div id="detail_middle">
		<div id="detail_middle_container">
			
			<div id="cover">
				<div id="image">
					이미지

				</div>
				<a href="#" id="imageBig">크게보기</a>
			</div>
			<div id="title">
				<h1><strong>${bd.title}</strong></h1>
				<div> <strong>${bd.authorName}</strong> 지음 <span>|</span> <strong>${bd.publisher}</strong> <span>|</span> ${bd.publeYear}</div>
			</div>	
			<div id="purchase">
				<c:set value="${bd.bookPrice- bd.discountPrice}" var="dc"></c:set>
				<div id="purchase_money1">정가 : <strong><fmt:formatNumber value="${bd.bookPrice }" pattern="#,###"/> 원</strong></div><br>
				<div id="purchase_money2">판매가 : <span><fmt:formatNumber value="${bd.discountPrice }" pattern="#,###"/></span> <strong>원 [${bd.discountRate}%, ${dc }할인]</strong></div><br>
				<div id="purchase_point">적립포인트 : <fmt:formatNumber value="${bd.bookPoint}" pattern="#,###"/> point</div><br>
				<div id="purchase_btn">
					<a id="cart_btn">장바구니 담기</a>
					<a id="buy_btn">바로 구매</a> 
				</div>
			</div>
			
			<div id="side_right_ad">
				<jsp:include page="include/rightSideAd.jsp"></jsp:include>
			</div>
			<div id="side_left_ad">
				<jsp:include page="include/leftSideAd.jsp"></jsp:include>
			</div>		
			
		</div>
	</div>
	



		
	<div id="detail_main">
		<div id="detail_main_container">
			<div id="book_intro_wrapper">
				<div id="book_intro_subject">
					<span>책소개</span>
				</div>
				<div id="book_intro_con">
					${bd.contents }
				</div>
			</div>
			<div id="author_intro_wrapper">
				<div id="author_intro_subject">
					<span>작가소개</span>
				</div>
				<div id="author_intro_con">
					<div id="author_intro_con_name">
						<span>작가 : <strong>${bd.authorName}</strong></span>
					</div>
					<div id="author_intro_con_intro">
						${bd.authorIntro }
					</div>
					<br>
				</div>
			</div>
		</div>
	</div>
	

	<div id="detail_reply">
		<div id="detail_reply_container">
			<div id="detail_reply_container_subject"><span>평점/리뷰</span></div>
			<div id="book_reply">
				<ul>
					<li class=emptyReply>리뷰가 없습니다.</li>
				</ul>
			</div>
			<script>
		
			replyListPaging();
			
			</script>
			
			<script>
			
				$(document).on("click",".delete", function(){
					var data = {repNum : $(this).attr("data-repNum")};
					
					/* alert($(this).attr("data-repNum")); */
					
					var deleteConfirm = confirm("정말 삭제 하시겠습니까?");
					if(deleteConfirm){
					
						$.ajax({
							url : "/detail/deleteReply",
							type : "post",
							data : data,
							success : function(result){
								alert(typeof(result));
								alert("result = " + result);
								if(result == 'success'){
									replyListPaging();
									
									console(result);
								} else if(result == 'fail'){
									alert("작성자 본인만  삭제 할 수 있습니다.");
								}
								
							},
							error : function(){
								alert("로그인 하셔야합니다.");
							}
						});
					}
				});
			
			</script>
			<script>
			$(document).on("click", ".modify", function(){
				 $("#replyModifyWrapper").attr("style", "display:block;");
				 
				var repNum = $(this).attr("data-repNum");
				var repCon = $(this).attr("data-repCon"); 
				var productID = $(this).attr("data-productID");
				//alert(repNum);
				$('#replyModify_content_text textarea').html(repCon);
				$('#replyModify_btn').attr("data-repNum", repNum);
				$('#replyModify_btn').attr("data-productID", productID);
				 
				 
				 
			});
			</script>
			<!-- 댓글쓰기 -->
			<c:if test="${member == null}">
				<div id="replyWarning">
					<div id="replyWarning_subject">
						평점/리뷰 등록
					</div>
					<div id="replyWarning_content">
						로그인후 리뷰 등록 가능합니다.
					</div>
				</div>
				
			</c:if>
			
			<c:if test="${member != null}">
				<div id="replyRegist">
					<div id="replyRegist_subject">
						평점/리뷰 등록
					</div>
					<div id="replyRegist_content">
						<input type="hidden" name="productID" id="productID" value="${bd.productID}">
						<form id="reply_form">
						<div id="replyRegist_content_likeStar">
							평점 :
							<div id="likeStar_section">
								<a href="#" class="mark on">0.5점</a>
								<a href="#" class="mark2 on">1점</a>
								<a href="#" class="mark ">1.5점</a>
								<a href="#" class="mark2 ">2점</a>
								<a href="#" class="mark ">2.5점</a>
								<a href="#" class="mark2 ">3점</a>
								<a href="#" class="mark ">3.5</a>
								<a href="#" class="mark2 ">4점</a>
								<a href="#" class="mark ">4.5점</a>
								<a href="#" class="mark2 ">5점</a>
								
								<input type="hidden" name="likeRating" id="likeRating">	
							</div>
							
						</div>
						<div id="replyRegist_content_text">
							<span>리뷰 : </span>
							<br>
							<textarea rows="" cols="" name="repCon" id="repCon"></textarea>
						</div>
						</form>
						<div id="replyRegist_content_btn"> 
							
							<a id="reply_btn">리뷰 등록</a>
							
						</div>
						
					</div>
				</div>
			</c:if>
			
			
		</div>
	</div>
	
	
	
		<div id="footer_nav">
		<div id="footer_nav_container">
			<ul>
				<li>회사소개</li>
				<span class="line">|</span>
				<li>이용약관</li>
				<span class="line">|</span>
				<li>고객센터</li>
				<span class="line">|</span>
				<li>광고문의</li>
				<span class="line">|</span>
				<li>채용정보</li>
				<span class="line">|</span>
			</ul>
		</div>
	</div>
	
	<div id="footer">
		<div id="footer_container">
			
			<div id="footer_left">
				<img src="resources/img/mlogo.png">
			</div>
			<div id="footer_right">
				(주) SJBook  울산광역시 삼산동 그린아카데미  대표이사 : OOO
				<br>
				사업자등록번호 : ooo-oo-ooooo
				<br>
				<strong>대표전화 : oooo-oooo(발신자 부담전화)</strong>
				<br>
				<br>
				COPYRIGHT(C) <strong>SJBook</strong>	ALL RIGHTS RESERVED.
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>

	

<div id="replyModifyWrapper">
	<div id="replyModifyWrapper_content">
		<div id="replyModify_subject">
							평점/리뷰 수정
		</div>
		<div id="replyModify_content">
			
			<div id="replyModify_content_likeStar">
				평점 
				<br>
				<div id="likeStar_section">
					<a href="#" class="mark on">0.5점</a>
					<a href="#" class="mark2 on">1점</a>
					<a href="#" class="mark ">1.5점</a>
					<a href="#" class="mark2 ">2점</a>
					<a href="#" class="mark ">2.5점</a>
					<a href="#" class="mark2 ">3점</a>
					<a href="#" class="mark ">3.5</a>
					<a href="#" class="mark2 ">4점</a>
					<a href="#" class="mark ">4.5점</a>
					<a href="#" class="mark2 ">5점</a>
					
					<input type="hidden" name="likeRating" id="likeRating">	
				</div>
				
			</div>
			<div id="replyModify_content_text">
				<span>리뷰 : </span>
				<br>
				<textarea rows="" cols="" name="repCon" id="repCon"></textarea>
			</div>
			
			<div id="replyModify_content_btn"> 
				<a id="replyModify_btn">리뷰 수정</a>
				<a id="modifyCancel_btn">수정 취소</a>
				
			</div>
			
		</div>
	</div>
	<div id="replyModifyWrapper_background"></div>
<script>

	$("#modifyCancel_btn").click(function(){
	 $("#replyModifyWrapper").attr("style", "display:none;");
	});

	$("#replyModify_btn").on("click",function(){
		
		var modifyConfirm = confirm("정말로 수정하시겠습니까?");
		
		var repNum = $(this).attr("data-repNum");
		var likeRating = $('#replyModify_content_likeStar #likeRating').val();
		var repCon = $('#replyModify_content_text textarea').val();
		var productID = $(this).attr("data-productID");
		
		
		if(modifyConfirm){
		
			var data = {
					repNum : repNum,
					likeRating : likeRating,
					repCon : repCon,
					productID : productID
					
			}
			//alert(data.repCon);
			
			$.ajax({
				url : "/detail/modifyReply",
				type : "post",
				data : data,
				success : function(result){
					
					if(result == 'success'){
						replyListPaging();
						$("#replyModifyWrapper").attr("style", "display:none;");
						console(result);
						alert("수정완료");
					} else {
						alert("작성자 본인만 수정 할 수 있습니다.");
					}
				}, 
				error : function(){
					alert("로그인하셔야합니다.");
				}
				
				
			});
			
		}
		
	});

	
	
	//이미지 넣기
	(function(){
		var productID = ${bd.productID};
		//alert(productID);
		$.getJSON("getBcover",{productID:productID}, function(arr){
			console.log(arr);
			
			var str = "";
			$(arr).each(function(i, attach){
			
				var fileCallPath = encodeURIComponent(attach.uploadPath + "/"+attach.uuid + "_"+attach.fileName);
				
				str += "<img src='display?fileName="+fileCallPath+"' data-path='" + attach.uploadPath+"' data-uuid='"+attach.uuid+"' data-filename='"+attach.fileName+"' data-type='" + attach.image+"'>";
				
				return false;
			});
			
			$("#image").html(str);
			
		});// end getJSON
		
	})();// end function
	
	
	
	
	
	
</script>
</div>
<!-- 이미지확대 -->
<div class = 'bigPictureWrapper'>
	<div class='bigPicture'>
	</div>
</div>	
</body>
</html>