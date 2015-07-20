/**
 * 
 */
package edu.pitt.datastructure;

/**
 * Hash Function #128 --- Accepted
 * In data structure Hash, hash function is used to convert a string(or any other type) into an integer smaller than hash size and bigger or equal to zero. The objective of designing a hash function is to "hash" the key as unreasonable as possible. A good hash function can avoid collision as less as possible. A widely used hash function algorithm is using a magic number 33, consider any string as a 33 based big integer like follow:
 * 	hashcode("abcd") = (ascii(a) * 333 + ascii(b) * 332 + ascii(c) *33 + ascii(d)) % HASH_SIZE 
 *                   = (97* 333 + 98 * 332 + 99 * 33 +100) % HASH_SIZE
 *                   = 3595978 % HASH_SIZE
 * 	here HASH_SIZE is the capacity of the hash table (you can assume a hash table is like an array with index 0 ~ HASH_SIZE-1).
 * 	Given a string as a key and the size of hash table, return the hash value of this key.
 *  Example
 * 	For key="abcd" and size=100, return 78
 * 	Clarification	
 * 	For this problem, you are not necessary to design your own hash algorithm or consider any collision issue, you just need to implement the algorithm as described.
 * @author yanma
 * @category Data Structure
 * @version 2015-07-20
 * @class 8
 */
public class HashFunction_128 {
	
	
	public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
        if (key == null || key.length == 0) {
            return 0;
        }
        
        int size = key.length;
        
        long sum = 0; // long type
        for (int i = 0; i < size; i++) {
            sum = sum * 33 + (int) key[i]; // IMPORTANT!!!
            sum = sum % HASH_SIZE;
        }
        
        return (int) sum;
    }

}
