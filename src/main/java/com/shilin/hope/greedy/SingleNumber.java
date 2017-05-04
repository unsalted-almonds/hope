package com.shilin.hope.greedy;

/**
 * Given 2*n + 1 numbers, every numbers occurs twice except one, find it.
 * 
 * Example Given [1,2,2,1,3,4,3], return 4
 * 
 * @author Shilin
 *
 */
public class SingleNumber {
	/**
	 * @param A
	 *            : an integer array return : a integer
	 */
	public int singleNumber(int[] A) {
		// Write your code here

		if (A == null || A.length == 0) {
			return 0;
		}

		int res = 0;

		for (int i : A) {
			res ^= i;
		}

		return res;
		/*
		 * Set<Integer> occurance = new HashSet<Integer>();
		 * 
		 * for (int i : A) { if (occurance.contains(i)){ occurance.remove(i); }
		 * else { occurance.add(i); } }
		 * 
		 * Iterator<Integer> iter = occurance.iterator();
		 * 
		 * return iter.next();
		 */
	}
}
