package com.car.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.car.exception.CarSystemException;
import com.car.factory.CarSystemFactory;
import com.car.db.helper.CarDbHelper;
import com.car.model.Car;
import com.car.service.CarSystemService;

/**
 * Servlet implementation class CarEditController
 */
@WebServlet("/CarEditController")
public class CarEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CarSystemFactory factory = new CarSystemFactory();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardUrl = "/view/carDetails.jsp";
		PrintWriter pw = response.getWriter();
		//System.out.println("******"+request.getParameter("vid")+"****");
		Car car = editCar(request);
		request.setAttribute("vehicleDetails", car);
		CarSystemService service = new CarSystemService();
		try {
			service.editCar(car);
			request.setAttribute("message", "Updated Successfully");
			pw.println(request.getAttribute("message"));
		} catch (CarSystemException e) {
			System.out.println("Exception while updating car " + e.getMessage());
			forwardUrl = "/view/carDetails.jsp";
			request.setAttribute("message", e.getMessage());
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
	
	private Car editCar(HttpServletRequest request) {
		Car car = new Car();
		car.setId(request.getParameter("id"));
		System.out.println("******"+request.getParameter("make"));
		//System.out.println("****"+request.getParameter("engineInCc").trim());
		car.setEngineInCC(Integer.parseInt(request.getParameter("engineInCc").trim()));
		car.setFuelCapacity(Integer.parseInt(request.getParameter("fuelCapacity").trim()));
		car.setMilage(Integer.parseInt(request.getParameter("mileage").trim()));
		car.setPrice(Integer.parseInt(request.getParameter("price").trim()));
		car.setRoadTax(Integer.parseInt(request.getParameter("roadTax").trim()));
		car.setCreated_by("Admin");
		car.setMake(request.getParameter("make"));
		car.setModel(request.getParameter("model"));
		car.setCreated_time(Calendar.getInstance().getTime().toString());
		return car;
	}

}
