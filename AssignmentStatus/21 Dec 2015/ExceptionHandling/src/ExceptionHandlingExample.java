public class ExceptionHandlingExample {

	public static void divide() throws ArithmeticException {
		System.out.println("Inside function");
		throw new ArithmeticException("Divide by Zero");
	}

	public static void main(String args[]) {
		try {
			divide();
		} catch (ArithmeticException ae) {
			System.out.println("caught\t" + ae);
		}
	}
}
