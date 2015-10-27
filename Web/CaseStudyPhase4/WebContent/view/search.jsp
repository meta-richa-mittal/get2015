<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

		<title>User</title>
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
			
			span {
				padding-left: 10px;
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
			
			#message {
			 text-align: center;
			 color: red;
			}
		</style>
		
		<script>
			function enableDropDown() {
			var budget = document.getElementById("budget");
			var brand = document.getElementById("brand");
			
			var budgetDropDown = document.getElementById("budgetDropDown");
			var brandDropDown = document.getElementById("brandDropDown");
			
			var button =document.getElementById("searchButton");
			
			if(budget.checked == true) {
				budgetDropDown.disabled= false;
				button.disabled= false;
			}
			else {
				budgetDropDown.disabled= true;
			}
			if(brand.checked == true) {
				brandDropDown.disabled= false;
				button.disabled= false;
			}
			else {
				brandDropDown.disabled= true;
			}
			
			}
		</script>
</head>
	<body>
	<div id="message">
			<% 
				String message = (String)request.getAttribute("message"); 
				if(message != null) {
					out.println(message);
				}
			%>
		</div>
	<header>
		<p>Search <a id="close" href="/CaseStudyPhase4/RedirectController">X</a></p>
		
	</header>
	
	<section>
	<form action="/CaseStudyPhase4/Search" method="post">
		<table>
			<tr>
				<td><input type="radio" id="budget" name="search" value="By Budget" onchange="enableDropDown()">By Budget
				<span><select name="budgetValue" id="budgetDropDown" disabled>
							<option selected disabled>--Select--</option>
							<option>below 5 lac</option>
							<option>above 5 lac</option>
					</select></span></td>
			</tr>
			
			<tr>
				<td><input type="radio" id="brand" name="search" value="By Brand" onchange="enableDropDown()">By Model
				<span><select name="brandValue" id="brandDropDown" disabled>
							<option selected disabled>--Select--</option>
							<option>Honda</option>
							<option>Hyundai</option>
							<option>Maruti</option>
					</select></span></td>
			</tr>
			<tr>
				<td><button id="searchButton" disabled>Search</button><br><br></td>
			</tr>
		</table>
		</form>
	</section>
	
		
	</body>
</html>