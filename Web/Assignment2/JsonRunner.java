package Assignment2;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import Assignment2.model.Employee;


/**
 * 
 * @author Richa Mittal
 * Description: contains main function, function to convert to JSON and from JSON
 *
 */
public class JsonRunner {

	/**
	 * Main function
	 */
	public static void main(String args[]) {
		javaToJson();
		jsonToJava();
		
	}
	
	
	/**
	 * will write object to JSON file
	 */
	private static void javaToJson() {
		
		
		ObjectMapper object=new ObjectMapper();
		File jsonFile= new File("Employee.json");
		Employee emp=new Employee();
		emp.setEmployeeName("Richa");
		emp.setEmployeeId(123);
		emp.setEmailId("richa@gmail.com");
		emp.setDateOfBirth("17/09/1993");
		emp.setDateOfJoining("03/08/2015");
		emp.setCtcPerAnnum(100000);
		
		try {
			
			object.writeValue(jsonFile, emp);
			System.out.println("Converting from JAVA Object to JSON String.....(Writing to JSON File)");
			System.out.println(object.writeValueAsString(emp));
		} 
		catch (JsonGenerationException e) {
			System.out.println("JsonGenerationException:\n"+e);
			//e.printStackTrace();
		} 
		catch (JsonMappingException e) {
			System.out.println("JsonMappingException:\n"+e);
			//e.printStackTrace();
		} 
		catch (IOException e) {
			System.out.println("IOException:\n"+e);
			//e.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * will read from JSON file
	 */
	private static void jsonToJava() {
		
		ObjectMapper object=new ObjectMapper();
		File jsonFile= new File("Employee.json");
		
		try {
			
			Employee emp1=object.readValue(jsonFile, Employee.class);
			System.out.println("\n\nConverting from JSON String to JAVA Object.....(Reading from JSON File)");
			System.out.println(emp1.toString());
		} 
		catch (JsonParseException e) {
			System.out.println("JsonParseException:\n"+e);
			//e.printStackTrace();
		} 
		catch (JsonMappingException e) {
			System.out.println("JsonMappingException:\n"+e);
			//e.printStackTrace();
		} 
		catch (IOException e) {
			System.out.println("IOException:\n"+e);
			//e.printStackTrace();
		}
		
		
	}
}
