package modelHelper;



public class EmployeeDefault {
	
	 private static EmployeeDefault Instance = new EmployeeDefault();
	 
	 private EmployeeDefault() {
		 
	
		EmployeeCache.add(EmployeeHelper.createEmployee( 1,"Richa", 21,
				"10/10/2015", "richa@gmail.com"));
		
		EmployeeCache.add(EmployeeHelper.createEmployee(2,"Nidhi", 21,
				"14/10/2015", "nidhi@gmail.com"));
		
		EmployeeCache.add(EmployeeHelper.createEmployee(3,"Suman", 22,
				"10/9/2015", "suman@gmail.com"));
	
		EmployeeCache.add(EmployeeHelper.createEmployee(4,"Neha", 29,
				"13/10/2015", "neha@gmail.com"));
	
		EmployeeCache.add(EmployeeHelper.createEmployee(5,"Chetna", 19,
				"10/11/2015", "chetna@gmail.com"));

	}
	
	 public static EmployeeDefault getInstance( ) {
	      return Instance;
	   }
}
