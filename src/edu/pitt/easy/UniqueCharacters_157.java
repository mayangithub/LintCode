/**
 * 
 */
package edu.pitt.easy;

/**
 * Unique Characters #157 --- Accepted
 * Implement an algorithm to determine if a string has all unique characters.
 * Example
 * Given "abc", return true.
 * Given "aab", return false.
 * Challenge
 * What if you can not use additional data structures?
 * @author yanma
 * @category Easy Level
 * @version 2015-08-05
 * @week1 0803-0809
 */
public class UniqueCharacters_157 {
	/**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // write your code here
        if (str.length() > 256) {
            return false;
        }
        
        boolean[] table = new boolean[256];
        int i = 0;
        while (i < str.length()) {
            int value = str.charAt(i);
            if (table[value]) {
                return false;
            }
            table[value] = true;
            i++;
        }
        
        return true;        
    }

}
