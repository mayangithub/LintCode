/**
 * 
 */
package edu.pitt.highfrequency;

/**
 * Sort Letters by Case #49 --- Accepted
 * Given a string which contains only letters. Sort it by lower case first and upper case second.
 *  Example
 * For "abAcD", a reasonable answer is "acbAD"
 * Note
 * It's not necessary to keep the original order of lower-case letters and upper case letters.
 * Challenge
 * Do it in one-pass and in-place.
 * @author yanma
 * @category High Frequency
 * @version 2015-08-08
 * @class 9
 */
public class SortLettersbyCase_49 {
	/** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
        if (chars == null || chars.length == 0) {
            return;
        }
        
        int i = -1;
        int j = 0;
        while (j < chars.length) {
            if (chars[j] >= 'a' && chars[j] <= 'z') {
                char temp = chars[i + 1];
                chars[i + 1] = chars[j];
                chars[j] = temp;
                i++;
                j++;
            } else {
                j++;
            }
        }
    }

}
