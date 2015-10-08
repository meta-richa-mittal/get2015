
//Validation for Activating The Submit Button
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


// Validation for Checking all the conditions
function validate()
 {
	 
	var count=0;
	// First name Validation
	if(document.getElementById("firstName").value.trim() == "")
	{
		count=1;
		alert("First Name Is Empty");
		document.getElementById("firstName").style.borderColor="red";
		document.getElementById("firstName").focus();
		
		
	} 
	// lastName Validation
	else if(document.getElementById("lastName").value.trim() == "") 
	{
		count=1;
		alert("Last Name Is Empty");
		document.getElementById("lastName").style.borderColor="red";
		document.getElementById("lastName").focus();
	}
	// Password Verfication
	else if(document.getElementById("password").value.length < 8 )
	{
		count=1;
		alert("Password Length should be greater than 8");
		document.getElementById("password").style.borderColor="red";
		document.getElementById("password").focus();
	}
	//age verification
	else if(document.getElementById("age").value.trim() == "")
	{
		count=1;
		alert("Age is empty");
		document.getElementById("age").style.borderColor="red";
		document.getElementById("age").focus();
	}
	// Selecting the State
	else if(document.getElementById("state1").value == "Select State")
	{
		count=1;
		alert("State is not Selected!!");
		document.getElementById("state1").style.borderColor="red";
		document.getElementById("state1").focus();
	}
	// Selecting the City
	else if(document.getElementById("city").value == "Select City" ) 
	{
		count=1;
		alert("City is not Selected!!");
		document.getElementById("city").style.borderColor="red";
		document.getElementById("city").focus();
	}
	// Matching Password and Confirm Password
	else if(document.getElementById("password").value != document.getElementById("confirmPassword").value) 
	{
		count=1;
		alert("Passwords do not match!!");
		document.getElementById("confirmPassword").style.borderColor="red";
		document.getElementById("confirmPassword").focus();
	}
	
	
	
	// Checking the Conditions if user created or not
	if(count==0)
	{
		alert("USER CREATED SUCCESSFULLY!!");
		document.getElementById("firstName").value = "";
		document.getElementById("lastName").value = "";
		document.getElementById("password").value = "";
		document.getElementById("confirmPassword").value = "";
		document.getElementById("age").value = "";
		document.getElementById("state1").value = "";
		document.getElementById("city").value = "";
		document.getElementById("addressLine1").value = "";
		
		document.getElementById("firstName").style.borderColor="initial";
		document.getElementById("lastName").style.borderColor="initial";
		document.getElementById("password").style.borderColor="initial";
		document.getElementById("confirmPassword").style.borderColor="initial";
		document.getElementById("age").style.borderColor="initial";
		document.getElementById("state1").style.borderColor="initial";
		document.getElementById("city").style.borderColor="initial";
		document.getElementById("addressLine1").style.borderColor="initial";
		
		document.getElementById("acceptCondition").checked=false;
		document.getElementById("submitButton").disabled = true;
		
	}
	else 
	{
		alert(document.getElementById("textBox").value);
		document.getElementById("textBox").style.borderColor="red";
		document.getElementById("textBox").focus();
	}
	
}
// function to create The city
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
