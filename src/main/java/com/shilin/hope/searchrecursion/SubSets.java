package com.shilin.hope.searchrecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets {

    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Arrays.sort(nums);
        helper(nums, 0, result, new ArrayList<Integer>());

        return result;
    }

    private void helper(int[] nums, int start, List<List<Integer>> result, List<Integer> sub) {

        result.add(new ArrayList<Integer>(sub));

        for (int i = start; i < nums.length; i++) {
            sub.add(nums[i]);
            helper(nums, i + 1, result, sub);
            sub.remove(sub.size() - 1);
        }
    }

}
