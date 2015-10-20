<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="Error.jsp" isErrorPage="true"%>
    <%@ page import="model.Employee , java.util.* " %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Registration</title>
<style>
body {
	background: gray;
	text-align: center;
	
}

#header {
	
	color: white;
	
}

table {
	text-align: left;
	color: white;
}

h2 {
	color: red;
}

</style>
</head>
<body>

	<h2>${heading}</h2>
	<% Employee e = null; 
		e=  (Employee)request.getAttribute("employee");
	%>
	
	<form name="register" action="/EmpManagement/EmployeeRegistrationController?editId='"+request.getParameter("id")+"'">
		
		<table align="center">
		<tr>
			<td>Name &nbsp; :</td>
			<td><input type="text" name="name" 
		<%  
		if(e!=null) {
			out.println("value='"+e.getName()+"'");
			String id = request.getParameter("id");

			//request.setAttribute("editId", id);
			//System.out.println("jhvdah = "+url);
			
		}
			%>><br/></td>
		</tr>
		
		<tr>
			<td>Email &nbsp; :</td>
			<td><input type="email" name="email" 
		<% 
		if(e!=null) {
			out.println("value='"+e.getEmail()+"'");
		}
			%> /><br/></td>
		</tr>
		
		<tr>
			<td>Age &nbsp; :</td>
			<td><input type="number" name="age" min = "1" max = "100" step = "1" 
		<% 
		if(e!=null) {
			out.println("value='"+e.getAge()+"'");
		}
			%>  /><br/></td>
		</tr>
		
		<tr>
			<td>Date Of Registration &nbsp; :</td>
			<td><input type="text" name="dor"
		<%
		if(e!=null) {
			out.println("value='"+e.getDor()+"'");
		}
		%> /><br/></td>
		</tr>
		
		
		<tr><td colspan="2"><input type="text" name="editId" <%
		if(e!=null) {
			out.println("value='"+e.getEmployeeId()+"'");
		}
		%>style="visibility: hidden;" /></td></tr>
		
		<tr><td colspan="2"><input type="submit" name="submit" value="Submit" /><br/></td></tr>
		
		</table>
		
	</form>
</body>
</html>