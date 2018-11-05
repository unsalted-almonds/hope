package com.pecan.hope.binarysearch;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Example For [4, 5, 1, 2, 3] and target=1, return 2.
 * 
 * For [4, 5, 1, 2, 3] and target=0, return -1.
 * 
 * @author Shilin
 *
 */
public class SearchRotatedSortedArray {
	/**
	 * @param A
	 *            : an integer rotated sorted array
	 * @param target
	 *            : an integer to be searched return : an integer
	 */
	public int search(int[] A, int target) {
		// write your code here

		if (A == null || A.length == 0) {
			return -1;
		}

		int left = 0;
		int right = A.length - 1;

		while (left + 1 < right) {

			int mid = left + (right - left) / 2;

			// if right side is sorted
			// [50 60 0 10 20 30 40]
			if (A[mid] <= A[right]) {
				if (A[mid] > target) {
					right = mid;
				} else {
					if (A[right] < target) {
						right = mid;
					} else {
						left = mid;
					}
				}
			}
			// if left side is sorted
			// [30 40 50 60 0 10 20]
			else {
				if (A[mid] < target) {
					left = mid;
				} else {
					if (A[left] > target) {
						left = mid;
					} else {
						right = mid;
					}
				}
			}
		}

		if (A[left] == target) {
			return left;
		} else if (A[right] == target) {
			return right;
		} else {
			return -1;
		}

	}
}
