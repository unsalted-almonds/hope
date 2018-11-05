package com.pecan.hope.twosum;

import java.util.Arrays;

/**
 * Given an array of integers, find how many pairs in the array such that their
 * sum is bigger than a specific target number. Please return the number of
 * pairs. Example Given numbers = [2, 7, 11, 15], target = 24. Return 1. (11 +
 * 15 is the only pair)
 * 
 * @author Shilin
 *
 */
public class TwoSum2 {

	/**
	 * @param nums:
	 *            an array of integer
	 * @param target:
	 *            an integer
	 * @return: an integer
	 */
	public int twoSum2(int[] nums, int target) {
		// Write your code here

		// sort the array
		Arrays.sort(nums);

		int ans = 0;

		int left = 0;
		int right = nums.length - 1;

		while (left < right) {

			if (nums[left] + nums[right] > target) {

				ans = ans + right - left;
				right--;
			} else {
				left++;
			}
		}

		return ans;
	}

}
