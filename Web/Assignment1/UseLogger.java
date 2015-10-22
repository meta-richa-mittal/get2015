package Assignment1;
import java.util.logging.Level;
import java.util.logging.Logger;



public class UseLogger {
  private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
  

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

  public static void main(String[] args) {
	    UseLogger tester = new UseLogger();
	    MyLogger.getInstance();
	    tester.doSomeThingAndLog();
  }
}
 