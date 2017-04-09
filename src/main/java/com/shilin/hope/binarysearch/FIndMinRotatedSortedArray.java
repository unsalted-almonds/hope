package com.shilin.hope.binarysearch;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * Notice
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Have you met this question in a real interview? Yes Example Given [4, 5, 6,
 * 7, 0, 1, 2] return 0
 * 
 * @author Shilin_Gan
 *
 */
public class FIndMinRotatedSortedArray {
	/**
	 * @param nums:
	 *            a rotated sorted array
	 * @return: the minimum number in the array
	 */
	public int findMin(int[] nums) {
		// write your code here

		int ans = 0;
		if (nums == null || nums.length == 0) {
			return ans;
		}

		int left = 0;
		int right = nums.length - 1;

		// ... left ... mid ... right ...

		// left + 1 < right ensures mid won't be equal to left or right
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;

			// if right half is sorted
			// mid is candidate for answer
			if (nums[mid] < nums[right]) {
				right = mid;
			}
			// if left half is sorted
			// mid is not considered candidate for answer
			else {
				left = mid + 1;
			}
		}

		if (nums[left] < nums[right]) {
			return nums[left];
		} else {
			return nums[right];
		}

	}
}
