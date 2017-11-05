package com.shilin.hope.searchrecursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list of numbers that may has duplicate numbers, return all possible subsets
 * <p>
 * Notice
 * <p>
 * Each element in a subset must be in non-descending order. The ordering between two subsets is free. The solution set
 * must not contain duplicate subsets.
 * <p>
 * Example If S = [1,2,2], a solution is:
 * <p>
 * [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 *
 * @author Shilin
 */
public class SubSetsII {

    public static void main(String args[]) {
        System.out.println(new SubSetsII().subsetsWithDup(new int[]{1, 2}));

    }

    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null) {
            return result;
        }

        helper(nums, result, new ArrayList<Integer>(), 0);
        return result;
    }

    private void helper(int[] nums, List<List<Integer>> result, List<Integer> sub, int start) {

        result.add(new ArrayList<>(sub));

        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i - 1] == nums[i]) {
                continue;
            }
            sub.add(nums[i]);
            helper(nums, result, sub, i + 1);
            sub.remove(sub.size() - 1);
        }
    }
}
