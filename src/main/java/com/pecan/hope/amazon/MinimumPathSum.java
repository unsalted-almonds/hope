package com.pecan.hope.amazon;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the
 * sum of all numbers along its path.
 * <p>
 * Notice
 * <p>
 * You can only move either down or right at any point in time.
 */
public class MinimumPathSum {

    int result = Integer.MAX_VALUE;

    public int minPathSum(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int[][] solution = new int[grid.length][grid[0].length];

        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[0].length; j++) {
                int above = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;

                if (i > 0) {
                    above = solution[i - 1][j];
                }

                if (j > 0) {
                    left = solution[i][j - 1];
                }

                if (i == 0 && j == 0) {
                    above = 0;
                    left = 0;
                }

                solution[i][j] = Math.min(above, left) + grid[i][j];

            }
        }

        return solution[solution.length - 1][solution[0].length - 1];
    }

    // this uses too much time, this is a wrong example
    public int minPathSum2(int[][] grid) {
        // write your code here
        int res = 0;
        if (grid == null || grid.length == 0) {
            return res;
        }

        int[] start = new int[]{0, 0, grid[0][0]};
        int[] target = new int[]{grid.length - 1, grid[0].length - 1, grid[grid.length - 1][grid[0].length - 1]};

        helper(start, target, grid, grid[0][0]);

        return result;
    }

    private void helper(int[] start, int[] target, int[][] grid, Integer sum) {
        if (start[0] == target[0] && start[1] == target[1]) {
            result = Math.min(result, sum);
            return;
        }

        int[] dx = new int[]{1, 0};
        int[] dy = new int[]{0, 1};

        for (int i = 0; i < dx.length; i++) {
            int x = start[0] + dx[i];
            int y = start[1] + dy[i];

            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
                sum += grid[x][y];
                helper(new int[]{x, y, grid[x][y]}, target, grid, sum);
                sum -= grid[x][y];
            }
        }
    }

}
