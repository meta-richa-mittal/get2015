

package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
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
		String msg="";
		res.setContentType("text/html");
		//pw.println("*****This is JSP page*****<br><br>");
		
		Connection con = null;							// opening connection
		PreparedStatement stmt = null;
		
		ConnectionUtil conUtil = new ConnectionUtil();	
		con = conUtil.getConnection();	
		ResultSet rs=null;
		
		String email= req.getParameter("emailId");
		String password= req.getParameter("password");
		//pw.println(email);
		//pw.println(password);
			
		
		if(email == "" || email == null) 
		{
			pw.println("<h3>*User Id is not entered</h3><br><br>");
		    flag=false;
		}
		
		if(password == "" || password == null )
		{
			pw.println("<h3>*Password is not entered</h3><br><br>");
		     flag=false;
		}
		
	   
		
		if(flag==true){
			try {
				String query="SELECT password FROM registrationData WHERE emailId = ?;";
				stmt=con.prepareStatement(query);
				stmt.setString(1, email);
				rs=stmt.executeQuery();
				if(!rs.next()) {
					pw.println("<h3>*User Id does not exist</h3><br><br>");
					
				}
				else {
					if(password.equals(rs.getString("password"))) {
						pw.println("<h3>*Login successful</h3><br><br>");
					}
					else {
						msg="Incorrect Password";
						req.setAttribute("msg", msg);
						RequestDispatcher rd = req.getRequestDispatcher("LoginForm.jsp");
						rd.forward(req, res);
					}
				}
			}
			catch(SQLException se) {
				
				pw.println("<h3>*Error in Login</h3><br><br>");
				se.printStackTrace();
			}
			
		}
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}
	
	
	

}

