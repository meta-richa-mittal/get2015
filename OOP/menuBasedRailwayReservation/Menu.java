import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



/**
 * 
 * @author Richa Mittal
 * Description: This class adds menu items to the menu and displays them
 *
 */
public class Menu {
	
	static List<String> items = new ArrayList<>();

	static private Scanner scan  = new Scanner(System.in);
	
	
	/**
	 * This will add the items of menu to the items list
	 * @param item: item of menu
	 */
	public void addMenuItem(String item)
	{

		items.add(item);

	}

	
	
	/**
	 * This will display the menu items to the console
	 */
	public void displayMenu() 
	{
		TrainReservation tr=new TrainReservation();
		tr.readTrains();
		//PassengerTrain pTrain= new PassengerTrain();
		TrainReservation.readPassengerTrains("P");
		//GoodsTrain gTrain= new GoodsTrain();
		TrainReservation.readGoodsTrains("G");

		//while (true)
		//{

			for (String i : items) 
			{

				System.out.println(i);

			}

			int choice = scan.nextInt();
			Action ac=new Action();
			int i=ac.perform(choice);
			if(i==0)
			{
				return;
			}
			TrainReservation.space();

		}

	//}


}
