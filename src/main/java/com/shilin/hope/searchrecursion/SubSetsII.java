package com.shilin.hope.searchrecursion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a list of numbers that may has duplicate numbers, return all possible
 * subsets
 * 
 * Notice
 * 
 * Each element in a subset must be in non-descending order. The ordering
 * between two subsets is free. The solution set must not contain duplicate
 * subsets.
 * 
 * Example If S = [1,2,2], a solution is:
 * 
 * [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 * 
 * @author Shilin
 *
 */
public class SubSetsII {
	
	public static void main(String args[]){
		System.out.println(new SubSetsII().subsetsWithDup(new int[]{1,2}));
		
	}
	/**
	 * @param nums:
	 *            A set of numbers.
	 * @return: A list of lists. All valid subsets.
	 */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        
        if (nums == null || nums.length == 0) {
            // at least an empty subset
            result.add(new ArrayList<Integer>());
            return result;
        }
        
        Arrays.sort(nums);
        
        helper(result, new ArrayList<Integer>(), 0,  nums);
        
        return result;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> solution, int start, int[] nums) {
        
        result.add(new ArrayList<Integer>(solution));
        
        for (int i = start; i < nums.length; i++){
            if (i != start && nums[i]==nums[i-1]) {
                continue;
            }

            solution.add(nums[i]);
            helper(result, solution, i + 1, nums);
            solution.remove(solution.size()-1);
        }
    }
}
