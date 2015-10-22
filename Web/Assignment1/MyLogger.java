package Assignment1;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


/**
 * 
 * @author Richa Mittal
 * Description: This is a singleton class contains private constructor
 * 				to initialize object of Logger Class and to create a file
 *
 */
public class MyLogger {
	  static private FileHandler fileTxt;
	  static private SimpleFormatter formatterTxt;
	  
	  // single private instance of this class
	  private static MyLogger myLogger= new MyLogger();
	
	  
	  /**
	   * Private Constructor
	   */
	  private MyLogger() {
		  Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		  logger.setLevel(Level.ALL);
		   try {
			fileTxt = new FileHandler("Logging.txt");
		   } 
		   catch (SecurityException e) {
			e.printStackTrace();
		   } 
		   catch (IOException e) {
				e.printStackTrace();
		   }
		   formatterTxt = new SimpleFormatter();
		   fileTxt.setFormatter(formatterTxt);
		   logger.addHandler(fileTxt);
		  
	  }
	  
	  
	  /**
	   * method to return the single private object of this class
	   * @return object of this class
	   */
	  public static MyLogger getInstance() {
			return myLogger;
	  }

}
 
