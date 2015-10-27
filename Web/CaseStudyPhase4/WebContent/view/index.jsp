<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Online Cars</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" type="text/css">
		<style type="text/css">
		
		body {
			background-image: url('/CaseStudyPhase4/images/car2.jpg');
		}
		</style>
</head>
<body>
	
	<div id="user">
		<table border="1">
			<tr>
			<td><button onClick="location.href='/CaseStudyPhase4/view/search.jsp'">USER</button></td>
			<td><button onClick="location.href='/CaseStudyPhase4/view/admin.jsp'">ADMIN</button></td>
			</tr>
		</table>
		</div>
		<div id="header"><p><font>CAR</font>&nbsp;&nbsp;Dealers</p></div>
		<div id="menuBar">
			<nav>
			<ul>
				<li><a href="/CaseStudyPhase4/view/index.jsp">Home</a></li>
				<li><a href="/CaseStudyPhase4/view/index.jsp">About Us</a></li>
				<li><a href="/CaseStudyPhase4/view/index.jsp">Contact Us</a></li>
			</ul>
			</nav>
		</div>
	</body>
</html>