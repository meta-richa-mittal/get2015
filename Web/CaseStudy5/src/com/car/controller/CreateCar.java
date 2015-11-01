package com.car.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.car.exception.CarAlreadyExistsException;
import com.car.exception.CarSystemException;
import com.car.db.helper.CarDbHelper;
import com.car.model.Car;
import com.car.service.CarSystemService;

/**
 * Servlet implementation class CreateCar
 */
@WebServlet("/CreateCar")
public class CreateCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/create_car.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardUrl = "/view/create_car.jsp";
		Car car = createCar(request);
		request.setAttribute("car", car);
		CarSystemService service = new CarSystemService();
		try {
			Car createCar= service.createCar(car);
			request.setAttribute("message", "Created Successfully");
			request.setAttribute("id", createCar.getId());
		} catch (CarSystemException e) {
			System.out.println("Exception while creating car " + e.getMessage());
			forwardUrl = "/view/create_car.jsp";
			request.setAttribute("message", e.getMessage());
		} catch (CarAlreadyExistsException e) {
			System.out.println("Exception while creating sales person " + e.getMessage());
			forwardUrl = "/view/create_car.jsp";
			request.setAttribute("message", e.getMessage());
			request.setAttribute("car", car);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
		dispatcher.forward(request, response);
	}

	private Car createCar(HttpServletRequest request) {
		Car car = new Car();
		car.setId(request.getParameter("id"));
		car.setMake(request.getParameter("make"));
		car.setModel(request.getParameter("model"));
		car.setEngineInCC(Integer.parseInt(request.getParameter("engineInCc").trim()));
		car.setFuelCapacity(Integer.parseInt(request.getParameter("fuelCapacity").trim()));
		car.setMilage(Integer.parseInt(request.getParameter("mileage").trim()));
		car.setPrice(Integer.parseInt(request.getParameter("price").trim()));
		car.setRoadTax(Integer.parseInt(request.getParameter("roadTax").trim()));
		car.setCreated_by("Admin");
		car.setAC(Boolean.parseBoolean(request.getParameter("ac")));
		car.setPowerSteering(Boolean.parseBoolean(request.getParameter("powerSteering")));
		car.setAccessoryKit(request.getParameter("accessoryKit"));
		car.setCreated_time(Calendar.getInstance().getTime().toString());
		return car;
	}

}
