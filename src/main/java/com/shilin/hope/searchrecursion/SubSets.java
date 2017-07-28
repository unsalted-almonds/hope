package com.shilin.hope.searchrecursion;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSets {
	
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (nums == null || nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        
        Arrays.sort(nums);
        
        helper(result, new ArrayList<Integer>(), 0, nums);
        
        return result;
        
    }
    
    
    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> solution, int start, int[] nums) {
        result.add(new ArrayList<Integer>(solution));
        
        for (int i = start; i < nums.length; i++) {
            solution.add(nums[i]);
            helper(result, solution, i + 1, nums);
            solution.remove(solution.size() - 1);
        }
    }

}
