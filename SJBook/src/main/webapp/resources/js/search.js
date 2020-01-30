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
	
	
	
	
});
