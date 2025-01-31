import java.util.ArrayList;
import java.util.List;

//Appracoh is to use neighbour array [0,1,-1 ] and add each value of neighbour element in column index and then row index .
//check rules
//Time Complexity: O(M*N), M=rows and N column

//Space Complexity: O(1) updating input array. 

//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this:no
public class gameOfLifeGame {
	
	public static void gameOfLife(int[][] board) {

	       // Neighbors array to find 8 neighboring cells for a given cell
	       int[] neighbors = {0, 1, -1};

	       int rows = board.length;
	       int cols = board[0].length;

	       // Create a copy of the original board
	       int[][] copyBoard = new int[rows][cols];

	       // Create a copy of the original board
	       for (int row = 0; row < rows; row++) {
	           for (int col = 0; col < cols; col++) {
	               copyBoard[row][col] = board[row][col];
	           }
	       }

	       // Iterate through board cell by cell.
	       for (int row = 0; row < rows; row++) {
	           for (int col = 0; col < cols; col++) {

	               // For each cell count the number of live neighbors.
	               int liveNeighbors = 0;

	               for (int i = 0; i < 3; i++) {
	                   for (int j = 0; j < 3; j++) {

	                       if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
	                           int r = (row + neighbors[i]);
	                           int c = (col + neighbors[j]);

	                           // Check the validity of the neighboring cell.
	                           // and whether it was originally a live cell.
	                           // The evaluation is done against the copy, since that is never updated.
	                           if ((r < rows && r >= 0) && (c < cols && c >= 0) && (copyBoard[r][c] == 1)) {
	                               liveNeighbors += 1;
	                           }
	                       }
	                   }
	               }

	               // Rule 1 or Rule 3
	               if ((copyBoard[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
	                   board[row][col] = 0;
	                  
	               }
	               // Rule 4
	               if (copyBoard[row][col] == 0 && liveNeighbors == 3) {
	                   board[row][col] = 1;
	                   
	               }
	           }
	       }
	   }
	
	public static void main(String[] args) {
		int board[][]={{0,1,0},{0,0,1},{1,1,1},{0,0,0}}; 
		
		gameOfLife(board);
		for (int row = 0; row < board.length; row++) {
	           for (int col = 0; col < board[0].length; col++) {
		System.out.println(board[row][col]);
	           }
		}
		
	}
}


