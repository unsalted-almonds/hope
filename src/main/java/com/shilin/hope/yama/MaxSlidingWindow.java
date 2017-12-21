package com.shilin.hope.yama;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very
 * right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * <p>
 * For example, Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * <p>
 * Window position                Max ---------------               ----- [1  3  -1] -3  5  3  6  7       3 1 [3  -1
 * -3] 5  3  6  7       3 1  3 [-1  -3  5] 3  6  7       5 1  3  -1 [-3  5  3] 6  7       5 1  3  -1  -3 [5  3  6] 7
 * 6 1  3  -1  -3  5 [3  6  7]      7 Therefore, return the max sliding window as [3,3,5,5,6,7].
 * <p>
 * Note: You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
 * <p>
 * Follow up: Could you solve it in linear time? Created by Shilin_Gan on 12/20/2017.
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        MaxSlidingWindow test = new MaxSlidingWindow();
        int[] res = test.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(res));

        res = test.maxSlidingWindow(new int[]{1}, 1);
        System.out.println(Arrays.toString(res));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return nums;
        }

        int[] res = new int[nums.length - k + 1];

        Deque<Integer> deck = new LinkedList<>();
        //deck.add(0);

        int idx = 0;
        int head = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            while (!deck.isEmpty() && nums[deck.getLast()] <= current) {
                deck.removeLast();
            }
            while (!deck.isEmpty() && i - deck.getFirst() + 1 > k) {
                deck.removeFirst();
            }
            deck.addLast(i);

            if (i - head + 1 == k) {
                res[idx++] = nums[deck.getFirst()];
                head++;
            }
        }

        return res;
    }

}
