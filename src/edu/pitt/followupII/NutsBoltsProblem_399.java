/**
 * 
 */
package edu.pitt.followupII;

/**
 * Nuts & Bolts Problem #399 --- Accepted
 * Given a set of n nuts of different sizes and n bolts of different sizes. 
 * There is a one-one mapping between nuts and bolts. 
 * Comparison of a nut to another nut or a bolt to another bolt is not allowed. 
 * It means nut can only be compared with bolt and bolt can only be compared with nut to see 
 * which one is bigger/smaller.
 * We will give you a compare function to compare nut with bolt.
 * Example
 * Given nuts = ['ab','bc','dd','gg'], bolts = ['AB','GG', 'DD', 'BC'].
 * Your code should find the matching bolts and nuts.
 * one of the possible return:
 * nuts = ['ab','bc','dd','gg'], bolts = ['AB','BC','DD','GG'].
 * we will tell you the match compare function. If we give you another compare function.
 * the possible return is the following:
 * nuts = ['ab','bc','dd','gg'], bolts = ['BC','AA','DD','GG'].
 * So you must use the compare function that we give to do the sorting.
 * The order of the nuts or bolts does not matter. You just need to find the matching bolt for each nut.
 * @author yanma
 * @version 2015-11-06
 * @category Follow Up II
 * 
 */
public class NutsBoltsProblem_399 {
	 /** You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
	 * if "a" is bigger than "b", it will return 1, else if they are equal,
	 * it will return 0, else if "a" is smaller than "b", it will return -1.
	 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
	 */
	 public class NBComparator {
	     public int cmp(String a, String b) {
	    	 if (a.compareTo(b) < 0) {
	    		 return -1;
	    	 } else if (a.equals(b)) {
	    		 return 0;
	    	 } else {
	    		 return 1;
	    	 }
	     }
	 }
	/**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        // write your code here
        
        if (nuts == null || bolts == null || nuts.length != bolts.length) {
            return;
        }
        helper(nuts, bolts, 0, bolts.length - 1, compare);
    }
    
    public void helper(String[] nuts, String[] bolts, int l, int u, NBComparator compare) {
        if (l >= u) return;
        int index = split(bolts, nuts[l], l, u, compare);
        split(nuts, bolts[index], l, u, compare);

        helper(nuts, bolts, l, index - 1, compare);
        helper(nuts, bolts, index + 1, u, compare);
    }
    
    public int split(String[] array, String pivot, int l, int u, NBComparator compare) {
        int m = l;

        for (int i = l + 1; i <= u; i++) {
            if (compare.cmp(array[i], pivot) == -1 || compare.cmp(pivot, array[i]) == 1) {
                m++;
                swap(array, m, i);
            } else if (compare.cmp(array[i], pivot) == 0 || compare.cmp(pivot, array[i]) == 0) {
                swap(array, l, i);
                i--;
            }
        }
        swap(array, l, m);
        
        return m;
    }
    
    public void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
