package assignment4;

import java.util.Scanner;

/**
 * Author: Richa Mittal
 * Description: This program contains a single class with three functions.
 * 		Function 1: To find solution for N Queens problem
 * 		Function 2: To find whether column is valid or not
 * 		Function 3: Main Function
 * 
 * Input: No. of Queens( eg. 4)
 * 	
 * Output: 
 * 		Function 1: is N queens problem is solvable
 * 		Function 2: is column is valid to place a queen
 * 		
 */
public class NQueensProb {
 /**
  * 
  * @param row: row of board to place next queen
  * @param board: N*N board for positioning of queens
  * @param N: no. of queens
  * @return true/false whether solution is possible or not
  */
 boolean nQueen(int row, int[][] board, int N)
 {
   if(row>=N)
   {
   		return true;
   }
   
   for(int position = 0; position < N; position++) 
   {
   	
	     if(isValid(board, row, position, N))
	     {
		       board[row][position] = 1;
		       
		       if(!nQueen(row+1, board, N))       //Recursive call to nQueen 
		       {
		           board[row][position] = 0;
		       } 
		       else
		       {
		            return true;
		       }
	     }
   }
   return false;
 }

 /**
  * 
  * @param board: N*N board for positioning of queens
  * @param x: row to be checked
  * @param y: position of column in row x
  * @param N: no. of queens
  * @return true/false whether position y is valid to lace queen in row x
  */
 boolean isValid(int[][] board, int x, int y, int N)  /*Function to check column is valid or not in NQueen Problem*/ 
 {
   int i, j;						// Loop parameters
   for(i = 0; i < x; i++)
   {
	   	if(board[i][y]==1)
	   	{
	   		return false;
	   	}
   }
     
   i = x - 1;
   j = y - 1;
   while((i>=0)&&(j>=0))
   {
   	
	   	if(board[i--][j--]==1)
	   	{
	   		return false;
	   	}
   }
     
   i = x - 1;
   j = y + 1;
   while((i>=0)&&(j<N))
   {
	   	if(board[i--][j++]==1)
	   	{
	   		return false;
	   	}
   }
     
   return true;
 }
 
 /**
  * This is the Main Function
  */
 public static void main(String args[]) 
 {
	   Scanner sc = new Scanner(System.in);
	   boolean b;
	   System.out.print("Enter the number of queens:");
	   int N=sc.nextInt();								// holds no. of queens
	   if(N<=0)											// checks if N is valid or not
	   {
		   System.out.println("Enter a valid no.");
		   sc.close();
		   return;
	   }
	   
	   int[][] board = new int[N][N];					// N*N board to place N queens
	   
	   NQueensProb ob = new NQueensProb();				// object of our class
	   b=ob.nQueen(0, board, N);
	   if(b)
	   {
		   for(int i = 0; i < N; i++)
		   {
			     for(int j = 0; j < N; j++)
			     {
				       if(board[i][j]==1)
			    	   {
			    	   		System.out.print("Q\t");
			    	   }
				       else 
			    	   {
			    	   		System.out.print("*\t");
			    	   }
			     }
			     System.out.println();
		   }
	   }
	   else
	   {
		   System.out.println("Solution not possible.");
	   }
	   sc.close();
	 }

}
