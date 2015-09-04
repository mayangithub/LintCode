/**
 * 
 */
package edu.pitt.twopointers;

import java.util.Arrays;

/**
 * Triangle Count #382 --- Accepted
 * Given an array of integers, how many three numbers can be found in the array, 
 * so that we can build an triangle whose three edges length is the three numbers that we find? 
 * Example
 * Given array S = [3,4,6,7], return 3. They are:
 * [3,4,6]
 * [3,6,7]
 * [4,6,7]
 * Given array S = [4,4,4,4], return 4. They are:
 * [4(1),4(2),4(3)]
 * [4(1),4(2),4(4)]
 * [4(1),4(3),4(4)]
 * [4(2),4(3),4(4)]
 * @author yanma
 * @category Two Pointers
 * @version 2015-09-03
 * @class 4
 * @week5 0831-0903
 */
public class TriangleCount_382 {
	
	/**
	 * O(nlogn) time
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        // write your code here
        if (S == null || S.length < 3) {
            return 0;
        }
        Arrays.sort(S);
        int count = 0;
        for (int i = 2; i < S.length; i++) {
            int j = i - 1; 
            int k = 0;
            while (k < j) {
                if (S[k] + S[j] <= S[i]) {
                    k++;
                } else {
                    count += j - k;
                    j--;
                }
            }
        }
        return count;   
    }

	/**
	 * O(n^3) time
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount1(int S[]) {
        // write your code here
        if (S == null || S.length < 3) {
            return 0;
        }
        Arrays.sort(S);
        int count = 0;
        for (int i = 2; i < S.length; i++) {
            for (int k = 0; k < i - 1; k++) {
                for (int j = k + 1; j < i; j++) {
                    if (S[j] + S[k] > S[i]) {
                        count++;
                    }
                }
            }
        }
        return count;   
    }
}
