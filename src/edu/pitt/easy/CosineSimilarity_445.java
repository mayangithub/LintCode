/**
 * 
 */
package edu.pitt.easy;

/**
 * Cosine Similarity #445 --- Accepted
 * Cosine similarity is a measure of similarity between two vectors of an inner product space 
 * that measures the cosine of the angle between them. 
 * The cosine of 0° is 1, and it is less than 1 for any other angle.
 * Given two vectors A and B with the same size, calculate the cosine similarity.
 * Return 2.0000 if cosine similarity is invalid (for example A = [0] and B = [0]).
 * Example
 * Given A = [1, 2, 3], B = [2, 3 ,4].
 * Return 0.9926.
 * Given A = [0], B = [0].
 * Return 2.0000
 * @author yanma
 * @version 2015-10-21
 * @category Easy
 * @week12 1019-1025
 */
public class CosineSimilarity_445 {
	/**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: Cosine similarity.
     */
    public double cosineSimilarity(int[] A, int[] B) {
        // write your code here
        if (A == null || B == null || A.length == 0 || B.length == 0 || A.length != B.length) {
            return 2;
        }
        
        // A[0] B[0] return 2;
        // A[0,0,0,0,0] B[0,0,0,0,0] return 2;
        // A[1,0] B[0,1] not return 1;
        
        long upper = upper(A, B);
        double lower = lower(A, B);
        if (lower == 0) {
            return 2;   
        }
        
        int i = 0;
        while (i < A.length) {
            if (A[i] != B[i]) {
                break;
            }
            i++;
        }
        if (i == A.length) return 1;
        
        return (double) upper / lower;
    }
    
    public long upper(int[] A, int[] B) {
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i] * B[i];
        }
        return sum;
    }
    
    public double lower(int[] A, int[] B) {
        long sumA = 0; 
        long sumB = 0;
        for (int i = 0; i < A.length; i++) {
            sumA += Math.pow(A[i], 2);
            sumB += Math.pow(B[i], 2);
        }
        long times = sumA * sumB;
        return Math.sqrt(times);
    }

}
