function createTable() {
	if(document.getElementById("textbox1").value=="") {
		alert("Please enter a value");
		return false;
	}
	var t2=document.getElementById("table2");
	var t3=document.getElementById("table3");
	t2.innerHTML="";
	t3.innerHTML="";
	t3.style.border="0px";
	var n=document.getElementById("textbox1").value;
	var row = t2.insertRow(-1);
	var cell1 = row.insertCell(0);
	var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2);
	cell1.innerHTML="Name";
	cell2.innerHTML="Min";
	cell3.innerHTML="Max";
	for(var i=0;i<n;i++) {
		var row = t2.insertRow(-1);
		var cell1 = row.insertCell(0);
		var cell2 = row.insertCell(1);
		var cell3 = row.insertCell(2);
		cell1.style.width="100px";
		cell2.style.width="50px";
		cell3.style.width="50px";
		var i1=document.createElement("input");
		i1.id="text"+i;
		i1.type="text";
		i1.style.width="100px";
		cell1.appendChild(i1);
		
		var i2=document.createElement("input");
		i2.id="min"+i;
		i2.type="number";
		i2.style.width="50px";
		i2.min="0";
		i2.max="10";
		cell2.appendChild(i2);
		
		var i3=document.createElement("input");
		i3.id="max"+i;
		i3.type="number";
		i3.style.width="50px";
		i3.min="0";
		i3.max="10";
		cell3.appendChild(i3);
		
	}
	var row = t2.insertRow(-1);
	var cell1 = row.insertCell(0);
	var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2);
	cell1.innerHTML="";
	var b2=document.createElement("button");
	b2.id="button2";
	b2.innerHTML="OK";
	cell2.appendChild(b2);
	cell3.innerHTML="";
	button2.onclick=function(){ 
		var f=createGraph();
	};
	//button2.onclick="createGraph()";
}


function createGraph() {
	var t2=document.getElementById("table2");
	var t3=document.getElementById("table3");
	var n=document.getElementById("textbox1").value;
	var count=0;
	
	for(var i=0;i<n;i++) {
		
		var min1=document.getElementById("min"+i).value;
		var max1=document.getElementById("max"+i).value;
		var min=parseInt(min1);
		var max=parseInt(max1);
		if(min>max) {
			count=1;
			alert("minimum value can not be greater than maximum value");
			document.getElementById("min"+i).style.borderColor="red";
			document.getElementById("min"+i).focus();
			break;
		}
	}
	
		
	
	if(count==0) {
		t3.style.border="solid 3px";
		
		for(var i=0;i<n;i++) {
			var index=0;
			var row = t3.insertRow(-1);
			row.id="r"+i;
			
			var cell1 = row.insertCell(0);
			cell1.id="cell"+i;
			
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			var cell4 = row.insertCell(3);
			var cell5 = row.insertCell(4);
			var cell6 = row.insertCell(5);
			var cell7 = row.insertCell(6);
			var cell8 = row.insertCell(7);
			var cell9 = row.insertCell(8);
			var cell10 = row.insertCell(9);
			var cell11 = row.insertCell(10);
			var cell12 = row.insertCell(11);
			
			cell1.style.width="100px";
			cell2.style.width="30px";
			cell3.style.width="30px";
			cell4.style.width="30px";
			cell5.style.width="30px";
			cell6.style.width="30px";
			cell7.style.width="30px";
			cell8.style.width="30px";
			cell9.style.width="30px";
			cell10.style.width="30px";
			cell11.style.width="30px";
			cell12.style.width="30px";
			
			
			cell1.style.height="30px";
			cell2.style.height="30px";
			cell3.style.height="30px";
			cell4.style.height="30px";
			cell5.style.height="30px";
			cell6.style.height="30px";
			cell7.style.height="30px";
			cell8.style.height="30px";
			cell9.style.height="30px";
			cell10.style.height="30px";
			cell11.style.height="30px";
			cell12.style.height="30px";
			
			
			var r=document.getElementById("r"+i);
			r.style.border="solid thin black";
			var c=document.getElementById("cell"+i);
			c.style.border="thin solid black";
			cell1.innerHTML=document.getElementById("text"+i).value;
			
			var min=document.getElementById("min"+i).value;
			var max=document.getElementById("max"+i).value;
			if(min!="" && max!="") {
				var lower=++min;
				var upper=++max;
				for(var j=lower;j<=upper;j++) {
					
					r.cells[j].style.backgroundColor = "red";
					
				}
			}
			
			
			
		}
		var butt2=document.getElementById("button2");
		butt2.disabled=true;
	}
	
}
