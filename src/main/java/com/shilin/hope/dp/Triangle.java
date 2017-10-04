package com.shilin.hope.dp;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 * Notice
 * 
 * Bonus point if you are able to do this using only O(n) extra space, where n
 * is the total number of rows in the triangle.
 * 
 * Given the following triangle:

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * 
 * 
 * @author Shilin
 *
 */
public class Triangle {
	/**
	 * @param triangle:
	 *            a list of lists of integers.
	 * @return: An integer, minimum path sum.
	 */
	public int minimumTotal(int[][] triangle) {
		// write your code here
		int min = Integer.MAX_VALUE;
		if (triangle == null || triangle.length == 0) {
			return min;
		}

		for (int i = 1; i < triangle.length; i++) {
			int[] row = triangle[i];
			row[0] = row[0] + triangle[i - 1][0];
			row[row.length - 1] = row[row.length - 1] + triangle[i - 1][triangle[i - 1].length - 1];

			int k = 0;
			for (int j = 1; j < row.length - 1; j++) {
				row[j] = Math.min(triangle[i - 1][k], triangle[i - 1][k + 1]) + row[j];
				k++;
			}
		}

		for (int i : triangle[triangle.length - 1]) {
			if (i < min) {
				min = i;
			}
		}

		return min;
	}
}
