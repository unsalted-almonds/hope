package com.pecan.hope.yama;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example: Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1]. Created by Shilin_Gan on 11/29/2017.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] res = new int[2];

        Map<Integer, Integer> diff = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (diff.containsKey(nums[i])) {
                res[0] = diff.get(nums[i]);
                res[1] = i;
                return res;
            }

            diff.put(target - nums[i], i);
        }

        return null;
    }
}
