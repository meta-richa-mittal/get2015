package survey;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Richa Mittal
 * Description: This class contains the function to read questions from the file
 *
 */
public class Questions {
	public static String location="D:/questions.csv";
	public static List<String> question=new ArrayList<String>();
	public static String line="";
	/**
	 * Function to return questions of survey form
	 * @return list containing all the questions
	 */
	public static List<String> readQuestions()
		{
			try
				{
					//Reading the questions stored in the csv file
					BufferedReader br=new BufferedReader(new FileReader(location));
					while((line=br.readLine())!=null)
						{
							String[] token=line.split(",");
							//Questions are added in the list of string type
							question.add(token[0]+" "+token[1]);
						}
					br.close();
				}
			catch(FileNotFoundException e)
				{
					System.out.println(e);

				}
			catch(IOException e)
				{
					System.out.println(e);
				}
			return question;
	
	}                         

}
