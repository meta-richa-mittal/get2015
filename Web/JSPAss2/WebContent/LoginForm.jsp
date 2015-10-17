
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Assignment 2</title>
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
<div style="text-align: center; color: red;"><%out.println();
		if((String)request.getAttribute("msg")!=null) {
			out.println((String)request.getAttribute("msg"));
		}%></div>
	<div id="header">
		<h2>Login Form</h2>
	</div>

	<div id="section">
		<form action="Form" method="post">
			<table align="center">
				<tr>
					<td><span id="span"> *</span>User Id:</td>
					<td><input type="email" id="emailId" name="emailId"></td>
				</tr>
				<tr>
					<td><span id="span"> *</span>Password:</td>
					<td><input type="password" id="password" name="password"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="Submit" value="Login"
						id="submitButton"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>