/**
 * 
 */
package edu.pitt.dynamicprogrammingII;

/**
 * Backpack #92 --- Accepted
 * Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack? 
 * Example
 * If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5], 
 * so that the max size we can fill this backpack is 10. If the backpack size is 12. 
 * we can select [2, 3, 7] so that we can fulfill the backpack.
 * You function should return the max size we can fill in the given backpack.
 * Note
 * You can not divide any item into small pieces.
 * Challenge
 * O(n x m) time and O(m) memory.
 * O(n x m) memory is also acceptable if you do not know how to optimize memory.
 * @author yanma
 * @category DP II, Backpack
 * @version 2015-07-02
 * @class 5
 */
public class Backpack_92 {
	
	 /**
	 * O(m) space and O(n * m) time
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        /**
         * state: f[j] means the maximum weight can be placed in backpack with first i items and backpack size j
         * function: if A[i - 1] > j, f[j] = f[j],
         *           else, f[j] = MAX{A[i - 1] + f[j - A[i - 1]], f[j]}
         * initialization: f[j] = 0
         * answer: f[m]
         * the reason why go from tail to head, is to avoid changing previous value before using it
         */
        if (A == null || A.length == 0 || m == 0) {
            return 0;
        }
        
        int len = A.length;
        int[] full = new int[m + 1];
        for (int j = 0; j <= m; j++) {
            full[j] = 0;
        }
        
        for (int i = 1; i <= len; i++) {
            for (int j = m; j >= 0; j--) {
                if (A[i - 1] > j) {
                    continue;
                } else {
                    full[j] = Math.max(A[i - 1] + full[j - A[i - 1]], full[j]);
                }
            }
        }
        return full[m];
    }
	
	
	/**
	 * Using O(n * m) space and O(n * m) time
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack1(int m, int[] A) {
        // write your code here
        /**
         * state: f[i][j] means the maximum weight can be placed in backpack with first i items and backpack size j
         * function: if A[i - 1] > j, f[i][j] = f[i - 1][j],
         *           else, f[i][j] = MAX{A[i - 1] + f[i - 1][j - A[i - 1]], f[i - 1][j]}
         * initialization: f[i][0] = 0, f[0][j] = 0
         * answer: f[A.len][m]
         */
        if (A == null || A.length == 0 || m == 0) {
            return 0;
        }
        
        int len = A.length;
        int[][] full = new int[len + 1][m + 1];
        for (int j = 0; j <= m; j++) {
            full[0][j] = 0;
        }
        for (int i = 1; i <= len; i++) {
            full[i][0] = 0;
        }
        
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i - 1] > j) {
                    full[i][j] = full[i - 1][j];
                } else {
                    full[i][j] = Math.max(A[i - 1] + full[i - 1][j - A[i - 1]], full[i - 1][j]);
                }
            }
        }
        return full[len][m];
    }
	

}
