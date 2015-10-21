package Assignment1;


/**
 * 
 * @author Richa Mittal
 * Description: Defines an annotation named "RequestForEnhancement"
 *
 */
public @interface RequestForEnhancement {

	int id();
	
	String synopsis();
	
	String engineer() default "[unassigned]";
	
	String date() default "[unknown]";
	
}
