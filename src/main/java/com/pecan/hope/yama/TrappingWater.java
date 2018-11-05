package com.pecan.hope.yama;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water
 * it is able to trap after raining.
 * <p>
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class TrappingWater {

    // 灌水问题， 两个指针是王道
    public int trap(int[] height) {
        int res = 0;

        if (height == null || height.length == 0) {
            return res;
        }

        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];

        while (left < right) {

            if (height[left] < height[right]) {
                int nextLeft = height[++left];
                if (nextLeft < leftMax) {
                    res += leftMax - nextLeft;
                } else {
                    leftMax = nextLeft;
                }
            } else {
                int prevRight = height[--right];
                if (prevRight < rightMax) {
                    res += rightMax - prevRight;
                } else {
                    rightMax = prevRight;
                }
            }
        }

        return res;
    }

    // naive
    public int trap2(int[] height) {
        int res = 0;

        if (height == null || height.length == 0) {
            return res;
        }

        int currentHeight = 0;

        for (int h : height) {
            currentHeight = Math.max(h, currentHeight);
        }

        // scan from top to bottom
        while (currentHeight > 0) {
            int start = -1;

            for (int i = 0; i < height.length; i++) {
                if (height[i] >= currentHeight) {
                    if (start == -1) {
                        start = i;
                        continue;
                    }
                    res += i - start - 1;
                    start = i;
                }
            }
            currentHeight--;
        }

        return res;
    }
}
