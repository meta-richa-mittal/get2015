
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
		<style>
		
			body {
				background-color: LightGray;
			}
			
			header {
				background-color: gray;
				height: 50px;
				width: 300px;
				margin: auto;
				margin-top: 100px;
				border-top-left-radius: 10px;
				border-top-right-radius: 10px;
				border-bottom: maroon 3px solid;
				text-align: center;
			}
			
			p {
				color: white;
				font-weight: bold;
				font-size: 30px;
				padding: 5px;
			}
			
			table {
				height: 350px;
				width: 300px;
				margin: auto;
				margin-top: 0px;
				background-color: white;
				
				
			}
			
			table td {
				text-align: center;
			}
			
			input {
				height: 30px;
				width: 250px;
				border-radius: 5px;
				
			}
			
			button {
				font-weight: bold;
				background-color: maroon;
				color: white;
				height: 30px;
				width: 100px;
			}
			
			#close {
				padding: auto;
				color: white;
				font-weight: normal;
				text-decoration: none;
				padding-left: 150px;
				font-size: 25px;
				font-family: Arial;
			}
			
			#pwd {
				text-decoration: none;
				color: black;
			}
			
			div {
				text-align: center;
				color: red;
			}
		</style>
</head>
<body>
		<div>
			<% 
				String message = (String)request.getAttribute("message"); 
				if(message != null) {
					out.println(message);
				}
			%>
		</div>
	<header>
	
		<p>Login <a id="close" href="/CaseStudyPhase4/view/index.jsp">X</a></p>
		
	</header>
	<section>
	<form action="/CaseStudyPhase4/LoginController" method="post">
		<table>
			<tr>
				<td><input type="email" id="email" name="userId" placeholder="Email" required></td>
			</tr>
			
			<tr>
				<td><input type="password" id="password" name="pwd" placeholder="Password" required></td>
			</tr>
			<tr>
				<td><button>Login</button><br><br><a id="pwd" href="/CaseStudyPhase4/view/admin.jsp">Forgot Password ?</a></td>
			</tr>
		</table>
		</form>
	</section>
	
</body>
</html>