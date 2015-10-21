package Assignment3;

/**
 * 
 * @author Richa Mittal
 * Description: contains functions that implements "CanRun" annotation
 *
 */
public class AnnotationRunner {
	
	@CanRun
	public void method1() {
		System.out.println("Executing Method-1");
	}
	
	public void method2() {
		System.out.println("Executing Method-2");
	}
	
	@CanRun
	public void method3() {
		System.out.println("Executing Method-3");
	}
	
	public void method4() {
		System.out.println("Executing Method-4");
	}
	
	@CanRun
	public void method5() {
		System.out.println("Executing Method-5");
	}

}
