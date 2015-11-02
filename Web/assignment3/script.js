$(document).ready(function(){
    $('#start').click(start);
    
    $('#stop').click(stop);
    
 $('#back').click(back);
    
    
  $('#left').click(left);
    
   $('#right').click(right);
    
     $('#top').click(top1);
    
    $('#bottom').click(bottom);
 
});

function start() {
	  $("#div1").stop().animate({left: '+=500px'},5000);
}


function stop() {
	  $("#div1").stop();
}

function back() {
	  $("#div1").stop().animate({left: '-=500px'},5000);
}

function left() {
	  $("#div1").stop().animate({left: '-=500px'},5000);
}

function right() {
	  $("#div1").stop().animate({left: '+=500px'},5000);
}

function top1() {
	  $("#div1").stop().animate({top: '-=500px'},5000);
}

function bottom() {
	  $("#div1").stop().animate({top: '+=500px'},5000);
}
