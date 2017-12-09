package com.shilin.hope.yama;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we
 * consider them in the same island. We only consider up/down/left/right adjacent.
 * <p>
 * Find the number of islands that size bigger or equal than K.
 */
public class NumberOfBigIslands {
    // bfs solution
    public int numsofIsland(boolean[][] grid, int k) {
        int res = 0;
        if (grid == null || grid.length == 0 || k < 0) {
            return res;
        }

        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        Queue<int[]> bfs = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    int size = 1;
                    grid[i][j] = false;

                    bfs.offer(new int[]{i, j});

                    while (!bfs.isEmpty()) {
                        int[] pos = bfs.poll();
                        for (int p = 0; p < 4; p++) {
                            int x = pos[0] + dx[p];
                            int y = pos[1] + dy[p];
                            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y]) {
                                size++;
                                grid[x][y] = false;
                                bfs.offer(new int[]{x, y});
                            }
                        }
                    }
                    if (size >= k) res++;
                }
            }
        }

        return res;

    }


    // dfs soltuion
    public int numsofIsland2(boolean[][] grid, int k) {
        // Write your code here
        int res = 0;
        if (grid == null || grid.length == 0 || k < 1) {
            return res;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    grid[i][j] = false;
                    int size = helper(grid, i, j, 1);
                    if (size >= k) res++;
                }
            }
        }

        return res;
    }

    private int helper(boolean[][] grid, int x, int y, int size) {

        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int x1 = x + dx[i];
            int y1 = y + dy[i];

            if (x1 >= 0 && x1 < grid.length && y1 >= 0 && y1 < grid[0].length && grid[x1][y1]) {
                grid[x1][y1] = false;
                size = helper(grid, x1, y1, size) + 1;
            }
        }

        return size;
    }
}
