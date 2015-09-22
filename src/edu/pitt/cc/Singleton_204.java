/**
 * 
 */
package edu.pitt.cc;

/**
 * Singleton #204 --- Accepted
 * Singleton is a most widely used design pattern. 
 * If a class has and only has one instance at every moment, we call this design as singleton. 
 * For example, for class Mouse (not a animal mouse), we should design it in singleton.
 * You job is to implement a getInstance method for given class, 
 * return the same instance of this class every time you call this method.
 * Example
 * In Java:
 * A a = A.getInstance();
 * A b = A.getInstance();
 * a should equal to b.
 * Challenge
 * If we call getInstance concurrently, can you make sure your code could run correctly?
 * @author yanma
 * @category CC
 * @version 2015-09-21
 * @week 8 0921-0927
 */
public class Singleton_204 {
	/**
     * @return: The same instance of this class every time
     */
    private static Singleton_204 slt = null;
    public static Singleton_204 getInstance() {
        // write your code here
        if (slt == null) {
            slt = new Singleton_204();
        }
        return slt;
    }

}
