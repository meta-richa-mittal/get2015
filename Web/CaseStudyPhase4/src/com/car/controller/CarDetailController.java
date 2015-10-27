package com.car.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.car.exception.CarSystemException;
import com.car.db.helper.CarDbHelper;
import com.car.model.Vehicle;

/**
 * Servlet implementation class CarDetailController
 */
//@WebServlet("/CarDetailController")
public class CarDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardUrl = "/view/carDetails.jsp";
		String vehicleId=request.getParameter("id");
		
		CarDbHelper carDbHelper = new CarDbHelper();
		try {
			Vehicle vehicle= carDbHelper.getCarDetails(vehicleId);
			request.setAttribute("vehicleDetails", vehicle);
		} catch (CarSystemException e) {
			System.out.println("Exception while getting car details " + e.getMessage());
			forwardUrl = "/view/searchResult.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
