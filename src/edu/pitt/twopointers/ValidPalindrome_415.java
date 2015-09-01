/**
 * 
 */
package edu.pitt.twopointers;

/**
 * Valid Palindrome #415 --- Accepted
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * Example
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Note
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 * Challenge
 * O(n) time without extra memory.
 * @author yanma
 * @category Two Pointers -- collision
 * @version 2015-08-31
 * @class 4
 * @week5 0831-0906
 */
public class ValidPalindrome_415 {
	/**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // Write your code here
        if (s == null || s.length() <= 1) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetter(s.charAt(left)) && !Character.isDigit(s.charAt(left))) {
                left++;
            }
            
            while (left < right && !Character.isLetter(s.charAt(right)) && !Character.isDigit(s.charAt(right))) {
                right--;
            }
            
            if (left == right) {
                break;
            }
            char leftchar = s.charAt(left);
            char rightchar = s.charAt(right);
            if (Character.isLetter(leftchar)) {
                leftchar = Character.toLowerCase(leftchar);
            }
            if (Character.isLetter(rightchar)) {
                rightchar = Character.toLowerCase(rightchar);
            }
            
            if (leftchar != rightchar) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
