package survey;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author Richa Mittal
 * Description: Contains 4 Functions
 */
public class Answers {
	public static int number;
	public static String answer1;
	public static String answer2="";
	public static String answer3="";
	public static HashMap<Integer,String> input=new HashMap<Integer,String>();
	public static int index=0;
	public static String token[]=new String[5];
	public static String result="";

	/**
	 * function for storing answer for every question.
	 * @param number: participant no
	 * @param answer1: ans for question 1
	 * @param answer2: ans for question 2
	 * @param answer3: ans for question 3
	 * @param input: record of previous  participants  
	 * @return new participants records
	 */
	//
	public HashMap<Integer,String> storeAnswer(int number,String answer1,String answer2,String answer3,HashMap<Integer, String> input)
		{
			input.put(number+1, answer1);
			input.put(number+2, answer2);
			input.put(number+3, answer3);
			return input;
		}

	/**
	 * display final output for every participant
	 * @param input:  record of participants
	 * @param question: list of questions
	 * @param numOfParticipants: total no of participants
	 */
	public void display(HashMap<Integer, String> input,List<String> question,int numOfParticipants)
		{
			Iterator<Integer> keySetValue=input.keySet().iterator();
			Integer key=1;
			for(index=0;index<numOfParticipants;index++)
				{
					System.out.println("Participant "+(index+1)+" : ");
					System.out.println("Ques "+question.get(0)+"\n"+input.get(key));
					System.out.println("Ques "+question.get(1)+"\n"+input.get(key+1));
					System.out.println("Ques "+question.get(2)+"\n"+input.get(key+2));
					key+=3;
				}
			if(keySetValue.hasNext()==false)
				{
					System.out.println("Do serve first");
				}
		}

	/**
	 * calculate /total percentage distribution of answes of single select type questions
	 * @param output: record of participants
	 * @param numOfParticipants: total no of participants
	 * @param count: count of no of participants corresponding to one option
	 */
	public void totalPercentage(HashMap<Integer, String> output,int numOfParticipants,int count)
		{
			int[] total=new int[5];
			Iterator<Integer> keySetValue=output.keySet().iterator();
			Integer key=1;
			if(numOfParticipants==0)
				{
					System.out.println("Do serve first");
				}
			else
				{
					//Calculating total number of selection for an answer
					while(keySetValue.hasNext() && key<=count)
						{
							if(Integer.parseInt(output.get(key))==1)
								{
									total[0]++;
								}
							if(Integer.parseInt(output.get(key))==2)
								{
									total[1]++;
								}
							if(Integer.parseInt(output.get(key))==3)
								{
									total[2]++;
								}
							if(Integer.parseInt(output.get(key))==4)
								{
									total[3]++;
								}
							if(Integer.parseInt(output.get(key))==5)
								{
									total[4]++;
								}
							key+=3;
						}
							// Calculating total percentage for an answer
							for (index = 0; index < total.length; index++) 
							{
							total[index] = (total[index] * 100) / numOfParticipants;
							System.out.println((index + 1) + " := " + total[index] + "%");
							}	
				}
  		}
	
/**
 * checks whether entered value is corret or not
 * @param value: entered value
 * @param question: corresponding questions
 * @return value 
 */
	public String checkOption(String value,String question)
		{
			if(question.equals("1 Overall Rating (1/2/3/4/5)")==true) //if question is equal to 1st question
				{
					token=value.split(" ");
					if(token.length>1) //Condition to check the number of values entered by the user
						{
							System.out.println("Select only one option from available options");
							return result;
						}
					if(Integer.parseInt(token[0])==1 || Integer.parseInt(token[0])==2 || Integer.parseInt(token[0])==3 || Integer.parseInt(token[0])==4 || Integer.parseInt(token[0])==5)
						{
							return token[0];
						}
					else
						{
							//Condition to iterate again to enter the answer by the user if input is wrong
							System.out.println("Enter a vaid option");
							return result;
						}
				}
			else if(question.equals("2 Area of improvement (Service Quality/ Communication/ Delivery Process)")==true)
				{
					token=value.split("/");
					//Condition to check the number of values entered by the user
					if(token.length>3)
						{
							System.out.println("Enter values available from options only");
							return result;
						}
					//Condition to check the value entered by the user
					for(index=0;index<token.length;index++)
						{
							if(token[index].equalsIgnoreCase("Communication") || token[index].equalsIgnoreCase("Service Quality") || token[index].equalsIgnoreCase("Delivery Process"))
								{
									result=result.concat(token[index]);
								}
							else
								{
									//Condition to iterate again to enter the answer by the user if input is wrong
									System.out.println("Enter valid options");
									return result;
								}
						}
				}

			return value;
		}

}
