/**
 * 
 */
package edu.pitt.easy;

import java.util.HashMap;

/**
 * Compare Strings #55 --- Accepted
 * Compare two strings A and B, determine whether A contains all of the characters in B.
 * The characters in string A and B are all Upper Case letters.
 * Example
 * For A = "ABCD", B = "ACD", return true.
 * For A = "ABCD", B = "AABC", return false.
 * Note
 * The characters of B in A are not necessary continuous or ordered.
 * @author yanma
 * @category Easy Level
 * @version 2015-08-03
 * @week 1 0803-0809
 */
public class CompareStrings_55 {
	/**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        if (A == null || A.length() < B.length()) {
            return false;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < A.length(); i++) {
            if (!map.containsKey(A.charAt(i))) {
                map.put(A.charAt(i), 1);
            } else {
                map.put(A.charAt(i), map.get(A.charAt(i)) + 1);   
            }
        }
        
        for (int i = 0; i < B.length(); i++) {
            if (!map.containsKey(B.charAt(i)) || map.get(B.charAt(i)) == 0) {
                return false;
            } else {
                map.put(B.charAt(i), map.get(B.charAt(i)) - 1);
            }
        }
        
        return true;
    }

}
