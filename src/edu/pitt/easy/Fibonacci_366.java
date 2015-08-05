/**
 * 
 */
package edu.pitt.easy;

/**
 * Fibonacci #366 --- Accepted
 * Find the Nth number in Fibonacci sequence.
 * A Fibonacci sequence is defined as follow:
 *   The first two numbers are 0 and 1.
 *   The i th number is the sum of i-1 th number and i-2 th number.
 * The first ten numbers in Fibonacci sequence is:
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...
 * Example
 * Given 1, return 0
 * Given 2, return 1
 * Given 10, return 34
 * Note
 * The Nth fibonacci number won't exceed the max value of signed 32-bit integer in the test cases.
 * @author yanma
 * @category Easy Level
 * @version 2015-08-04
 * @week1 0803-0809
 */
public class Fibonacci_366 {
	/**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        if (n <= 1) {
            return 0;
        } else if (n == 2) {
            return 1;   
        }
        
        int first = 0;
        int second = 1;
        int count = 2;
        while (count < n) {
            int sum = first + second;
            first = second;
            second = sum;
            count++;
        }
        return second;
    }

}
