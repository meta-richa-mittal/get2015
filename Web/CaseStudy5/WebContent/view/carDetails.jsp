<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.car.model.Vehicle , java.util.*,javax.servlet.http.HttpServlet " %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
		
			body {
				background-color: LightGray;
			}
			
			section {
				margin: auto;
				width: 500px;
				background-color:white;
			}
			
			header {
				background-color: gray;
				height: 50px;
				width: 500px;
				margin: auto;
				margin-top: 100px;
				border-top-left-radius: 10px;
				border-top-right-radius: 10px;
				border-bottom: maroon 3px solid;
				text-align: center;
			}
		
			p {
				padding-top: 10px;
				color: white;
				font-family: lucida handwritting;
				font-weight: bold;
				font-size: 30px;
			}
			table {
				border-collapse: separate;
				margin: auto;
				padding-top: 20px;
				padding-bottom: 20px;
			}
			
			#button {
				text-align: center;
			}
			
			td {
				padding-top: 10px;
				padding-bottom: 10px;
			}
			
			button {
				color: white;
				background-color: maroon;
				font-weight: bold;
				width:80px;
				height:40px;
			}
		</style>
		
</head>
<body>
<center>
		<div id="message">
			<% 
				String message = (String)request.getAttribute("message"); 
				if(message != null) {
					out.println(message);
				}
			%>
		</div></center>
	<header><p><%
	
	if(request.getAttribute("vehicleDetails")==null) {
		response.sendRedirect("search.jsp");	
	}
	else {
	Vehicle vehicle = (Vehicle)request.getAttribute("vehicleDetails");
	

	
	
	out.print(vehicle.getMake()+"-"+vehicle.getModel()); %></p></header>
		<section>
		<form action="/CaseStudy5/CarEditController">
			<input type="text" style="visibility: hidden;"  name="id" value='<% out.print(vehicle.getId());%>'>
				<table>
					<tr>
						<td>Make:</td>
						<td><input type="text" readonly="readonly" name="make" value='<% out.print(vehicle.getMake());%>' pattern="[a-zA-Z ]+" required></td>
					</tr>
					
					<tr>
						<td>Model:</td>
						<td><input type="text" readonly="readonly" name="model" value='<% out.print(vehicle.getModel());%>' pattern="[a-zA-Z ]+" required></td>
					</tr>
					
					<tr>
						<td>EngineInCC:</td>
						<td><input type="number" name="engineInCc" value='<% out.print(vehicle.getEngineInCC());%>' min="0" max="4000" required></td>
					</tr>
					
					<tr>
						<td>FuelCapacity:</td>
						<td><input type="number" name="fuelCapacity" value='<% out.print(vehicle.getFuelCapacity());%>' min="0" max="200" required></td>
					</tr>
					
					<tr>
						<td>Mileage:</td>
						<td><input type="number" name="mileage" value='<% out.print(vehicle.getMilage());%>' min="1" max="100" required></td>
					</tr>
					
					<tr>
						<td>Ex-Showroom Price:</td>
						<td><input type="number" name="price" value='<% out.print(vehicle.getPrice());%>' min="0" max="100000000" required></td>
					</tr>
					
					<tr>
						<td>roadTax:</td>
						<td><input type="number" name="roadTax" value='<% out.print(vehicle.getRoadTax());%>' min="0" max="1000000" required></td>
					</tr>
					
					<tr>
						<td>onRoadPrice:</td>
						<td><input type="number" name="onRoadPrice" value='<% out.print(vehicle.getPrice()+vehicle.getRoadTax());%>' min="0" max="101000000" required></td>
					</tr>
					
					<tr>
						<td colspan="2" id="button">
						<% HttpSession s= request.getSession(false);
							if(s.getAttribute("userId")!=null) {%>
						<button id="buttonSave" name="saveButton" style="visibility: visible;">SAVE</button>
						<%} %>
						<button type="button" onClick="location.href='/CaseStudy5/view/search.jsp'" >BACK</button></td>
					</tr>
				</table>
			</form>
		</section>
		<%} %>
</body>
</html>