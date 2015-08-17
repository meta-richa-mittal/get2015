import java.util.Scanner;


/**
 * 
 * @author Richa Mittal
 * Description: This program contains a single class with 
 * 				three instance variables and four functions.
 * 		Instance Variable 1: Used in Function 3
 * 		Function 1: Adds element in the matrix at the specified position
 * 		Function 2: calculating transpose of given matrix
 * 		Function 3: display matrix
 * 		Function 4: Main Function
 * Input: Three numbers row,col,value ( eg. 3,3,5)
 * 		Function 1: row,col,value
 * Output:
 * 		Function 2: object of class having transpose matrix
 *
 */
public class MatrixClass {
	/**
	 * 2D matrix
	 */
	int data[][];
	
	/**
	 * no. of rows in matrix
	 */
	int noRows;
	
	/**
	 * no. of cols in matrix
	 */
	int noCols;
	
	/**
	 * constructor
	 * @param row: no. of rows
	 * @param col: no. of cols
	 */
	public MatrixClass(int row,int col)
	{
		this.noRows=row;
		this.noCols=col;
		data=new int[row][col];
	}
	
	/**
	 * This functions adds the value to the matrix at (row,col) position
	 * @param row: position of row
	 * @param col: position of col
	 * @param value: value for matrix
	 */
	public void addElements(int row,int col,int value)
	{
		this.data[row][col]=value;
	}
	
	/**
	 * This function calculates transpose of given matrix
	 * @return object of class with transpose matrix
	 */
	public MatrixClass transpose()
	{
		MatrixClass trans=new MatrixClass(this.noCols,this.noRows);
		for(int i=0;i<trans.noRows;i++)
		{
			for(int j=0;j<trans.noCols;j++)
			{
				trans.data[i][j]=this.data[j][i];
			}
		}
		return trans;
	}
	
	/**
	 * This function prints the matrix
	 */
	public void show()
	{
		for(int i=0;i<this.noRows;i++)
		{
			for(int j=0;j<this.noCols;j++)
			{
				System.out.print(this.data[i][j]);
				System.out.print("\t");
			}
			System.out.print("\n");
		}
	}
	
	/**
	 * This is the main function
	 */
	public static void main(String args[])
	{
		int row,col;										// stores no of rows And cols
		int value;											// value to be entered in matrix
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter no. of rows and cols:");
		row=sc.nextInt();
		col=sc.nextInt();
		MatrixClass matrix=new MatrixClass(row,col);		// initializing object
		System.out.print("Enter no.'s of matrix:");
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				value=sc.nextInt();
				matrix.addElements(i, j, value);			// calling function to add element
			}
		}
		System.out.println("Given Matrix is:");
		matrix.show();
		MatrixClass trans=matrix.transpose();				// calling function to calculate transpose
		System.out.println("Matrix after transpose is:");
		trans.show();										// calling function to print matrix
		
		sc.close();
	}
}