package com.pecan.hope.dp;

/*
 * Give an integer array£¬find the longest increasing continuous subsequence in this array.

An increasing continuous subsequence:

Can be from right to left or from left to right.
Indices of the integers in the subsequence should be continuous.
 Notice

O(n) time and O(1) extra space.

Have you met this question in a real interview? Yes
Example
For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.

For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.
 * */
public class LICS {
	/*
	 * @param A: An array of Integer
	 * 
	 * @return: an integer
	 */
	public int longestIncreasingContinuousSubsequence(int[] A) {
		// write your code here
		int max = 0;
		if (A == null || A.length == 0) {
			return max;
		}

		max = 1;
		int current = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] >= A[i - 1]) {
				if (++current > max) {
					max = current;
				}
			} else {
				current = 1;
			}

		}

		int reverseMax = 1;
		current = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] <= A[i - 1]) {
				if (++current > reverseMax) {
					reverseMax = current;
				}
			} else {
				current = 1;
			}

		}

		return Math.max(max, reverseMax);
	}
}
