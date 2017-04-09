package com.shilin.hope.binarysearch;

/**
 * There is an integer array which has the following features:
 * 
 * The numbers in adjacent positions are different. A[0] < A[1] && A[A.length -
 * 2] > A[A.length - 1]. We define a position P is a peek if:
 * 
 * A[P] > A[P-1] && A[P] > A[P+1] Find a peak element in this array. Return the
 * index of the peak.
 * 
 * Example Given [1, 2, 1, 3, 4, 5, 7, 6]
 * 
 * Return index 1 (which is number 2) or 6 (which is number 7)
 * 
 * @author Shilin_Gan
 *
 */
public class FindPeakElement {
	/**
	 * @param A:
	 *            An integers array.
	 * @return: return any of peek positions.
	 */
	public int findPeak(int[] A) {
		// write your code here

		if (A == null || A.length == 0) {
			return -1;
		}

		// n is easy for sure
		// logn is desired, so binary search

		int left = 0;
		int right = A.length - 1;

		while (left + 1 < right) {

			int mid = left + (right - left) / 2;

			if (A[mid] <= A[left]) {
				right = mid - 1;
			} else if (A[mid] <= A[right]) {
				left = mid + 1;
			} else {
				if (A[mid - 1] < A[mid]) {
					left = mid;
				} else {
					right = mid - 1;
				}
			}

		}

		if (A[left] < A[right]) {
			return right;
		} else {
			return left;
		}
	}
}
