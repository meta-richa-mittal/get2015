package Shape;

/**
 * 
 * @author Richa Mittal
 * Description: class impelementing interface Shape
 *
 */
public class Square implements Shape {
	
	/**
	 * holds value of side of the square
	 */
	private double side;
	
	/**
	 * constructor for class Square
	 * @param side: takes side of square as parameter
	 */
	public Square(double side)
	{
		this.side=side;
	}
	
	/**
	 * to draw square
	 */
	public void draw()
	{
		System.out.print("Funtion to draw square");
	}
	
	/**
	 * Function to calculate area of square
	 * @return value of area
	 */
	public double getArea()
	{
		double area;
		area=this.side*this.side;
		return area;
	}

}
