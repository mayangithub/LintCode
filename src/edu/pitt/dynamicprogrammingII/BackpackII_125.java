/**
 * 
 */
package edu.pitt.dynamicprogrammingII;

/**
 * Backpack II #125 --- Accepted
 * Given n items with size Ai and value Vi, and a backpack with size m. 
 * What's the maximum value can you put into the backpack?
 * Example
 * Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 9.
 * Note
 * You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.
 * Challenge
 * O(n x m) memory is acceptable, can you do it in O(m) memory?
 * @author yanma
 * @category DP II, Backpack
 * @version 2015-07-02
 * @class 5
 */
public class BackpackII_125 {
	
	/**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        /**
         * state: f[j] means the maximum value of first i items in backpack with size j
         * function: if A[i - 1] > j, f[j] = f[j]; 
         *           else, f[j] = Math.max{V[i - 1] + f[j - A[i - 1]], f[j]}
         * initialization: f[j] = 0
         * answer: f[m]
         */
        
        if (m == 0 || A == null || A.length == 0 || A.length != V.length) return 0;
        
        int len = A.length;
        int[] value = new int[m + 1]; // size
        
        for (int i = 1; i <= len; i++) {
            for (int j = m; j >= 1; j--) {
                if (A[i - 1] <= j) { //index not size
                    value[j] = Math.max(V[i - 1] + value[j - A[i - 1]], value[j]);
                }
            }
        }
        return value[m];
    }
	
	

}
