
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
	} 
	// lastName Validation
	else if(document.getElementById("lastName").value.trim() == "") 
	{
		count=1;
		alert("Last Name Is Empty");
	}
	// Password Verfication
	else if(document.getElementById("password").value.length < 8 )
	{
		count=1;
		alert("Password Length should be greater than 8");
	}
	// Selecting the State and City
	else if(document.getElementById("state") == "Select State" || document.getElementById("city").value == "Select City" ) 
	{
		count=1;
		alert("State or City are not Selected!!");
	}
	// Matching Password and Confirm Password
	else if(document.getElementById("password").value != document.getElementById("confirmPassword").value) 
	{
		count=1;
		alert("Passwords do not match!!");
	}
	
	
	// Checking the Conditions if user created or not
	if(count==0)
	{
		alert("USER CREATED SUCCESSFULLY!!");
	}
	else 
	{
		alert(document.getElementById("textBox").value);
	}
	
}
// function to create The city
function createCity() 
{
	var cityObject = document.getElementById("city");
	var stateObject = document.getElementById("state");
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