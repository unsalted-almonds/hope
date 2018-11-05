package com.pecan.hope.amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given some points and a point origin in two dimensional space, find k points out of the some points which are nearest to origin.
 * Return these points sorted by distance, if they are same with distance, sorted by x-axis, otherwise sorted by y-axis.
 * <p>
 * Have you met this question in a real interview? Yes
 * Example
 * Given points = [[4,6],[4,7],[4,4],[2,5],[1,1]], origin = [0, 0], k = 3
 * return [[1,1],[2,5],[4,4]]
 * Created by Shilin_Gan on 11/14/2017.
 */
public class KCloestPoints {
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k:      An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        if (points == null || points.length == 0 || k <= 0) {
            return null;
        }

        Comparator<Point> pointComparator = new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                Long p1Distance = new Long((p1.x - origin.x) * (p1.x - origin.x) + (p1.y - origin.y) * (p1.y - origin.y));
                Long p2Distance = new Long((p2.x - origin.x) * (p2.x - origin.x) + (p2.y - origin.y) * (p2.y - origin.y));

                int distanceCompare = p1Distance.compareTo(p2Distance);

                if (distanceCompare != 0) {
                    return distanceCompare;
                }

                int xCompare = new Integer(p1.x).compareTo(new Integer(p2.x));
                return xCompare;
            }
        };

        PriorityQueue<Point> pq = new PriorityQueue<>(pointComparator);

        for (Point point : points) {
            pq.offer(point);
        }

        Point[] res = new Point[k];

        int i = 0;
        while (k-- > 0) res[i++] = pq.poll();

        return res;
    }

    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}
