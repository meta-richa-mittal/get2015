package employee;

import java.util.Comparator;


/**
 * 
 * @author Richa Mittal
 * Description: This class implements the Comparator interface and override the compare method
 *
 */
public class SortAccToName implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		Employee e1=(Employee) o1;
		Employee e2=(Employee) o2;
		return (int)(e1.getName().compareToIgnoreCase(e2.getName()));
	}
	

}
