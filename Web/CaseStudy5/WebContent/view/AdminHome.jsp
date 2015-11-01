
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Admin Home</title>
	<style>
		body {
				background-color: Gray;
				
		}
		
		#head {
			background-color: gray;
			text-align: center;
			height: 100px;
			width: 100%;
			margin: auto;
			margin-top:2%;
			border-radius: 0px;
		}
		
		#button1 {
			margin: auto;
			margin-top: 2%;
			float: left;
			margin-left: 20px;
		}
		
		#button2 {
			margin: auto;
			margin-top: 2%;
			float: right;
			margin-right: 20px;
		}
		
		div {
			background-color: white;
			text-align: center;
			height: 300px;
			width: 300px;
			margin: auto;
			margin-top:5%;
			border-radius: 50%;
			float: left;
			margin-left: 18%;
		}
		
		
		img {
			padding-top:50px;
			height: 200px;
			width: 200px;
		}
		
		button {
			color: white;
			background-color: maroon;
			font-weight: bold;
			width:100px;
			height:40px;
		}
		
		
	</style>
</head>
<body>
<div id="head"><button id="button1" onClick="location.href='/CaseStudy5/view/AdminHome.jsp'">HOME</button>
		&nbsp;&nbsp;<button id="button2" onClick="location.href='/CaseStudy5/LogoutController'">LOGOUT</button></div>
	
		<div><a href="/CaseStudy5/Search"><img src="/CaseStudy5/images/search2.gif"></a>
		<br><br><button onClick="location.href='/CaseStudy5/Search'">SEARCH</button></div>
		
		<div><a href="/CaseStudy5/CreateCar"><img src="/CaseStudy5/images/addNew1.gif"></a>
		<br><br><button onClick="location.href='/CaseStudy5/CreateCar'">ADD NEW</button></div>
</body>
</html>