package Assignment3;


/**
 * 
 * @author Richa Mittal
 * Description: extends Cricket class and defines functions according
 * 				to Test Cricket
 *
 */
public class TestCricket extends Cricket {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("Test Cricket Initialized! Start Playing..");
		
	}

	@Override
	public void startPlay() {
		// TODO Auto-generated method stub
		System.out.println("Test Cricket Started! Enjoy Playing..");
		
	}

	@Override
	public void endPlay() {
		// TODO Auto-generated method stub
		System.out.println("Test Cricket Ended! Play Again..");
		
	}

	@Override
	public void teaBreak() {
		// TODO Auto-generated method stub
		System.out.println("Test Cricket Break Time!");
		
	}

}
