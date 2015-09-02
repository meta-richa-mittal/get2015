package employee;


/**
 * 
 * @author Richa Mittal
 * Description: This class defines function to check entries of duplicate employees
 *
 */
public class AvoidDuplicates {
	
	/**
	 * function to check whether emp already exists in the collection or not
	 */
	static public boolean checkDuplicates(Employee emp) {
		if((Employee.empIdList.contains(emp.getEmpId()))) {
			return true;
		}
		else {
			return false;
		}
	}

}
