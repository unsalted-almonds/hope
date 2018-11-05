package com.pecan.hope.amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a MxN matrix where each element can either be 0 or 1. We need to find the shortest path between
 * a given source cell to a destination cell. The path can only be created out of a cell if its value is 1.

 Expected time complexity is O(MN).

 For example –

 Input:
 mat[ROW][COL]  = {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
 {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
 {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
 {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
 {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
 {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
 {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
 {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
 {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};
 Source = {0, 0};
 Destination = {3, 4};

 Output:
 Shortest Path is 11
 */
public class MiniStepMaze {

    public static void main(String[] args) {

        MiniStepMaze test = new MiniStepMaze();

        int[][] maze = {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};
        int[] start = {0, 0};
        int[] target = {3, 4};

        System.out.println(test.solution(maze, start, target));

    }

    public int solution(int[][] maze, int[] start, int[] target) {
        int res = -1;
        if (maze == null || maze.length == 0 || start == null || start.length == 0 || target == null || target.length == 0) {
            return res;
        }

        res = helper(start, target, maze);

        return res;
    }

    // for using bfs for shortest path, once find the target, the effort is shortest path
    private int helper(int[] start, int[] target, int[][] maze) {
        Queue<int[]> bfsQueue = new LinkedList<>();
        boolean[][] seen = new boolean[maze.length][maze[0].length];
        bfsQueue.add(new int[]{start[0], start[1], 0});
        seen[start[0]][start[1]] = true;

        int[] dx = new int[]{0, 0 , -1, 1};
        int[] dy = new int[]{-1, 1, 0, 0};
        while (!bfsQueue.isEmpty()) {
            int[] current = bfsQueue.poll();
            if (current[0] == target[0] && current[1] == target[1]) {
                return current[2];
            }
            for (int i = 0; i < dx.length; i++) {
                int x = current[0] + dx[i];
                int y = current[1] + dy[i];

                if (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && !seen[x][y] && maze[x][y] == 1) {
                    bfsQueue.add(new int[]{x, y, current[2] + 1});
                    seen[x][y] = true;
                }
            }
        }

        return -1;
    }
}
