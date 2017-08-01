package com.shilin.hope.searchrecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of numbers, return all possible permutations.
 * 
 * Notice
 * 
 * You can assume that there is no duplicate numbers in the list.
 * 
 * Example For nums = [1,2,3], the permutations are:
 * 
 * [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 * 
 * @author Shilin
 *
 */
public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		// write your code here
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (nums == null || nums.length == 0) {
			return result;
		}

		Arrays.sort(nums);

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
			if (visited[i]) {
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
