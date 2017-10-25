package com.shilin.hope.followup;

import java.util.Arrays;

/**
 * Given an array of integers, find how many pairs in the array such that their sum is less than or equal to a specific
 * target number. Please return the number of pairs.
 */
public class TwoSumLessOrEqual {
    /**
     * @param nums:   an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum5(int[] nums, int target) {
        // write your code here
        int result = 0;
        if (nums == null) {
            return result;
        }

        int p1 = 0;
        int p2 = nums.length - 1;

        Arrays.sort(nums);

        while (p1 < p2) {
            int sum = nums[p1] + nums[p2];

            if (sum <= target) {
                result += p2 - p1;
                p1++;
            } else {
                p2--;
            }
        }

        return result;
    }
}
