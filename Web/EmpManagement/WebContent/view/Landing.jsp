<%@page import="com.sun.org.glassfish.gmbal.IncludeSubclass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Landing</title>
<style>
body {
	background: gray;
	text-align: center;
}

#header {
	
	color: white;
	
}

h2 {
	color: red;
}

</style>
</head>
<body>
	<h2>HOME PAGE</h2>
	<div id="header"><p>${heading}</p></div>
	 <a href="/EmpManagement/EmployeeListController">Employee List</a><br/><br/>
	 <a href="/EmpManagement/EmployeeRegistrationController">Employee Registration</a>
</body>
</html>