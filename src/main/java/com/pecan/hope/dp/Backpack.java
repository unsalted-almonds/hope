package com.pecan.hope.dp;

/**
 * Given n items with size Ai, an integer m denotes the size of a backpack. How
 * full you can fill this backpack?
 * 
 * Example If we have 4 items with size [2, 3, 5, 7], the backpack size is 11,
 * we can select [2, 3, 5], so that the max size we can fill this backpack is
 * 10. If the backpack size is 12. we can select [2, 3, 7] so that we can
 * fulfill the backpack.
 * 
 * You function should return the max size we can fill in the given backpack.
 * 
 * @author Shilin
 *
 */
public class Backpack {
	/**
	 * @param m:
	 *            An integer m denotes the size of a backpack
	 * @param A:
	 *            Given n items with size A[i]
	 * @return: The maximum size
	 */
	public int backPack(int m, int[] A) {
		// write your code here

		if (m < 0 || A == null) {
			return 0;
		}

		// solution for i items in size j backpack
		int[][] solution = new int[A.length + 1][m + 1];

		for (int i = 1; i < solution.length; i++) {
			for (int j = 1; j < solution[0].length; j++) {
				if (A[i - 1] <= j) {
					solution[i][j] = Math.max(solution[i - 1][j], solution[i - 1][j - A[i - 1]] + A[i - 1]);
				} else {
					solution[i][j] = solution[i - 1][j];
				}
			}
		}

		return solution[solution.length - 1][solution[0].length - 1];

	}
}
