package com.pecan.hope.binarysearch;

/**
 * Given a sorted array of n integers, find the starting and ending position of
 * a given target value.
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 * @author Shilin
 *
 */
public class SearchForRange {
	/**
	 * @param A
	 *            : an integer sorted array
	 * @param target
	 *            : an integer to be inserted return : a list of length 2,
	 *            [index1, index2]
	 */
	public int[] searchRange(int[] A, int target) {
		// write your code here

		int start = -1;
		int end = -1;

		if (A == null || A.length == 0) {
			return new int[] { start, end };
		}

		int left = 0;
		int right = A.length - 1;

		// [1 2 3 4 5 5 5 5 5 5 6 7 8 9]

		// left bound
		while (left + 1 < right) {

			int mid = left + (right - left) / 2;

			if (A[mid] < target) {
				left = mid;
			} else {
				right = mid;
			}
		}

		// it's important to first check left!!!
		if (A[left] == target) {
			start = left;
		} else if (A[right] == target) {
			start = right;
		} else {
			return new int[] { start, end };
		}

		left = 0;
		right = A.length - 1;

		// right bound
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;

			if (A[mid] <= target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		// it's important to first check right!!!
		if (A[right] == target) {
			end = right;
		} else {
			end = left;
		}

		return new int[] { start, end };

	}
}
