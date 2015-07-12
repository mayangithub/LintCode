/**
 * 
 */
package edu.pitt.graph;

import java.util.ArrayList;

/**
 * N-Queens #33 --- Accepted
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, 
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 *  Example
 * There exist two distinct solutions to the 4-queens puzzle:
 * [
    [".Q..", // Solution 1
     "...Q",
     "Q...",
     "..Q."],
    ["..Q.", // Solution 2
     "Q...",
     "...Q",
     ".Q.."]
 * ]
 * Challenge
 * Can you do it without recursion?
 * @author yanma
 * @category Graph and Search
 * @version 2015-07-11
 * @class 7
 */
public class NQueens_33 {
	
	/**
	 * using Arraylist<Integer> is faster than using int[]
	 * using recursion
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        if (n <= 0) {
            return list;
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        permutation(n, result, list, new ArrayList<Integer>());
        
        return list;
    }
    
    void permutation(int n, ArrayList<ArrayList<Integer>> result, ArrayList<ArrayList<String>> list, ArrayList<Integer> board) {
        if (board.size() == n) {
            draw(n, board, list);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (testBoard(board, i)) { 
                board.add(i);
                permutation(n, result, list, board);
                board.remove(board.size() - 1);
            }
        }
    }
    
    void draw(int n, ArrayList<Integer> board, ArrayList<ArrayList<String>> list) {
        ArrayList<String> inner = new ArrayList<String>();
        for (int row = 0; row < n; row++) {
            StringBuffer bf = new StringBuffer();
            for (int i = 0; i < n; i++) {
                if (i != board.get(row)) {
                    bf.append(".");
                } else {
                    bf.append("Q");
                }
            }
            inner.add(bf.toString());
        }
        list.add(inner);
    }
    
    boolean testBoard(ArrayList<Integer> board, int col) {
        for (int i = 0; i < board.size(); i++) {
            if (board.get(i) == col) {
                return false;
            }
            if (board.get(i) + i == col + board.size()) {
                return false;
            }
            if (board.get(i) - i == col - board.size()) {
                return false;
            }
        }
        return true;
    }

}
