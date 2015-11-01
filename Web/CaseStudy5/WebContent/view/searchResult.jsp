<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.car.model.Vehicle , java.util.* " %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
	
		body {
				background-color: Gray;
				background-image: url('images/car12.jpg');
				background-repeat: no-repeat;
				-webkit-background-size: cover;
				-moz-background-size: cover;
				-o-background-size: cover;
				background-size: cover;
		}
			
		.circle {
			-moz-border-radius: 50%;
			-webkit-border-radius: 50%;
			border-radius: 50%;
			width:200px;
			height:200px;   
			text-align: center;
			background-color: white;
		}
		
		img {
			height: 150px;
			width: 150px;
			border-radius: 15px;
		}
		
		#main {
			border: solid 2px white;
			border-radius: 15px;
			border-top-left-radius: 0px;
			border-top-right-radius: 0px;
		}
		section {
			margin: auto;
			width: 55%;
		}
		
		table {
			margin: auto;
			padding-top: 10px;
			padding-bottom: 10px;
		}
		
		.info {
			width:200px;
			height:200px;   
			text-align: center;
			color: white;
			font-family: cursive;
			font-weight: bold;
		}
		
		button {
			color: white;
			background-color: maroon;
			font-weight: bold;
			width:80px;
			height:40px;
		}
		
		#menu {
			background-color: white;
			height: 50px;
			margin: auto;
			border-top-left-radius: 15px;
			border-top-right-radius: 15px;
			border-bottom: gray 3px solid;
			text-align: center;
		}
		
		#button1 {
			float: left;
			margin-left: 15px;
			margin-top: 5px;
			background-color: maroon;
		}
		
		#button2 {
			float: right;
			margin-right: 15px;
			margin-top: 5px;
			background-color: maroon;
		}
		
		
	</style>
	</script>
</head>
<body>
		<section id="menu">
			
			<% HttpSession s= request.getSession(false);
							if(s.getAttribute("userId")!=null) {%>
		<button id="button1" onClick="location.href='/CaseStudy5/view/AdminHome.jsp'">HOME</button>
		<button id="button2" onClick="location.href='/CaseStudy5/LogoutController'">LOGOUT</button>
		<%} 
		else {%>
		<button id="button1" onClick="location.href='/CaseStudy5/view/search.jsp'">HOME</button>
		<% } %>
		</section>
		<section id="main">
		
			
					
					<%
					if(request.getAttribute("list")==null) {
						response.sendRedirect("search.jsp");	
					}
					else {
					List<Vehicle> listOfVehicles = (List<Vehicle>)request.getAttribute("list");
					if(listOfVehicles.size()==0) {%>
					<center><% out.println("No Cars Found!!");%></center>
						<%
					}
					else {
					for(Vehicle v : listOfVehicles)
					   {
						
							%>
				<section>
				<table>
					<tr>
							<td class="circle"><img src="/CaseStudy5/images/car4.jpg"></td>
							<td class="info"><%out.print(v.getMake()); %>-<%out.print(v.getModel()); %>
							<br><br><% out.println("<a href='/CaseStudy5/CarDetailController?id="
									+v.getId()+"'> VIEW</a>"); %></td>
			
							<% 
					   }
					}
							%>
					</tr>
				</table>
			</section>
			<%} %>
		
</body>
</html>