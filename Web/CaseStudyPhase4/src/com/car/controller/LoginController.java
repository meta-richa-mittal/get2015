package com.car.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
//@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static String USER_ID = "admin@gmail.com";
	
	private static String PASSWORD = "admin";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardUrl = "/view/admin.jsp";
		String userId = request.getParameter("userId").trim();
		String pwd = request.getParameter("pwd").trim();
		
		if(userId==null || userId=="") {
			request.setAttribute("message", "Email Id is not entered");
		}
		else if(pwd=="" || pwd==null) {
			request.setAttribute("message", "Password is not entered");
		}
		else {
			if(userId.equals(USER_ID) && pwd.equals(PASSWORD)) {
				HttpSession session = request.getSession();
				session.setAttribute("userId", userId);
				forwardUrl = "/view/AdminHome.jsp";
			}
			else {
				request.setAttribute("message", "Incorrect Email Id or Password");
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
		dispatcher.forward(request, response);
		
	}

}
