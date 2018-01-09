package com.shilin.hope.yama;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected
 * 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * <p>
 * Count the number of distinct islands. An island is considered to be the same as another if and only if one island can
 * be translated (and not rotated or reflected) to equal the other.
 * <p>
 * Example 1:
 * <p>
 * 11000 11000 00011 00011 Given the above grid map, return 1.
 * <p>
 * Example 2:
 * <p>
 * 11011 10000 00001 11011 Given the above grid map, return 3.
 * <p>
 * Notice that:
 * <p>
 * 11 1 and
 * <p>
 * 1 11 are considered different island shapes, because we do not consider reflection / rotation.
 * <p>
 * Note: The length of each dimension in the given grid does not exceed 50.
 */
public class NumberOfDistinctIslands {

    public static void main(String args[]) {
        int[][] world = new int[][]{{1, 1, 0, 1, 1}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {1, 1, 0, 1, 1}};

        NumberOfDistinctIslands test = new NumberOfDistinctIslands();

        System.out.println(test.solution(world));
    }

    public int solution(int[][] world) {
        int res = 0;
        if (world == null || world.length == 0) {
            return res;
        }

        Set<String> islands = new HashSet<>();

        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        Queue<int[]> bfs = new LinkedList<>();
        boolean[][] visited = new boolean[world.length][world[0].length];

        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[0].length; j++) {

                if (!visited[i][j] && world[i][j] == 1) {
                    bfs.offer(new int[]{i, j});
                    int left = j, right = j, top = i, bottom = i;
                    while (!bfs.isEmpty()) {
                        int[] pos = bfs.poll();
                        visited[pos[0]][pos[1]] = true;
                        left = Math.min(left, pos[1]);
                        right = Math.max(right, pos[1]);
                        top = Math.min(top, pos[0]);
                        bottom = Math.max(bottom, pos[0]);

                        for (int k = 0; k < 4; k++) {
                            int x = pos[0] + dx[k];
                            int y = pos[1] + dy[k];

                            if (x >= 0 && x < world.length && y >= 0 && y < world[0].length && !visited[x][y] && world[x][y] == 1) {
                                bfs.offer(new int[]{x, y});
                            }
                        }

                    }
                    StringBuilder islandData = new StringBuilder();

                    for (int i1 = top; i1 <= bottom; i1++) {
                        for (int j1 = left; j1 <= right; j1++) {
                            islandData.append(world[i1][j1]);
                        }
                        islandData.append("-");
                    }
                    islands.add(islandData.toString());
                }

            }
        }

        return islands.size();
    }

}
