


/**
 * 
 * @author Richa Mittal
 * Description: This class contains function to be performed on each menu item
 *
 */
public class Action {
	
	/**
	 * This function calls the appropriate action to be performed when some menu item is selected
	 * @param choice: chosen menu item
	 */
	int perform(int choice)
	{
		int i;
		switch(choice)
		{
			case 1:
				i=TrainReservation.display("P");
				break;
			
			case 2:
				i=TrainReservation.display("G");
				break;
				
			case 3:
				TrainReservation.display("P");
				i=TrainReservation.filteredTrain("P");
				if(i==0)
				{
					return i;
				}
				else
				{
					TrainReservation.seatReserve("P");
				}
				break;
				
			case 4:
				TrainReservation.display("G");
				i=TrainReservation.filteredTrain("G");
				if(i==0)
				{
					return i;
				}
				else
				{
					TrainReservation.seatReserve("G");
				}
				break;
				
			case 5:
				return 0;
				
			default:
				return 0;
		
		}
		return i;
	}

}
