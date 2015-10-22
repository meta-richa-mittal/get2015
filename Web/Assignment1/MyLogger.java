package Assignment1;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger {
	  static private FileHandler fileTxt;
	  static private SimpleFormatter formatterTxt;
	  private static MyLogger myLogger= new MyLogger();
	
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
	  
	  public static MyLogger getInstance() {
			return myLogger;
	  }

}
 
