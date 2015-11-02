$(document).ready(init);

function init() {
	temp="";
	temp = $('#details').text();
	$('input#name').change(name);
	$('input#age').change(age);
	$('textarea#address').change(address);
	
}

function name() {
	$('#name').animate({backgroundColor: "red"}, 1000);
	temp = temp.concat(" Name:  "+$('input#name').val()+"<br/>");
	document.getElementById("details").innerHTML = temp;
	$('#name').animate({backgroundColor: "white"}, 1000);
}

function age() {
	$('#age').animate({backgroundColor: "red"}, 1000);
	temp = temp.concat(" Age:  "+$('input#age').val()+"<br/>");
	document.getElementById("details").innerHTML = temp;
	$('#age').animate({backgroundColor: "white"}, 1000);
}

function address() {
	$('#address').animate({backgroundColor: "red"}, 1000);
	temp = temp.concat(" Address:  "+$('textarea#address').val()+"<br/>");
	document.getElementById("details").innerHTML = temp;
	$('#address').animate({backgroundColor: "white"}, 1000);
}