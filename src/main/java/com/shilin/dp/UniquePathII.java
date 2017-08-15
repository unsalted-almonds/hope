package com.shilin.dp;

/**
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example, There is one obstacle in the middle of a 3x3 grid as illustrated
 * below.
 * 
 * [ [0,0,0], [0,1,0], [0,0,0] ] The total number of unique paths is 2.
 * 
 * @author Shilin
 *
 */
public class UniquePathII {
	/**
	 * @param obstacleGrid:
	 *            A list of lists of integers
	 * @return: An integer
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		// write your code here

		int result = 0;

		if (obstacleGrid == null || obstacleGrid.length == 0) {
			return result;
		}

		int[][] pathSofar = new int[obstacleGrid.length][obstacleGrid[0].length];

		for (int i = 0; i < obstacleGrid.length; i++) {
			for (int j = 0; j < obstacleGrid[0].length; j++) {
				if (obstacleGrid[i][j] == 1) {
					continue;
				}

				if (i == 0 && j == 0) {
					pathSofar[i][j] = 1;
					continue;
				}

				// from top
				int top = 0;
				if (i - 1 >= 0) {
					top = pathSofar[i - 1][j];
				}

				// from left
				int left = 0;
				if (j - 1 >= 0) {
					left = pathSofar[i][j - 1];
				}

				pathSofar[i][j] = top + left;
			}
		}

		return pathSofar[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
	}
}
