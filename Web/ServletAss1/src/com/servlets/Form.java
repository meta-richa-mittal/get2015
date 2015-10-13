package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Form extends HttpServlet {
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		PrintWriter pw = res.getWriter();
		boolean flag=true;
		res.setContentType("text/html");
		pw.println("*****This is servlet page*****<br><br>");
		
		if(req.getParameter("firstName") == "" || req.getParameter("firstName") == null)
		{
			flag=false;
			pw.println("*First Name is not entered<br><br>");
			
		} 
		
		if(req.getParameter("lastName")== "" || req.getParameter("lastName") == null) 
		{
			pw.println("*Last Name is not entered<br><br>");
		    flag=false;
		}
		
		if(req.getParameter("password").length() < 8 )
		{
			pw.println("*Password Length should be greater than 8 <br><br>");
		     flag=false;
		}
		else if(!req.getParameter("password").equalsIgnoreCase(req.getParameter("confirmPassword"))) 
		{  
			pw.println("*Passwords don't match<br><br>");
			flag=false;
		}
		
		if( req.getParameter("age") == "" || req.getParameter("age") == null)
		{
		   pw.println("*Age is not entered<br><br>");
		   flag=false;	
		}
		else if(Integer.parseInt(req.getParameter("age")) < 15) {
			pw.println("*Age is less than 15<br><br>");
			   flag=false;	
		}
		else if(Integer.parseInt(req.getParameter("age")) > 75) {
			pw.println("*Age is greater than 75<br><br>");
			   flag=false;	
		}
		
		if(req.getParameter("states").equals("Select State"))
		{ 
			pw.println("*State is not entered<br><br>");
			flag=false;
		}
		if(req.getParameter("cities").equals("Select City")) 
		{ 
			
			pw.println("*City is not entered<br><br>");
			flag=false;
		}
		
	   
		
		if(flag==true){
			pw.println("*Form is successfully validated at server side<br><br>");
		}
		
	}
	

}
