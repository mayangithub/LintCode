/**
 * 
 */
package edu.pitt.easy;

/**
 * Valid Sudoku #389 --- Accepted
 * Determine whether a Sudoku is valid.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * The following partially filed sudoku is valid.
 * Valid Sudoku
 * Note
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 * @author yanma
 * @version 2015-10-21
 * @category Easy
 * @week 12 1019-1025
 */
public class ValidSudoku_389 {
	/**
     * @param board: the board
       @return: wether the Sudoku is valid
     */
   public boolean isValidSudoku(char[][] board) {
       if (board == null || board.length < 9 || board[0].length < 9) {
           return false;
       }
       for (char i = '1'; i <= '9'; i++) {
           if (!isValidHelper(board, i)) {
               return false;
           }
       }
       return true;
   }
   
   public boolean isValidHelper(char[][] board, char number) {
       boolean[] rows = new boolean[9];
       boolean[] cols = new boolean[9];
       boolean[] blocks = new boolean[9];
       
       for (int r = 0; r < 9; r++) {
           for (int c = 0; c < 9; c++) {
               if (board[r][c] == number) {
                   if (rows[r] || cols[c] || blocks[3 * (r / 3) + (c / 3)]) {
                       return false;
                   } else {
                       rows[r] = true;
                       cols[c] = true; 
                       blocks[3 * (r / 3) + (c / 3)] = true;
                   }
               }
           }
       }
       return true;
   }

}
