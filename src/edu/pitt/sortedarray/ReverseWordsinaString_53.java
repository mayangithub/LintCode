/**
 * 
 */
package edu.pitt.sortedarray;

/**
 * Reverse Words in a String  #53 --- Accepted
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 *  Example
 * Clarification
 *     What constitutes a word?
 *     A sequence of non-space characters constitutes a word.
 *     Could the input string contain leading or trailing spaces?
 *     Yes. However, your reversed string should not contain leading or trailing spaces.
 *     How about multiple spaces between two words?
 *     Reduce them to a single space in the reversed string.
 * @author yanma
 * @category Sorted Array
 * @version 2015-06-20
 * @class 2
 */
public class ReverseWordsinaString_53 {

	/**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        // write your code
        if (s == null || s.length() == 0) {
            return s;
        }
        
        //delete leading spaces
        int start = 0;
        while (start < s.length() && s.charAt(start) == ' ') {
            start++;
        }
        s = s.substring(start);
        if (s.length() == 0) {
            return s;
        }
        //delete trailing spaces
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        s = s.substring(0, end + 1);
        if (s.length() == 0) {
            return s;
        }
        
        
        StringBuffer bf = new StringBuffer();
        start = 0;
        end = start + 1;
        while (end < s.length()) {
            if (s.charAt(start) == ' ') {
                start++;
                end = start + 1;
            }
            if (s.charAt(end) == ' ') {
                bf.append(reverse(s.substring(start, end)) + " ");
                start = end;
                end = start + 1;
            } else {
                end++;
            }
        }
        
        if (start < s.length()) {
            bf.append(reverse(s.substring(start)));
        }
        
        s = bf.toString();
        s = reverse(s);
        
        return s;
    }
    
    public String reverse(String s) {
        int size = s.length();
        int start = 0;
        int end = size - 1;
        char[] array = s.toCharArray();
        while (start + 1 < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
        
        char temp = array[start];
        array[start] = array[end];
        array[end] = temp;
        
        s = new String(array);
        return s;
    }
    
	
}
