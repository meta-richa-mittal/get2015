package Shape;

/**
 * 
 * @author Richa Mittal
 * Description: class impelementing interface Shape
 *
 */
public class Circle implements Shape {
	/**
	 * holds value of radius of the circle
	 */
	private double radius;
	
	/**
	 * constructor for class Circle
	 * @param radius: takes radius of circle as parameter
	 */
	public Circle(double radius)
	{
		this.radius=radius;
	}
	
	/**
	 * to draw circle
	 */
	public void draw()
	{
		System.out.print("Funtion to draw circle");
	}
	
	/**
	 * Function to calculate area of circle
	 * @return value of area
	 */
	public double getArea()
	{
		double area;
		area=3.14*this.radius*this.radius;
		return area;
	}

}
