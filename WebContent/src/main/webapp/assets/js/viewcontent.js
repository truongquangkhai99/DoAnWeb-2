
$(document).ready(function () { 
	var timeDelay = 5000;  	
	setTimeout( function (){
    		$(".view-content").removeClass("hide");
    		$(".loading").addClass("hide");
    	}, timeDelay);
	
	$("#page-${pageid}").addClass("page-current");
});	
   
