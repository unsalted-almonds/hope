package com.pecan.hope.dp;

/**
 * Given an array of integers, find a contiguous subarray which has the largest
 * sum.
 * 
 * Notice
 * 
 * The subarray should contain at least one number.
 * 
 * Example Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray
 * [4,−1,2,1] has the largest sum = 6.
 * 
 * @author Shilin
 *
 */
public class MaxSubArray {
	/**
	 * @param nums:
	 *            A list of integers
	 * @return: A integer indicate the sum of max subarray
	 */
	public int maxSubArray(int[] nums) {
		// write your code
		int result = Integer.MIN_VALUE;

		if (nums == null || nums.length == 0) {
			return result;
		}

		int sum = 0;
		for (int i : nums) {
			sum += i;
			if (sum > result) {
				result = sum;
			}
			if (sum < 0) {
				sum = 0;
			}
		}

		return result;
	}
}
