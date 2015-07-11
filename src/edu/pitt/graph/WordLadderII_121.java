/**
 * 
 */
package edu.pitt.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Word Ladder II #121 --- Accepted
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
    Only one letter can be changed at a time
    Each intermediate word must exist in the dictionary
 *  Example
 * 	Given:
 * 	start = "hit"
 * 	end = "cog"
 * 	dict = ["hot","dot","dog","lot","log"]
 * 	Return
	  [
	    ["hit","hot","dot","dog","cog"],
	    ["hit","hot","lot","log","cog"]
	  ]
 * 	Note
 * 	    All words have the same length.
 * 	    All words contain only lowercase alphabetic characters.
 * @author yanma
 *
 */
public class WordLadderII_121 {
	
	
	/**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return a list of lists of string
     */
   public List<List<String>> findLadders(String start, String end, Set<String> dict) {
       // write your code here  
       List<List<String>> result = new ArrayList<List<String>>();
       HashMap<String, List<String>> listmap = new HashMap<String, List<String>>();
       HashMap<String, Integer> layermap = new HashMap<String, Integer>();
       Queue<String> queue = new LinkedList<String>();
       dict.add(end);
       dict.add(start);
       
       layermap.put(start, 1);
       queue.offer(start);
       
       build(end, dict, layermap, listmap, queue);

       List<String> inner = new ArrayList<String>();
       inner.add(start);
       helper(start, end, result, inner, listmap, layermap);
       
       return result;
   }
   
   public void helper(String start, String end, List<List<String>> result, List<String> inner, HashMap<String, List<String>> listmap, HashMap<String, Integer> layermap) {
       if (start.equals(end)) {
           result.add(new ArrayList<String>(inner));
           return;
       }
       
       for (String next: listmap.get(start)) {
           if (layermap.get(next) ==  layermap.get(start) + 1) { // to reduce time
               inner.add(next);
               helper(next, end, result, inner, listmap, layermap);
               inner.remove(inner.size() - 1);
           }
       }
   }
   
   public void build(String end, Set<String> dict, HashMap<String, Integer> layermap, HashMap<String, List<String>> listmap, Queue<String> queue) {
       while (!queue.isEmpty()) {
           String start = queue.poll();
           int length = start.length();
           int layer = layermap.get(start);
           listmap.put(start, new ArrayList<String>());
           for (int i = 0; i < length; i++) {
               for (char c = 'a'; c <= 'z'; c++) {
                   if (c != start.charAt(i)) {
                       String newword = replace(start, c, i);
                       if (dict.contains(newword)) {
                           if (!layermap.containsKey(newword)) {
                               layermap.put(newword, layer + 1);
                               queue.offer(newword);
                           }
                           listmap.get(start).add(newword);
                       }
                   }
               }
           }
           
       }
   }
   
   
   public String replace(String word, char c, int pos) {
       char[] carray = word.toCharArray();
       carray[pos] = c;
       return new String(carray);
   }
   
   

}
