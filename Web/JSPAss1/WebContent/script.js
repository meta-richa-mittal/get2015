function activateSubmit() 
{

	if(document.getElementById("acceptCondition").checked == true)
	{
		document.getElementById("submitButton").disabled = false;
		
	}
	else 
	{
		document.getElementById("submitButton").disabled = true;
	}
}

function createCity() 
{
	var cityObject = document.getElementById("city");
	var stateObject = document.getElementById("state1");
	switch(stateObject.value) 
	{
		case "Rajasthan" :
			cityObject.innerHTML = "<option>Select City</option><Option>Ajmer</option><Option>Alwar</option><Option>Jaipur</option><Option>Kota</option>";
			break;
		case "MP" :
			cityObject.innerHTML = "<option>Select City</option><Option>Bhopal</option><Option>Gwalior</option><Option>Indore</option><Option>Jabalpur</option>";
			break;
		case "UP" :
			cityObject.innerHTML = "<option>Select City</option><Option>Agra</option><Option>Aligarh</option><Option>Ghaziabad</option><Option>Mathura</option>";
			break;
		case "Maharastra":
			cityObject.innerHTML = "<option>Select City</option><Option>Aurangabad</option><Option>Mumbai</option><Option>Pune</option><Option>Thane</option>";
			break;
		case "Select State":
			cityObject.innerHTML = "<option>Select City</option>";
			break;
	}
}


