package com.shilin.hope.yama;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example 1:

 11110
 11010
 11000
 00000
 Answer: 1

 Example 2:

 11000
 11000
 00100
 00011
 Answer: 3
 */
public class NumberOfIslands {
    /*
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0) {
            return res;
        }

        for (int i = 0;i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    res++;
                    helper(i, j, grid);
                }
            }
        }
        return res;
    }

    private void helper(int x, int y, boolean[][] grid) {

        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int tmpX = x + dx[i];
            int tmpY = y + dy[i];
            if (tmpX >= 0 && tmpX < grid.length && tmpY >= 0 && tmpY < grid[0].length && grid[tmpX][tmpY]) {
                grid[tmpX][tmpY] = false;
                helper(tmpX, tmpY, grid);
            }

        }

    }

    public int numIslands2(boolean[][] grid) {
        // write your code here
        int res = 0;
        if (grid == null || grid.length == 0) {
            return res;
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j]) {
                    res++;
                    visited[i][j] = true;
                    helper2(i, j, grid, visited);
                } else {
                    visited[i][j] = true;
                }
            }
        }

        return res;

    }

    private void helper2(int x, int y, boolean[][] grid, boolean[][] visited) {

        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int tmpX = x + dx[i];
            int tmpY = y + dy[i];

            if (tmpX >= 0 && tmpX < grid.length && tmpY >= 0 && tmpY < grid[0].length) {

                if (visited[tmpX][tmpY] || !grid[tmpX][tmpY]) {
                    continue;
                }
                visited[tmpX][tmpY] = true;
                helper2(tmpX, tmpY, grid, visited);
            }

        }

    }
}
