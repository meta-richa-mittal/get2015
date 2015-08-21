import java.util.Scanner;




public class Main {
	static Scanner sc=new Scanner(System.in);
	static int valid=0;
	public static void main(String args[])
	{
			System.out.print("WELCOME...\n");
			ConsoleMenuItem cm=new ConsoleMenuItem();
			cm.setMenu();
			Menu m=new Menu();
			m.displayMenu();
	}
	
	
	/*public static int iterate()
	{
		System.out.print("Press 1 to continue and 0 to exit..");
		int valid=sc.nextInt();
		return valid;
		
	}*/

}