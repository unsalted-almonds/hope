package com.pecan.hope.binarysearch;

/**
 * For a given sorted array (ascending order) and a target number, find the
 * first index of this number in O(log n) time complexity.
 * 
 * If the target number does not exist in the array, return -1.
 * 
 * If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
 * 
 * @author Shilin
 *
 */
public class FirstPositionSearch {
	/**
	 * @param nums:
	 *            The integer array.
	 * @param target:
	 *            Target to find.
	 * @return: The first position of target. Position starts from 0.
	 */
	public int binarySearch(int[] nums, int target) {
		// write your code here

		int ans = -1;
		if (nums == null || nums.length == 0) {
			return ans;
		}

		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {

			int mid = (left + right) / 2;

			if (nums[mid] == target) {
				ans = mid;
				right = mid - 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}

		}

		return ans;

	}
}
