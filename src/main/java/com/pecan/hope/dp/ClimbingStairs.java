package com.pecan.hope.dp;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Given an example n=3 , 1+1+1=2+1=1+2=3
 * <p>
 * return 3
 *
 * @author Shilin
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        // write your code here

        if (n <= 0) {
            return 1;
        }

        int[] ways = new int[n + 1];

        ways[0] = 0;
        if (n >= 1)
            ways[1] = 1;
        if (n >= 2)
            ways[2] = 2;

        for (int i = 3; i <= n; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }

        return ways[n];

    }
}
