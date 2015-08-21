import java.util.Scanner;


/**
 * 
 * @author Richa Mittal
 * Description: This class contains the main function
 *
 */
public class Main {
	static Scanner sc=new Scanner(System.in);
	static int valid=0;
	
	
	
	/**
	 * This is the main function
	 */
	public static void main(String args[])
	{
		
		TrainReservation tr=new TrainReservation();
		tr.readTrains();
		TrainReservation.readPassengerTrains("P");
		TrainReservation.readGoodsTrains("G");
		ConsoleMenuItem cm=new ConsoleMenuItem();
		cm.setMenu();
		do
		{
			System.out.print("WELCOME...\n");
			Menu m=new Menu();
			m.displayMenu();
			valid=iterate();
		}while(valid==1);
	}
	
	
	
	/**
	 * This function will ask user to continue or exit
	 * @return
	 */
	public static int iterate()
	{
		System.out.print("Press 1 to continue and 0 to exit..");
		int valid=sc.nextInt();
		return valid;
		
	}

}