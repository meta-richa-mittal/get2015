
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Assignment 1</title>
</head>
<script type="text/javascript" src="script.js">
	
</script>
<style>
body {
	width: 40%;
	margin: auto;
	display: block;
	margin-top: 100px;
}

#header {
	padding: 1px;
	padding-left: 40px;
	color: white;
	background-color: gray;
}

#section {
	background-color: white;
	border: solid 2px gray;
	border-top: 0px;
}

table {
	border-collapse: separate;
	border-spacing: 0 1em;
}

#span {
	color: red;
}
</style>

<body>
	<div id="header">
		<h2>Registration Form</h2>
	</div>

	<div id="section">
		<form action="Form" method="post">
			<table align="center">
				<tr>
					<td><span id="span"> *</span>Name:</td>
					<td><input type="text" id="name" name="name"></td>
				</tr>
				<tr>
					<td><span id="span"> *</span>Email Id:</td>
					<td><input type="email" id="emailId" name="emailId"></td>
				</tr>
				<tr>
					<td><span id="span"> *</span>Password:</td>
					<td><input type="password" id="password" name="password"></td>
				</tr>
				<tr>
					<td><span id="span"> *</span>Re-enter Password:</td>
					<td><input type="password" id="confirmPassword"
						name="confirmPassword"></td>
				</tr>
				<tr>
					<td><span id="span"> *</span>Age:</td>
					<td><input type="number" id="age" name="age" step="any"></td>
				</tr>
				<tr>
					<td><span id="span"> *</span>State:</td>
					<td><Select id="state1" name="states" onchange="createCity()">
							<option value="Select State">Select State</option>
							<option value="MP">Madhya Pradesh</option>
							<option value="Maharastra">Maharastra</option>
							<option value="Rajasthan">Rajasthan</option>
							<option value="UP">Uttar Pradesh</option>
					</Select></td>
				</tr>
				<tr>
					<td><span id="span"> *</span>City:</td>
					<td><select id="city" name="cities">
							<option>Select City</option>
					</select></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><textarea id="addressLine1" name="address" rows="3"></textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="checkbox" id="acceptCondition"
						name="checkbox1" onChange="activateSubmit()"><label
						for="acceptCondition"> I Accept all the&nbsp;<a
							href="Registration.html">Terms & Conditions</a>
					</label></td>
				</tr>
				<tr>
					<td colspan="2"><input type="Submit" value="Create"
						id="submitButton" disabled></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>