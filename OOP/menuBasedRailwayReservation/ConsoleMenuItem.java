

/**
 * 
 * @author Richa Mittal
 * Descriptiuon: This class contains function to set menu items to menu
 *
 */
public class ConsoleMenuItem {
	
	
	/**
	 * This function sets the menu
	 */
	public void setMenu()
	{
		String menu[]={"1. Passenger Trains Chart","2. Goods Trains Chart","3. Passenger Train Reservation","4. Goods Train Reservation","5. Exit"};
		Menu m=new Menu();
		for (String s : menu)
		{
			m.addMenuItem(s);
		}
		
	}

}
