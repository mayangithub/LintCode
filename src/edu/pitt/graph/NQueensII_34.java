/**
 * 
 */
package edu.pitt.graph;

/**
 * N-Queens II #34 --- Accepted
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 * Example
 * For n=4, there are 2 distinct solutions.
 * @author yanma
 * @category Graph and Search
 * @version 2015-07-13
 * @class 7
 */
public class NQueensII_34 {
	
	public int sum = 0;
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
        //write your code here
        if (n == 0) {
            return 0;
        }
        int[] board = new int[n];
        
        putQueen(board, 0);
        return sum;
    }
    
    public void putQueen(int[] board, int row) {
        if (row == board.length) {
            sum++; return;
        }
        for (int c = 0; c < board.length; c++) {
            if (isValid(board, row, c)) {
                board[row] = c;
                putQueen(board, row + 1);
            }
        }
    }
    
    public boolean isValid(int[] board, int row, int col) {
        for (int r = 0; r < row; r++) {
            if (board[r] == col) return false;
            else if (board[r] - r == col - row) return false;
            else if (board[r] + r == col + row) return false;
        }
        
        return true;
    }

}
