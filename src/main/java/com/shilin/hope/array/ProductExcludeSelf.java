package com.shilin.hope.array;

import java.util.ArrayList;

/**
 * Given an integers array A.
 * 
 * Define B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1], calculate B
 * WITHOUT divide operation. Example For A = [1, 2, 3], return [6, 3, 2].
 * 
 * @author Shilin
 *
 */
public class ProductExcludeSelf {
	/**
	 * @param A:
	 *            Given an integers array A
	 * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... *
	 *          A[n-1]
	 */
	public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
		// write your code

		// A[1, 2, 3]
		// B[2*3,1*3, 1*2 ]

		long[] reverseProduct = new long[A.size()];
		reverseProduct[A.size() - 1] = A.get(A.size() - 1);

		for (int i = A.size() - 2; i >= 0; i--) {
			reverseProduct[i] = A.get(i) * reverseProduct[i + 1];
		}

		ArrayList<Long> ans = new ArrayList<Long>();

		long product = 1;

		for (int i = 0; i < A.size(); i++) {

			if (i < A.size() - 1) {
				ans.add(product * reverseProduct[i + 1]);
				product = A.get(i) * product;
			} else {
				ans.add(product);
			}
		}

		return ans;

	}
}
