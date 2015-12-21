package customException;

public class SampleExceptionHandling {

	public static void main(String args[]) {
		SampleExceptionHandling s = new SampleExceptionHandling();
		s.validateAge();
	}

	public void validateAge() {

		int age = 11;
		if (age < 18) {
			try {
				throw new CustomException("Invalid Age: Age should be greater than 18.");
			} catch (CustomException ce) {

				System.out.println(ce);
			}
		}
		else {
			System.out.println("Age is valid.");
		}
	}
}
