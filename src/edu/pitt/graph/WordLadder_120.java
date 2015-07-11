/**
 * 
 */
package edu.pitt.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Word Ladder #120 --- Accepted
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

    Only one letter can be changed at a time
    Each intermediate word must exist in the dictionary
 *  Example
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Note
    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
 * @author yanma
 * @category Graph and Search
 * @version 2015-07-10
 * @class 7
 */
public class WordLadder_120 {
	
	
	/**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return an integer
     */
   public int ladderLength(String start, String end, Set<String> dict) {
       // write your code here
       Queue<String> queue = new LinkedList<String>();
       queue.offer(start);
       dict.add(end);
       int length = start.length();
       int layer = 1;
       while (!queue.isEmpty()) {
           int size = queue.size();
           layer++;
           for (int s = 0; s < size; s++) {
               String word = queue.poll();
               for (int j = 0; j < length; j++) {
                   for (char c = 'a'; c <= 'z'; c++) {
                       if (c != word.charAt(j)) {
                           String newword = replace(word, c, j);
                           if (newword.equals(end)) {
                               return layer;
                           }
                           if (dict.contains(newword)) {
                               queue.offer(newword);
                               dict.remove(newword);
                           }
                       }
                   }
               }
           }
       }
       
       return 0;
   }
   
   public String replace(String word, char c, int pos) {
       char[] chararray = word.toCharArray();
       chararray[pos] = c;
       return new String(chararray);
   }

}
