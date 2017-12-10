package com.shilin.hope.yama;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Given a non-empty 2D array grid of 0’s and 1’s, an island is a group of 1‘s (representing land) connected
 * 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * <p>
 * Count the number of distinct islands. An island is considered to be the same as another if they have the same shape,
 * or have the same shape after rotation (90, 180, or 270 degrees only) or reflection (left/right direction or up/down
 * direction).
 */
public class NumberOfDistinctIslandsII {

    public static void main(String[] args) {

        /**
         * 1, 1, 0, 1, 1
         * 1, 0, 0, 0, 0
         * 0, 0, 0, 0, 1
         * 1, 1, 0, 1, 1
         */
        int[][] world = new int[][]{{1, 1, 0, 1, 1, 0, 1, 1}, {1, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 1, 0, 0, 0}};

        NumberOfDistinctIslandsII test = new NumberOfDistinctIslandsII();

        System.out.println(test.solution(world));

    }

    public int solution(int[][] world) {
        int res = 0;

        if (world == null || world.length == 0) {
            return res;
        }

        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        Queue<int[]> bfs = new LinkedList<>();
        boolean[][] visited = new boolean[world.length][world[0].length];
        Set<String> islands = new HashSet<>();

        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[0].length; j++) {
                if (!visited[i][j] && world[i][j] == 1) {
                    List<Point> points = new ArrayList<>();
                    //points.add(new Point(i, j));
                    bfs.offer(new int[]{i, j});
                    int left = j, right = j, top = i, bottom = i;
                    // int top = i, left = j;
                    while (!bfs.isEmpty()) {
                        int[] pos = bfs.poll();
                        points.add(new Point(pos[0], pos[1]));
                        visited[pos[0]][pos[1]] = true;
                        left = Math.min(left, j);
                        right = Math.max(right, j);
                        top = Math.min(top, i);
                        bottom = Math.max(bottom, i);

                        for (int k = 0; k < 4; k++) {
                            int x = pos[0] + dx[k];
                            int y = pos[1] + dy[k];

                            if (x >= 0 && x < world.length && y >= 0 && y < world[0].length && !visited[x][y] && world[x][y] == 1) {
                                bfs.offer(new int[]{x, y});
                            }
                        }
                    }

                    // original
                    for (Point point : points) {
                        point.x = point.x - top;
                        point.y = point.y - left;
                    }
                    System.out.println("original points " + points);
                    List<Point> tmpIsland = deepCopyPoints(points);

                    if (islands.contains(tmpIsland.toString())) {
                        continue;
                    }

                    // rotate three times
                    int rotation = 0;

                    while (rotation < 3) {
                        int newTop = Integer.MAX_VALUE;
                        int newLeft = Integer.MAX_VALUE;
                        for (Point point : tmpIsland) {
                            int tmp = point.x;
                            point.x = point.y;
                            point.y = right - left + 1 - tmp;
                            newTop = Math.min(newTop, point.x);
                            newLeft = Math.min(newLeft, point.y);
                        }

                        for (Point point : tmpIsland) {
                            point.x = point.x - newTop;
                            point.y = point.y - newLeft;
                        }
                        Collections.sort(tmpIsland);
                        System.out.println("rotation " + tmpIsland);
                        if (islands.contains(tmpIsland.toString())) {
                            break;
                        }
                        rotation++;
                    }

                    if (rotation < 3) {
                        continue;
                    }

                    tmpIsland = deepCopyPoints(points);

                    // reflection
                    // up/down
                    int newTop = Integer.MAX_VALUE;
                    int newLeft = left;
                    for (Point point : tmpIsland) {
                        point.x = bottom - top + 1 - point.x;
                        newTop = Math.min(newTop, point.x);
                    }

                    for (Point point : tmpIsland) {
                        point.x = point.x - newTop;
                        point.y = point.y - newLeft;
                    }

                    Collections.sort(tmpIsland);

                    if (islands.contains(tmpIsland.toString())) {
                        continue;
                    }

                    tmpIsland = deepCopyPoints(points);

                    // left/right
                    newTop = top;
                    newLeft = Integer.MAX_VALUE;
                    for (Point point : tmpIsland) {
                        point.y = right - left + 1 - point.y;
                        newLeft = Math.min(newLeft, point.y);
                    }

                    Collections.sort(tmpIsland);

                    if (islands.contains(tmpIsland.toString())) {
                        continue;
                    }

                    islands.add(points.toString());
                    System.out.println("added " + points.toString());
                }
            }
        }

        System.out.println(islands);
        return islands.size();
    }

    private List<Point> deepCopyPoints(List<Point> points) {
        List<Point> res = new ArrayList<>();

        for (Point point : points) {
            res.add(new Point(point.x, point.y));
        }

        return res;
    }

    static class Point implements Comparable{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "-" + x + "-" + y + "-";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }


        @Override
        public int compareTo(@NotNull Object o) {
            Point other =(Point) o;

            if (new Integer(this.x).compareTo(other.x) != 0) {
                return new Integer(this.x).compareTo(other.x);
            }

            return new Integer(this.y).compareTo(other.y);
        }
    }

}
