<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="model.Employee , java.util.* " %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
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

table {
	color: white;
	text-align: left;
	
}
</style>

</head>
<body>

	<h2>${heading}</h2>
	
	<% Employee emp = (Employee) request.getAttribute("employee");
	%>
	
	
	<table align="center">
	<tr><td>EmpId:</td><td><% out.println(emp.getEmployeeId());%></td></tr>
	<tr><td>Name:</td><td><% out.println(emp.getName());%></td></tr>
	<tr><td>Email:</td><td><% out.println(emp.getEmail());%></td></tr>
	<tr><td>Age:</td><td><% out.println(emp.getAge());%></td></tr>
	<tr><td>Date Of Registration:</td><td><% out.println(emp.getDor());%></td></tr>
	</table>
	<a href="/EmpManagement/LandingController">Landing Page</a><br/><br/>
</body>
</html>