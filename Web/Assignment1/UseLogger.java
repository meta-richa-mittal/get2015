package Assignment1;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * 
 * @author Richa Mittal
 * Description: contains function to add messages to log file
 * 				and contains main function
 *
 */
public class UseLogger {
  private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
  

  /**
   * function will generate exceptions and write them to a file
   */
  public void doSomeThingAndLog() {
    // set the LogLevel to Severe, only severe Messages will be written
	  try {
			int result=5/0;
			System.out.println(result);
			
		}
		catch(ArithmeticException e) {
			LOGGER.setLevel(Level.SEVERE);
			LOGGER.severe(e.getMessage());
		    LOGGER.warning(e.getMessage());
		    LOGGER.info(e.getMessage());
		    LOGGER.finest("Really not important");
			System.out.println(e.getMessage());
		}
	  
	  
		try {

			Class.forName("com.Driver");
		}
		catch(ClassNotFoundException e) {
			LOGGER.setLevel(Level.SEVERE);
			LOGGER.severe(e.getMessage());
		    LOGGER.warning(e.getMessage());
		    LOGGER.info(e.getMessage());
		    LOGGER.finest("Really not important");
			System.out.println(e.getMessage());
		}
    
  }

  
  /**
   * main function
   * @param args
   */
  public static void main(String[] args) {
	    UseLogger tester = new UseLogger();
	    MyLogger.getInstance();
	    tester.doSomeThingAndLog();
  }
}
 