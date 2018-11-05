package com.pecan.hope.amazon;

import java.util.*;

public class CutTrees {
    public int cutOffTree(List<List<Integer>> forest) {
        int res = -1;
        if (forest == null || forest.size() == 0) {
            return res;
        }

        Comparator<int[]> treeComparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return new Integer(t1[2]).compareTo(t2[2]);
            }
        };

        PriorityQueue<int[]> heights = new PriorityQueue<>(treeComparator);

        List<int[]> trees = new ArrayList<>();

        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j++) {
                if (forest.get(i).get(j) > 1) {
                    trees.add(new int[]{i, j, forest.get(i).get(j)});
                }
            }
        }

        Collections.sort(trees, treeComparator);

        res = 0;
        int[] start = new int[]{0, 0, forest.get(0).get(0)};
        while (!trees.isEmpty()) {

            int[] target = trees.get(0);
            trees.remove(0);
            int steps = shortestPath(start, target, forest);
            if (steps == -1) {
                return -1;
            } else {
                res += steps;
            }
            start = target;
        }

        return res;

    }

    // find shorest path from one tree to the other
    // use bfs, dfs cannot be used to find shoretest path in most situations
    private int shortestPath(int[] start, int[] target, List<List<Integer>> forest) {
        Queue<int[]> bfsQueue = new LinkedList<>();
        // x, y, steps so far
        bfsQueue.add(new int[]{start[0], start[1], 0});
        boolean[][] seen = new boolean[forest.size()][forest.get(0).size()];
        seen[start[0]][start[1]] = true;

        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        while (!bfsQueue.isEmpty()) {
            int[] current = bfsQueue.poll();
            if (current[0] == target[0] && current[1] == target[1]) {
                return current[2];
            }

            for (int i = 0; i < dx.length; i++) {
                int x = current[0] + dx[i];
                int y = current[1] + dy[i];

                if (x >= 0 && x < forest.size() && y >= 0 && y < forest.get(0).size() && !seen[x][y] && forest.get(x).get(y) > 0) {
                    bfsQueue.add(new int[]{x, y, current[2] + 1});
                    seen[x][y] = true;
                }
            }

        }

        return -1;
    }
}
