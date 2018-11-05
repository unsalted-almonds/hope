package com.pecan.hope.datastructure;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * Clarification Your algorithm should run in O(n) complexity.
 * 
 * Example Given [100, 4, 200, 1, 3, 2], The longest consecutive elements
 * sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * @author Shilin
 *
 */
public class LongestConsecutiveSequence {
	/*
	 * @param num: A list of integers
	 * 
	 * @return: An integer
	 */
	public int longestConsecutive(int[] num) {
		// write your code here
		int result = 0;
		if (num == null || num.length == 0) {
			return result;
		}

		Set<Integer> numSet = new HashSet<>();

		for (int n : num) {
			numSet.add(n);
		}

		for (int n : num) {
			int tmp = 0;

			while (numSet.contains(n)) {
				tmp++;
				numSet.remove(n);
				int right = n + 1;
				while (numSet.contains(right)) {
					tmp++;
					numSet.remove(right);
					right++;
				}
				int left = n - 1;
				while (numSet.contains(left)) {
					tmp++;
					numSet.remove(left);
					left--;
				}
				result = Math.max(result, tmp);
			}
		}

		return result;

	}
}
