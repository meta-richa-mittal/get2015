package parameterisedConstructor;

public class Main {

	public static void main(String args[]){
		String email = "nidhi.sharma@metacube.com";
		Employee emp = new Employee(email);
		System.out.println("Employee : " + emp);
	}
}
