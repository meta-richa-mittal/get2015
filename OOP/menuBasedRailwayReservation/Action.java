

public class Action {
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
