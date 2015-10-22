package Assignment3;


/**
 * 
 * @author Richa Mittal
 * Description: defines different abstract methods to play cricket and a template
 * 				method to execute them
 *
 */
public abstract class Cricket {
	
	abstract void init();
	
	abstract void startPlay();
	
	abstract void endPlay();
	
	abstract void teaBreak();
	
	
	/**
	 * template method
	 */
	public final void play() {
		
		init();
		
		startPlay();
		
		teaBreak();
		
		endPlay();
	}

}
