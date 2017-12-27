package com.shilin.hope.yama;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in
 * the array which gives the sum of zero.
 * <p>
 * Note: The solution set must not contain duplicate triplets.
 * <p>
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 */
public class ThreeSum {

    // convert 3sum into 2sum
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return res;
        }

        int current = 0;
        Arrays.sort(nums);

        while (current < nums.length - 2) {
            int left = current + 1, right = nums.length - 1;

            int target = 0 - nums[current];
            while (left < right) {

                int sum = nums[left] + nums[right];
                if (sum == target) {
                    res.add(Arrays.asList(nums[current], nums[left], nums[right]));
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }

            current++;
            while (current < nums.length && nums[current] == nums[current - 1]) current++;
        }

        return res;
    }
}
