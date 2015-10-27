package com.car.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.car.exception.CarSystemException;
import com.car.authentication.AuthenticationFilter;
import com.car.db.helper.CarDbHelper;
import com.car.model.Car;
import com.car.model.Vehicle;

/**
 * Servlet implementation class search
 */
//@WebServlet("/Search")
public class Search extends HttpServlet {
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AuthenticationFilter af= new AuthenticationFilter();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/search.jsp");
		dispatcher.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardUrl = "/view/searchResult.jsp";
		String searchBy = searchCar(request);
		request.setAttribute("searchBy", searchBy);
		CarDbHelper carDbHelper = new CarDbHelper();
		String filterValue="";
		try {
			if(searchBy.equals("By Brand")) {
				
				filterValue = request.getParameter("brandValue");
				if(filterValue != null) {
					 List<Vehicle> listOfVehicles = carDbHelper.getCarByBrand(filterValue);
					 request.setAttribute("list", listOfVehicles);
				}
				else {
					 request.setAttribute("message", "No Brand Name Selected !!");
					forwardUrl = "/view/search.jsp";
				}
				 
			}
			else if(searchBy.equals("By Budget")) {
				filterValue = request.getParameter("budgetValue");
				
				if(filterValue != null) {
					 List<Vehicle> listOfVehicles = carDbHelper.getCarByBudget(filterValue);
					 request.setAttribute("list", listOfVehicles);
				}
				else {
					request.setAttribute("message", "No Budget Value Selected !!");
					forwardUrl = "/view/search.jsp";
				}
			}
		}
		catch (CarSystemException e) {
			System.out.println("Exception while searching car " + e.getMessage());
			forwardUrl = "/view/search.jsp";
			request.setAttribute("message", e.getMessage());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
		dispatcher.forward(request, response);
	}
	
	
	private String searchCar(HttpServletRequest request) {
		
		CarDbHelper carDbHelper = new CarDbHelper();
		String searchBy = request.getParameter("search");
		
			
		return searchBy;
	}


}
