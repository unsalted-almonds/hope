package com.shilin.hope.binarysearch;

/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume NO duplicates in the array.
 * 
 * Example [1,3,5,6], 5 → 2
 * 
 * [1,3,5,6], 2 → 1
 * 
 * [1,3,5,6], 7 → 4
 * 
 * [1,3,5,6], 0 → 0
 * 
 * @author Shilin_Gan
 *
 */
public class SearchInsertPosition {
	/**
	 * param A : an integer sorted array param target : an integer to be
	 * inserted return : an integer
	 */
	public int searchInsert(int[] A, int target) {
		// write your code here

		// O(n) is easy. make it o(logn)

		int ans = 0;

		if (A == null || A.length == 0) {
			return ans;
		}

		if (A[A.length - 1] < target) {
			return A.length;
		}

		int left = 0;
		int right = A.length - 1;

		while (left <= right) {

			int mid = (left + right) / 2;

			if (A[mid] == target) {
				return mid;
			} else if (A[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
				ans = mid;
			}

		}

		return ans;
	}
}
