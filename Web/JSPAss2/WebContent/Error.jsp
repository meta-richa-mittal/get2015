<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Error</title>
</head>
<style>

body {
	background: gray;
}
#header {
	text-align: center;
	color: white;
	
}
</style>

<body>
	<div id="header">
		<h2><%=request.getAttribute("errorMsg") %></h2>
		<br>
		<b>Exception is:&nbsp;&nbsp;<%=request.getAttribute("errorInfo") %></b>
	</div>