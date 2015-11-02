package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeDetailController
 */
@WebServlet("/EmployeeDetailController")
public class EmployeeDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDetailController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String selectedValue = request.getParameter("name");
		response.setContentType("text/plain");

		response.setCharacterEncoding("UTF-8");

		switch (selectedValue) {
		case "Richa":
			response.getWriter().write("Name: Richa Mittal<br><br>Email:  richa@gmail.com<br><br>Dob:  17 Sept<br><br>Address : Gopal pura<br><br>");
			break;
		
		case "Nidhi":
			response.getWriter().write("Name: Nidhi Sharma<br><br>Email:  nidhi@gmail.com<br><br>Dob: 23 Nov<br><br>Address : Gandhi Nagar<br><br>");
			break;
		
		case "Suman":
			response.getWriter().write("Name: Suman Sharma<br><br>Email:  suman@gmail.com<br><br>Dob:  22 july<br><br>Address : Gopal pura<br><br>");
			break;
		
		default:
			response.getWriter().write("Please Select a name!!!!!!!!!!!!!");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
