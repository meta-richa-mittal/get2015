function show() {
		var span = document.getElementById("data");
		var alterButton = document.getElementById("alter");
		span.style.display ="inline";
		alterButton.value = "HIDE";
	}
	
function hide() {
	var span = document.getElementById("data");
	var alterButton = document.getElementById("alter");
	span.style.display ="none";
	alterButton.value = "SHOW";
}
	
function toggle() {
	var span = document.getElementById("data");
	var alterButton = document.getElementById("alter");
	if(alterButton.value == "HIDE") {
		span.style.display ="none";
		alterButton.value = "SHOW";
	}
	else if(alterButton.value == "SHOW") {
		span.style.display ="inline";
		alterButton.value = "HIDE";
	}
}