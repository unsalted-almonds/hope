package com.pecan.hope.dp;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 * 
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has
 * the largest product = 6.
 * 
 * @author Shilin
 *
 */
public class MaxProductSubarray {
	/*
	 * @param nums: An array of integers
	 * 
	 * @return: An integer
	 */
	public int maxProduct(int[] nums) {
		// write your code here
		int result = Integer.MIN_VALUE;
		if (nums == null || nums.length == 0) {
			return result;
		}

		int[] max = new int[nums.length];
		int[] min = new int[nums.length];

		result = max[0] = min[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {
			max[i] = min[i] = nums[i];
			if (nums[i] > 0) {
				max[i] = Math.max(max[i], max[i] * max[i - 1]);
				min[i] = Math.min(min[i], min[i] * min[i - 1]);
			} else if (nums[i] < 0) {
				max[i] = Math.max(max[i], max[i] * min[i - 1]);
				min[i] = Math.min(min[i], min[i] * max[i - 1]);
			}
			result = Math.max(result, max[i]);

		}

		return result;
	}
}
