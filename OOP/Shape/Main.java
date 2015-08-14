package Shape;


import java.util.Scanner;

/**
 * @author Richa Mittal
 * Description: class containing main function and print function
 *
 */
public class Main {
	
	/**
	 * prints the area of the shape
	 * @param shape: object of class Shape
	 */
	public static void printShape(Shape shape)
	{
		System.out.println("Area is:"+shape.getArea());
	}
	
	/**
	 * This is the main Function
	 */
	public static void main(String args[])
	{
		double rad=0,side=0;				// input parameters to find area
		int n;
		Scanner sc=new Scanner(System.in);
		do
		{
			System.out.print("Enter 1 for circle.\nEnter 2 for square.\nEnter 3 to exit.\n");
			n=sc.nextInt();
			switch(n)
			{
				case 1:						// for circle
					System.out.print("Enter radius:");
					rad=sc.nextDouble();
					if(rad<0)
					{
						System.out.print("Enter a valid radius.");
					}
					Shape cir=new Circle(rad);
					printShape(cir);
					break;
				case 2:						// for square
					System.out.print("Enter side:");
					side=sc.nextDouble();
					if(side<0)
					{
						System.out.print("Enter a valid side.");
					}
					Shape sq=new Square(side);
					printShape(sq);
					break;
				case 3:
					sc.close();
					return;
				default:
					break;
			}
		}while(n!=3);
		sc.close();
	}

}
