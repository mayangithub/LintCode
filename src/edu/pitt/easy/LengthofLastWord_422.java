/**
 * 
 */
package edu.pitt.easy;

/**
 * Length of Last Word #422 --- Accepted
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Example
 * Given s = "Hello World", return 5.
 * Note
 * A word is defined as a character sequence consists of non-space characters only.
 * @author yanma
 * @category Easy Level
 * @version 2015-08-05
 * @week1 0803-0809
 */
public class LengthofLastWord_422 {
	
	/**
     * @param s A string
     * @return the length of last word
     */
    public int lengthOfLastWord(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        
        int length = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }
        
        return length;
    }

}
