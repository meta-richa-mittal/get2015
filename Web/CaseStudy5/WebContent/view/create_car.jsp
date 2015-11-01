<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New Car</title>
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
<form action="/CaseStudy5/CreateCar" method="post">
	<center>
		<div id="message">
			<% 
				String message = (String)request.getAttribute("message"); 
				if(message != null) {
					out.println(message);
				}
			%>
		</div>
		<table>
					<tr>
						<td>Vehicle Id:</td>
						<td><input type="text" placeholder="VehicleId" pattern="[a-zA-Z0-9 ]+" name="id" required></td>
					</tr>
					
					<tr>
						<td>Make:</td>
						<td><input type="text" placeholder="Make" pattern="[a-zA-Z ]+" name="make" required></td>
					</tr>
					
					<tr>
						<td>Model:</td>
						<td><input type="text" placeholder="Model" pattern="[a-zA-Z ]+" name="model" required></td>
					</tr>
					<tr>
						<td>EngineInCc:</td>
						<td><input type="text" placeholder="EngineInCc"  name="engineInCc" required></td>
					</tr>
					
					<tr>
						<td>FuelCapacity:</td>
						<td><input type="text" placeholder="FuelCapacity"  name="fuelCapacity" required></td>
					</tr>
					
					<tr>
						<td>Mileage:</td>
						<td><input type="text" placeholder="Mileage"  name="mileage" required></td>
					</tr>
					
					<tr>
						<td>Ex-Showroom Price:</td>
						<td><input type="text" placeholder="Price"  name="price" required></td>
					</tr>
					
					<tr>
						<td>roadTax:</td>
						<td><input type="text" placeholder="RoadTax"  name="roadTax" required></td>
					</tr>
					
					
					<tr>
						<td>onRoadPrice:</td>
						<td><input type="number" placeholder="onRoadPrice" min="0" max="101000000" name="onRoadPrice" required></td>
					</tr>
					
					<tr>
						<td>Ac:</td>
						<td><select name="ac" id="acDropDown" required >
							<option>True</option>
							<option>False</option>
					</select></td>
					</tr>
					
					<tr>
						<td>Power Steering:</td>
						<td><select name="powerSteering" id="powerSteeringDropDown" required >
							<option>True</option>
							<option>False</option>
					</select></td>
					</tr>
					
					<tr>
						<td>Accessory Kit:</td>
						<td><input type="text" placeholder="AccessoryKit" pattern="[a-zA-Z ]+" name="accessoryKit" required></td>
					</tr>
					
					
					<tr>
						<td colspan="2" id="button"><button>SAVE</button>
						<button onClick="location.href='/CaseStudy5/view/AdminHome.jsp'">BACK</button></td>
					</tr>
				</table>
	</center>
</form>
</body>
</html>