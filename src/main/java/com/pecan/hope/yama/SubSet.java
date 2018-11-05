package com.pecan.hope.yama;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * For example, If nums = [1,2,3], a solution is:
 * <p>
 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 */
public class SubSet {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return res;
        }

        helper(nums, 0, new ArrayList<>(), res);

        return res;
    }

    private void helper(int[] nums, int start, List<Integer> subset, List<List<Integer>> res) {
        // empty set is also a subset
        res.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            helper(nums, i + 1, subset, res);
            subset.remove(subset.size() - 1);
        }
    }
}
