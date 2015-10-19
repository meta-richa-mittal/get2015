

package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Form extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DB_URL = "jdbc:mysql://localhost:3306/registration";
	private static final String USER = "root";
	private static final String PASSWORD = "mysql";
	String errorMsg="";
	Object errorInfo=null;
			
	private Connection con = null;
	
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		

		/* register driver */
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) {
			
			errorMsg="Error In Login";
			errorInfo=e;
			req.setAttribute("errorInfo", errorInfo);
			req.setAttribute("errorMsg", errorMsg);
			RequestDispatcher rd = req.getRequestDispatcher("Error.jsp");
			rd.forward(req, res);
		}
		
		/* open connection */
		try {
			con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		} 
		catch (SQLException se) {
			errorMsg="Error In Login";
			errorInfo=se;
			req.setAttribute("errorInfo", errorInfo);
			req.setAttribute("errorMsg", errorMsg);
			RequestDispatcher rd = req.getRequestDispatcher("Error.jsp");
			rd.forward(req, res);
		}
		
		
		
		try {
		PrintWriter pw = res.getWriter();
		boolean flag=true;
		String msg="";
		res.setContentType("text/html");
		PreparedStatement stmt = null;	

		ResultSet rs=null;
		
		String email= req.getParameter("emailId");
		String password= req.getParameter("password");
			
		
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
		
				String query="SELECT * FROM registrationData WHERE emailId = ?;";
				stmt=con.prepareStatement(query);
				stmt.setString(1, email);
				rs=stmt.executeQuery();
				if(!rs.next()) {
					pw.println("<h3>*User Id does not exist</h3><br><br>");
					
				}
				else {
					if(password.equals(rs.getString("password"))) {
						req.setAttribute("name", rs.getString("userName"));
						RequestDispatcher rd = req.getRequestDispatcher("LoginSuccess.jsp");
						rd.forward(req, res);
					}
					else {
						msg="Incorrect Password";
						req.setAttribute("msg", msg);
						RequestDispatcher rd = req.getRequestDispatcher("LoginForm.jsp");
						rd.forward(req, res);
					}
				}
			}
		}
		catch(SQLException se) {
			
			errorMsg="Error In Login";
			errorInfo=se;
			req.setAttribute("errorInfo", errorInfo);
			req.setAttribute("errorMsg", errorMsg);
			RequestDispatcher rd = req.getRequestDispatcher("Error.jsp");
			rd.forward(req, res);
		}	
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}
	
	
	

}

