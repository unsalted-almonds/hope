package com.pecan.hope.array;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * You may assume that A has enough space (size that is greater or equal to m +
 * n) to hold additional elements from B. The number of elements initialized in
 * A and B are m and n respectively. Example A = [1, 2, 3, empty, empty], B =
 * [4, 5]
 * 
 * After merge, A will be filled as [1, 2, 3, 4, 5]
 * 
 * @author Shilin
 *
 */
public class MergeSortedArray {
	/**
	 * @param A:
	 *            sorted integer array A which has m elements, but size of A is
	 *            m+n
	 * @param B:
	 *            sorted integer array B which has n elements
	 * @return: void
	 */
	public void mergeSortedArray(int[] A, int m, int[] B, int n) {
		// write your code here
		// [2,4,6, , ,]
		// [10,11,12, , ]
		// [1,3,5]

		// [1,2,,]
		// [3,4]
		// [3,4,,]
		// [1,2]

		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;

		while (i >= 0 && j >= 0) {

			if (A[i] >= B[j]) {
				A[k] = A[i];
				i--;
			} else {
				A[k] = B[j];
				j--;

			}
			k--;

		}

		while (j >= 0) {
			A[k] = B[j];
			j--;
			k--;
		}

	}
}
