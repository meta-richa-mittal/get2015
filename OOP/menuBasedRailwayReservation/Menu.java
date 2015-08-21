import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Menu {
	
	static ArrayList<PassengerTrain> pt=new ArrayList<PassengerTrain>();
	static ArrayList<GoodsTrain> gt=new ArrayList<GoodsTrain>();
	static List<String> items = new ArrayList<>();

	static private Scanner scan  = new Scanner(System.in);
	
	
	public void addMenuItem(String item)
	{

		items.add(item);

	}

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
