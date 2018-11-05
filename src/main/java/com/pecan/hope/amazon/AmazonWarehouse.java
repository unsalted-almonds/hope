package com.pecan.hope.amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 找到离用户最近的warehouse a b c d e 每一个warehouse最初都是空的，需要从root（a）送货，比如现在用户需要一个产品， 他的住址离d最近，需要做的是从a送到d，但是现在用户改地址了，他离c近了，现在有两种选择，
 * 要么就是从d送到c，要么就是从a送到c，问怎么决定从哪个节点送到离客户最近的节点， input是（root，srcNode，targetNode）, 输出送货点
 * <p>
 * 链接: https://instant.1point3acres.com/thread/276830/post/2451973 来源: 一亩三分地
 */
public class AmazonWarehouse {

    public static void main(String args[]) {

        AmazonWarehouse test = new AmazonWarehouse();
        Integer[][] res = test.solution(new Integer[][]{{1, 2}, {3, 4}, {1, 5}, {3, 9}}, 3);

        System.out.println(Arrays.deepToString(res));

    }


    public Integer[][] solution(Integer[][] points, int n) {

        Comparator<Location> locComparator = new Comparator<Location>() {
            @Override
            public int compare(Location o1, Location o2) {
                return o1.distance.compareTo(o2.distance);
            }
        };

        PriorityQueue<Location> pq = new PriorityQueue<>(locComparator);

        for (Integer[] loc : points) {
            pq.offer(new Location(loc));
        }

        Integer[][] res = new Integer[n][];

        int i = 0;
        while (n > 0) {
            res[i] = pq.poll().cor;
            i++;
            n--;
        }

        return res;
    }

    private static class Location {

        Integer[] cor;
        Double distance;

        public Location(Integer[] cor) {
            this.cor = cor;
            this.distance = Math.sqrt(cor[0] * cor[0] + cor[1] * cor[1]);
        }

    }

}
