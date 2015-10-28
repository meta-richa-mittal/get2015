$(document).ready(function(){
    
	$('#show').click(fnShow);
    
	
	$('#hide').click(fnHide);
    
    
    
    $('#alter').click(toggle);
    
});

function fnShow() {
	 $("span").show();
     $('#alter').attr("value","HIDE");
}


function fnHide() {
	$("span").hide();
    $('#alter').attr("value","SHOW");
}


function toggle() {
	if($('#alter').attr("value") == "HIDE") {
 	   $("span").hide();
        $('#alter').attr("value","SHOW");
    }
    else if($('#alter').attr("value") == "SHOW") {
 	   $("span").show();
        $('#alter').attr("value","HIDE");
    }
}