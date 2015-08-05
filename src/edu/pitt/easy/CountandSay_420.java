/**
 * 
 */
package edu.pitt.easy;

/**
 * Count and Say #420 --- Accepted
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Example
 * Given n = 5, return "111221".
 * Note
 * The sequence of integers will be represented as a string.
 * @author yanma
 * @category Easy Level
 * @version 2015-08-04
 * @week 1 0803-0809
 */
public class CountandSay_420 {
	
	/**
     * @param n the nth
     * @return the nth sequence
     */
    public String countAndSay(int n) {
        // Write your code here
        if (n <= 0) {
            return "";
        }
        
        String previous = "1";
        int rank = 1;
        while (rank < n) {
            previous = helper(previous);
            rank++;
        }
        
        return previous;
    }
    
    public String helper(String previous) {
        StringBuffer bf = new StringBuffer();
        int num = 1;
        int pos = 1;
        char digit = previous.charAt(0);
        while (pos < previous.length()) {
            if (previous.charAt(pos) == digit) {
                num++;
            } else {
                bf.append(num + "" + digit);
                digit = previous.charAt(pos);
                num = 1;
            }
            pos++;
        }
        
        if (num > 0) {
            bf.append(num + "" + digit);
        }
        
        return bf.toString();
    }

}
