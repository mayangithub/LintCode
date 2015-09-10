/**
 * 
 */
package edu.pitt.easy;

/**
 * Space Replacement #212 --- Accepted
 * Write a method to replace all spaces in a string with %20. 
 * The string is given in a characters array, 
 * you can assume it has enough space for replacement and you are given the true length of the string.
 * Example
 * Given "Mr John Smith", length = 13.
 * The string after replacement should be "Mr%20John%20Smith".
 * Note
 * If you are using Java or Python，please use characters array instead of string.
 * Challenge
 * Do it in-place.
 * @author yanma
 * @category Easy
 * @version 2015-09-09
 * @week 6 0907-0913
 */
public class SpaceReplacement_212 {
	
	/**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        // Write your code here
        if (string == null || string.length == 0) {
            return 0;
        }
        
        int spaces = 0;
        for (int i = 0; i < length; i++) {
            if (string[i] == ' ') {
                spaces++;
            }
        }
        
        int newlength = length + spaces * 2;
        int i = length - 1;
        int j = newlength - 1;
        while (i >= 0 && j >= 2) {
            if (string[i] != ' ') {
                string[j] = string[i];
                j--;
            } else {
                string[j] = '0';
                string[j - 1] = '2';
                string[j - 2] = '%';
                j -= 3;
            }
            i--;
        }
        
        return newlength;
    }

}
