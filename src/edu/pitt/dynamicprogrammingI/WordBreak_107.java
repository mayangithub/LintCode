/**
 * 
 */
package edu.pitt.dynamicprogrammingI;

import java.util.Set;

/**
 * Word Break #107 --- Accepted
 * Given a string s and a dictionary of words dict, 
 * determine if s can be break into a space-separated sequence of one or more dictionary words.
 * Example
 * Given s = "lintcode", dict = ["lint", "code"].
 * Return true because "lintcode" can be break as "lint code".
 * @author yanma
 * @category DPI
 * @version 2015-06-30
 * @class 4
 */
public class WordBreak_107 {
	
	/**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here   
        /**
         * state: f[i] means whether the first i letters can be break into words
         * function: f[i] = OR(f[j] && j + 1 ~ i is a word in dict) i - maxWordLength < j <= i
         * initialization: f[0] = true
         * answer: f[s.length]
         */
        if (s == null) {
            return false;
        }
        
        int maxlength = findMaxLen(dict);
        int n = s.length();
        boolean[] truthtable = new boolean[n + 1];
        truthtable[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = Math.max(i - maxlength, 0); j < i; j++) { //j at least should be more than 0
                if (truthtable[j] && dict.contains(s.substring(j, i))) {
                    truthtable[i] = true;
                    break;
                }
            }
        }
        
        return truthtable[n];
    }
    
    public int findMaxLen(Set<String> dict) {
        int max = 0;
        for (String word: dict) {
            if (word.length() > max) {
               max = word.length(); 
            }
        }
        return max;
    }

}
