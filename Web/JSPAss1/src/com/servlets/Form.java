

package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.ConnectionUtil;

public class Form extends HttpServlet {
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		PrintWriter pw = res.getWriter();
		boolean flag=true;
		res.setContentType("text/html");
		//pw.println("*****This is servlet page*****<br><br>");
		
		Connection con = null;							// opening connection
		PreparedStatement stmt = null;
		
		ConnectionUtil conUtil = new ConnectionUtil();	
		con = conUtil.getConnection();	
		
		String name= req.getParameter("name");
		name=name.trim();
		//pw.print(name.length());
		String email= req.getParameter("emailId");
		String password= req.getParameter("password");
		String confirmPassword= req.getParameter("confirmPassword");
			
		
		if(name == "" || name == null || name.length()==0)
		{
			flag=false;
			pw.println("*Name is not entered<br><br>");
			
		} 
		
		if(email == "" || email == null) 
		{
			pw.println("*Email Id is not entered<br><br>");
		    flag=false;
		}
		
		if(password.length() < 8 )
		{
			pw.println("*Password Length should be greater than 8 <br><br>");
		     flag=false;
		}
		else if(!password.equalsIgnoreCase(confirmPassword)) 
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
			try {
				String query="INSERT INTO registrationData"
						+ "(userName, emailId, password) VALUES"
						+ "(?,?,?);";
				stmt=con.prepareStatement(query);
				stmt.setString(1, name);
				stmt.setString(2, email);
				stmt.setString(3, password);
				stmt.executeUpdate();
				pw.println("<h3>*User has been successfully registered</h3><br><br>");
			}
			catch(SQLException se) {
				pw.println("<h3>*Error registering User</h3>");
			}
			
		}
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}
	
	

}

