package com.pecan.hope.searchrecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of numbers with duplicate number in it. Find all unique
 * permutations.
 * 
 * Example For numbers [1,2,2] the unique permutations are:
 * 
 * [ [1,2,2], [2,1,2], [2,2,1] ]
 * 
 * @author Shilin
 *
 */
public class PermutationsII {
	/**
	 * @param nums:
	 *            A list of integers.
	 * @return: A list of unique permutations.
	 */
	public List<List<Integer>> permuteUnique(int[] nums) {
		// Write your code here
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (nums == null || nums.length == 0) {
			result.add(new ArrayList<Integer>());
			return result;
		}

		Arrays.sort(nums);
		// since there are duplicates, array must be used instead of set
		boolean[] visited = new boolean[nums.length];
		helper(result, new ArrayList<Integer>(nums.length), nums, visited);

		return result;
	}

	private void helper(List<List<Integer>> result, List<Integer> solution, int[] nums, boolean[] visited) {
		if (solution.size() == nums.length) {
			result.add(new ArrayList<Integer>(solution));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
				continue;
			}

			solution.add(nums[i]);
			visited[i] = true;
			helper(result, solution, nums, visited);
			solution.remove(solution.size() - 1);
			visited[i] = false;
		}
	}
}
