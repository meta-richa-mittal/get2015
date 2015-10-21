package Assignment3;
import java.lang.reflect.Method;


/**
 * 
 * @author Richa Mittal
 * Description: Main class to parse methods having annotation
 *
 */
public class AnnotationRunnerParser {
	
	/**
	 * Main function
	 */
	public static void main(String args[]) throws Exception { 
	
		parse(AnnotationRunner.class);
	}
	
	
	/**
	 * function to parse methods of a class to find
	 * which methods have annotations
	 * @throws Exception
	 */
	public static void parse(Class<?> tempClass) throws Exception {
		Method[] methods= tempClass.getMethods();
		System.out.println("Executing Methods having Annotations:");
		for(Method method: methods) {
			if(method.isAnnotationPresent(CanRun.class)) {
				
				method.invoke(AnnotationRunner.class.newInstance());
			}
		}
	}

}
