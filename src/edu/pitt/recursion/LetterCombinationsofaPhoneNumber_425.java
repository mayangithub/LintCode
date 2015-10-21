/**
 * 
 */
package edu.pitt.recursion;

import java.util.ArrayList;

/**
 * Letter Combinations of a Phone Number #425 --- Accepted
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Example
 * Given "23"
 * Return ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 * Note
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 * @author yanma
 * @version 2015-10-21
 * @category Recursion
 * @week12 1019-1025
 */
public class LetterCombinationsofaPhoneNumber_425 {
	/**
     * @param digits A digital string
     * @return all posible letter combinations
     */
    public ArrayList<String> letterCombinations(String digits) {
        // Write your code here
        ArrayList<String> result = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        String[] buttons = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(digits, 0, buttons, result, new StringBuffer());
        
        return result;
    }
    
    public void helper(String digits, int index, String[] buttons, ArrayList<String> result, StringBuffer bf) {
        if (index == digits.length()) {
            result.add(bf.toString());
            return;
        }
        
        int digit = digits.charAt(index) - '0';
        if (digit == '0' || digit == '1') {
            helper(digits, index + 1, buttons, result, bf);
            return;
        }
        for (int i = 0; i < buttons[digit].length(); i++) {
            bf.append(buttons[digit].charAt(i));
            helper(digits, index + 1, buttons, result, bf);
            bf.deleteCharAt(bf.length() - 1);
        }
    }

}
