/**
 * 
 */
package edu.pitt.easy;

import java.util.ArrayList;

/**
 * Longest Words #133 --- Accepted
 * Given a dictionary, find all of the longest words in the dictionary.
 * Example
 * Given
	{
	  "dog",
	  "google",
	  "facebook",
	  "internationalization",
	  "blabla"
	}
 * the longest words are(is) ["internationalization"].
 * Given
	{
	  "like",
	  "love",
	  "hate",
	  "yes"
	}
 * the longest words are ["like", "love", "hate"].
 * Challenge
 * It's easy to solve it in two passes, can you do it in one pass?
 * @author yanma
 * @category Easy Level
 * @version 2015-08-05
 * @week1 0803-0809
 */
public class LongestWords_133 {
	
	/**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        // write your code here
        ArrayList<String> result = new ArrayList<String>();
        if (dictionary == null || dictionary.length == 0) {
            return result;
        }
        
        int max = dictionary[0].length();
        int i = 0;
        while (i < dictionary.length) {
            if (dictionary[i].length() == max) {
                result.add(dictionary[i]);
            } else if (dictionary[i].length() > max) {
                max = dictionary[i].length();
                result = new ArrayList<String>();
                result.add(dictionary[i]);
            }
            i++;
        }
        
        return result;
    }

}
