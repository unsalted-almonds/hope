package com.shilin.hope.dp;

/**
 * Given a sequence of integers, find the longest increasing subsequence (LIS).
 * 
 * You code should return the length of the LIS.
 * 
 * Have you met this question in a real interview? Yes Clarification What's the
 * definition of longest increasing subsequence?
 * 
 * The longest increasing subsequence problem is to find a subsequence of a
 * given sequence in which the subsequence's elements are in sorted order,
 * lowest to highest, and in which the subsequence is as long as possible. This
 * subsequence is not necessarily contiguous, or unique.
 * 
 * https://en.wikipedia.org/wiki/Longest_increasing_subsequence
 * 
 * Example For [5, 4, 1, 2, 3], the LIS is [1, 2, 3], return 3 For [4, 2, 4, 5,
 * 3, 7], the LIS is [2, 4, 5, 7], return 4
 * 
 * @author Shilin
 *
 */
public class LIS {
	/**
	 * @param nums:
	 *            The integer array
	 * @return: The length of LIS (longest increasing subsequence)
	 */
	public int longestIncreasingSubsequence(int[] nums) {
		// write your code here
		int result = 0;

		if (nums == null || nums.length == 0) {
			return result;
		}

		int[] solution = new int[nums.length + 1];
		solution[0] = 0;

		for (int i = 1; i < solution.length; i++) {
			solution[i] = 1;
		}

		for (int i = 1; i < solution.length; i++) {
			for (int j = 1; j < i; j++) {
				if (nums[j - 1] < nums[i - 1] && solution[j] + 1 > solution[i]) {
					solution[i] = solution[j] + 1;
				}
			}
			if (solution[i] > result) {
				result = solution[i];
			}
		}

		return result;
	}
}
