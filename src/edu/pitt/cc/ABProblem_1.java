/**
 * 
 */
package edu.pitt.cc;

/**
 * A + B Problem #1 --- Accepted
 * Write a function that add two numbers A and B. You should not use + or any arithmetic operators. 
 * Example
 * Given a=1 and b=2 return 3
 * Note
 * There is no need to read data from standard input stream. Both parameters are given in function aplusb, you job is to calculate the sum and return it.
 * Challenge
 * Of course you can just return a + b to get accepted. But Can you challenge not do it like that?
 * Clarification
 * Are a and b both 32-bit integers?
    Yes.
 * Can I use bit operation?
    Sure you can.
 * @author yanma
 * @version 2015-09-28
 * @category CC
 * @week 9 0928-1004
 */
public class ABProblem_1 {
	/*
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        // write your code here, try to do it without arithmetic operators.
        if (a == 0) {
            return b;
        } else if (b == 0) {
            return a;
        }
        
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return aplusb(sum, carry);
    }

}
